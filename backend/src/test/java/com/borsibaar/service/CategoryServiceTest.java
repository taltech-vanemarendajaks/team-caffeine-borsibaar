package com.borsibaar.service;

import com.borsibaar.dto.CategoryRequestDto;
import com.borsibaar.dto.CategoryResponseDto;
import com.borsibaar.entity.Category;
import com.borsibaar.exception.BadRequestException;
import com.borsibaar.exception.DuplicateResourceException;
import com.borsibaar.exception.NotFoundException;
import com.borsibaar.mapper.CategoryMapper;
import com.borsibaar.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryService categoryService;

    private CategoryRequestDto request;

    @BeforeEach
    void setUp() {
        request = new CategoryRequestDto("  Drinks  ", null);
    }

    @Test
    void create_Success_TrimsNameSetsDefaults() {
        Category entity = new Category();
        when(categoryMapper.toEntity(request)).thenReturn(entity);
        when(categoryRepository.existsByOrganizationIdAndNameIgnoreCase(1L, "Drinks")).thenReturn(false);
        Category saved = new Category();
        saved.setId(10L);
        saved.setName("Drinks");
        saved.setDynamicPricing(true);
        when(categoryRepository.save(entity)).thenReturn(saved);
        when(categoryMapper.toResponse(saved)).thenReturn(new CategoryResponseDto(10L, "Drinks", true));

        CategoryResponseDto dto = categoryService.create(request, 1L);

        assertEquals("Drinks", dto.name());
        assertTrue(dto.dynamicPricing());
        ArgumentCaptor<Category> captor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(captor.capture());
        assertEquals("Drinks", captor.getValue().getName());
        assertEquals(1L, captor.getValue().getOrganizationId());
    }

    @Test
    void create_BlankName_ThrowsBadRequest() {
        CategoryRequestDto bad = new CategoryRequestDto("   ", null);
        when(categoryMapper.toEntity(bad)).thenReturn(new Category());
        assertThrows(BadRequestException.class, () -> categoryService.create(bad, 1L));
    }

    @Test
    void create_Duplicate_ThrowsDuplicateResource() {
        when(categoryMapper.toEntity(request)).thenReturn(new Category());
        when(categoryRepository.existsByOrganizationIdAndNameIgnoreCase(1L, "Drinks")).thenReturn(true);
        assertThrows(DuplicateResourceException.class, () -> categoryService.create(request, 1L));
    }

    @Test
    void getAllByOrg_ReturnsMappedList() {
        Category c1 = new Category(); c1.setId(1L); c1.setName("A");
        Category c2 = new Category(); c2.setId(2L); c2.setName("B");
        when(categoryRepository.findAllByOrganizationId(1L)).thenReturn(List.of(c1, c2));
        when(categoryMapper.toResponse(c1)).thenReturn(new CategoryResponseDto(1L, "A", true));
        when(categoryMapper.toResponse(c2)).thenReturn(new CategoryResponseDto(2L, "B", false));

        var list = categoryService.getAllByOrg(1L);
        assertEquals(2, list.size());
    }

    @Test
    void getByIdAndOrg_NotFound_Throws() {
        when(categoryRepository.findByIdAndOrganizationId(9L, 1L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> categoryService.getByIdAndOrg(9L, 1L));
    }

    @Test
    void getByIdAndOrg_Success_ReturnsDto() {
        Category category = new Category();
        category.setId(10L);
        category.setName("Test Category");
        category.setDynamicPricing(true);

        when(categoryRepository.findByIdAndOrganizationId(10L, 1L)).thenReturn(Optional.of(category));
        when(categoryMapper.toResponse(category)).thenReturn(new CategoryResponseDto(10L, "Test Category", true));

        CategoryResponseDto result = categoryService.getByIdAndOrg(10L, 1L);

        assertEquals(10L, result.id());
        assertEquals("Test Category", result.name());
        assertTrue(result.dynamicPricing());
        verify(categoryMapper).toResponse(category);
    }

    @Test
    void deleteReturningDto_Success_Deletes() {
        Category cat = new Category(); cat.setId(5L); cat.setName("Del");
        when(categoryRepository.findByIdAndOrganizationId(5L, 1L)).thenReturn(Optional.of(cat));
        when(categoryMapper.toResponse(cat)).thenReturn(new CategoryResponseDto(5L, "Del", true));

        CategoryResponseDto dto = categoryService.deleteReturningDto(5L, 1L);
        assertEquals(5L, dto.id());
        verify(categoryRepository).delete(cat);
    }
}

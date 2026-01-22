package com.borsibaar.service;

import com.borsibaar.dto.CategoryRequestDto;
import com.borsibaar.dto.CategoryResponseDto;
import com.borsibaar.entity.Category;
import com.borsibaar.exception.BadRequestException;
import com.borsibaar.exception.DuplicateResourceException;
import com.borsibaar.exception.NotFoundException;
import com.borsibaar.mapper.CategoryMapper;
import com.borsibaar.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional
    public CategoryResponseDto create(CategoryRequestDto request, Long organizationId) {
        Category category = categoryMapper.toEntity(request);

        category.setOrganizationId(organizationId);

        String normalizedName = request.name() == null ? null : request.name().trim();
        if (normalizedName == null || normalizedName.isEmpty()) {
            throw new BadRequestException("Category name must not be blank");
        }
        category.setName(normalizedName);

        boolean dynamicPricing = request.dynamicPricing() != null ? request.dynamicPricing() : true;
        category.setDynamicPricing(dynamicPricing);

        if (categoryRepository.existsByOrganizationIdAndNameIgnoreCase(organizationId, normalizedName)) {
            throw new DuplicateResourceException("Category '" + normalizedName + "' already exists");
        }

        Category saved = categoryRepository.save(category);
        return categoryMapper.toResponse(saved);
    }

    @Transactional
    public List<CategoryResponseDto> getAllByOrg(Long organizationId) {
        Iterable<Category> categories = categoryRepository.findAllByOrganizationId(organizationId);

        List<CategoryResponseDto> responseDtos = new ArrayList<>();
        for (Category category : categories) {
            responseDtos.add(categoryMapper.toResponse(category));
        }

        return responseDtos;
    }

    @Transactional
    public CategoryResponseDto getByIdAndOrg(Long id, Long organizationId) {
        return categoryRepository.findByIdAndOrganizationId(id, organizationId)
                .map(categoryMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Category not found: " + id));
    }

    @Transactional
    public CategoryResponseDto deleteReturningDto(Long id, Long organizationId) {
        return categoryRepository.findByIdAndOrganizationId(id, organizationId)
                .map(category -> {
                    CategoryResponseDto dto = categoryMapper.toResponse(category);
                    categoryRepository.delete(category);
                    return dto;
                })
                .orElseThrow(() -> new NotFoundException("Category not found: " + id));
    }
}

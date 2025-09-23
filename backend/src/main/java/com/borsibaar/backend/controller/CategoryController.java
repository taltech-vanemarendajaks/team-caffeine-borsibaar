package com.borsibaar.backend.controller;

import com.borsibaar.backend.dto.CategoryRequestDto;
import com.borsibaar.backend.dto.CategoryResponseDto;
import com.borsibaar.backend.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto request) {
        return categoryService.create(request);
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getById(@PathVariable Long id){
       return categoryService.getByIdAndOrg(id);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
       categoryService.deleteReturningDto(id);
    }
}


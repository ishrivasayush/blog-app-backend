package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.CategoryDto;
import com.narainox.blogappliactionbackend.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryDto categoryDto) throws Exception;
    CategoryResponse updateCategory(CategoryDto categoryDto)throws Exception;
    CategoryResponse getCategory(Integer categoryId)throws Exception;
    void deleteCategory(Integer categoryId)throws Exception;
    List<CategoryResponse> getAllCategory()throws Exception;
}

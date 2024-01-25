package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.CategoryResponse;
import com.narainox.blogappliactionbackend.dto.CreateCategoryRequest;
import com.narainox.blogappliactionbackend.dto.UpdateCategoryRequest;
import com.narainox.blogappliactionbackend.models.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) throws Exception;
    CategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest)throws Exception;
    CategoryResponse getCategory(Integer categoryId)throws Exception;
    void deleteCategory(Integer categoryId)throws Exception;
    List<CategoryResponse> getAllCategory()throws Exception;
}

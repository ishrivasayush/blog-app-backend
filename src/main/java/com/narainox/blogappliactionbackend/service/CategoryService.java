package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto) throws Exception;
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId)throws Exception;
    CategoryDto getCategory(Integer categoryId)throws Exception;
    void deleteCategory(Integer categoryId)throws Exception;
    List<CategoryDto> getAllCategory()throws Exception;
}

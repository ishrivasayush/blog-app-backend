package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.dto.CategoryResponse;
import com.narainox.blogappliactionbackend.dto.CreateCategoryRequest;
import com.narainox.blogappliactionbackend.dto.UpdateCategoryRequest;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.models.Category;
import com.narainox.blogappliactionbackend.repository.CategoryRepository;
import com.narainox.blogappliactionbackend.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest)throws Exception {
        Category category = modelMapper.map(createCategoryRequest, Category.class);
        Category categories = categoryRepository.save(category);
        return modelMapper.map(categories,CategoryResponse.class);
    }
    @Override
    public CategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest) throws Exception{
        Category category = modelMapper.map(updateCategoryRequest, Category.class);
        Category categories = categoryRepository.save(category);
        return modelMapper.map(categories,CategoryResponse.class);
    }

    @Override
    public CategoryResponse getCategory(Integer categoryId) throws Exception{
        return modelMapper.map(categoryRepository.findById(categoryId),CategoryResponse.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) throws Exception {
        categoryRepository.delete(categoryRepository.findById(categoryId).get());
    }

    @Override
    public List<CategoryResponse> getAllCategory() throws Exception{
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses=new ArrayList<>();
        for (Category category:categoryList)
        {
            categoryResponses.add(modelMapper.map(category,CategoryResponse.class));
        }
        return categoryResponses;
    }
}

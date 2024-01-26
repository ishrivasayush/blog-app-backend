package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.dto.CategoryDto;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.models.Category;
import com.narainox.blogappliactionbackend.repository.CategoryRepository;
import com.narainox.blogappliactionbackend.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto)throws Exception {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category categories = categoryRepository.save(category);
        return modelMapper.map(categories,CategoryDto.class);
    }
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId) throws Exception{
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category Not Found."));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(category.getCategoryDescription());
        category.setUpdatedAt(LocalDateTime.now());
        Category categories = categoryRepository.save(category);
        return modelMapper.map(categories,CategoryDto.class);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) throws Exception{
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category Not Found."));
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) throws Exception {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category Not Found."));
        categoryRepository.delete(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() throws Exception{
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryResponses=new ArrayList<>();
        for (Category category:categoryList)
        {
            categoryResponses.add(modelMapper.map(category,CategoryDto.class));
        }
        return categoryResponses;
    }
}

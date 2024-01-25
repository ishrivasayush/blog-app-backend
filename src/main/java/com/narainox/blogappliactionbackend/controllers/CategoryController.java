package com.narainox.blogappliactionbackend.controllers;

import com.narainox.blogappliactionbackend.dto.*;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("v1/categories")
    public ResponseEntity<DBSResponseEntity> createCategoryCall(@RequestBody CreateCategoryRequest createCategoryRequest)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CategoryResponse category = categoryService.createCategory(createCategoryRequest);
            dbsResponseEntity.setData(category);
            dbsResponseEntity.setMessage("Category Created Successfully.");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("v1/categories")
    public ResponseEntity<DBSResponseEntity> updateCategoryCall(
            @Valid @RequestBody UpdateCategoryRequest updateCategoryRequest)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CategoryResponse response = categoryService.updateCategory(updateCategoryRequest);
            if (Objects.isNull(response)) throw new RecordNotFoundException("Category is not Found.");
            dbsResponseEntity.setMessage("Category updated successfully.");
            dbsResponseEntity.setData(response);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (RecordNotFoundException e)
        {
            throw e;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("v1/category/{categoryId}")
    public ResponseEntity<DBSResponseEntity> deleteCategoryCall(
            @PathVariable Integer categoryId
    )
    {
        DBSResponseEntity dbsResponseEntity = new DBSResponseEntity();
        try {
            categoryService.deleteCategory(categoryId);
            dbsResponseEntity.setMessage("Category deleted Successfully");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("v1/category/categoryId")
    public ResponseEntity<DBSResponseEntity> getCategoryCall(@PathVariable Integer categoryId)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CategoryResponse category = categoryService.getCategory(categoryId);
            dbsResponseEntity.setData(category);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("v1/category")
    public ResponseEntity<DBSResponseEntity> getCategoriesCall()
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            List<CategoryResponse> category = categoryService.getAllCategory();
            dbsResponseEntity.setData(category);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

package com.narainox.blogappliactionbackend.controllers;

import com.narainox.blogappliactionbackend.dto.*;
import com.narainox.blogappliactionbackend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Validated
@RequestMapping("api/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("v1/categories")
    public ResponseEntity<DBSResponseEntity> createCategoryCall(@RequestBody CategoryDto categoryDto)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CategoryDto category = categoryService.createCategory(categoryDto);
            dbsResponseEntity.setData(category);
            dbsResponseEntity.setMessage("Category Created Successfully.");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("v1/categories/{categoryId}")
    public ResponseEntity<DBSResponseEntity> updateCategoryCall(
            @Valid @RequestBody CategoryDto categoryDto,
            @PathVariable Integer categoryId)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CategoryDto response = categoryService.updateCategory(categoryDto,categoryId);
            dbsResponseEntity.setMessage("Category updated successfully.");
            dbsResponseEntity.setData(response);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("v1/categories/{categoryId}")
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
    @GetMapping("v1/categories/{categoryId}")
    public ResponseEntity<DBSResponseEntity> getCategoryCall(@PathVariable Integer categoryId)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CategoryDto category = categoryService.getCategory(categoryId);
            dbsResponseEntity.setData(category);
            dbsResponseEntity.setMessage("category");
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
            List<CategoryDto> category = categoryService.getAllCategory();
            dbsResponseEntity.setData(category);
            dbsResponseEntity.setMessage("Category");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

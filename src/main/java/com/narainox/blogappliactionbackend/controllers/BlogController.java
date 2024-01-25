package com.narainox.blogappliactionbackend.controllers;

import com.narainox.blogappliactionbackend.dto.CreateBlogRequest;
import com.narainox.blogappliactionbackend.dto.DBSResponseEntity;
import com.narainox.blogappliactionbackend.dto.UpdateBlogRequest;
import com.narainox.blogappliactionbackend.models.Blog;
import com.narainox.blogappliactionbackend.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("v1/blogs")
    public ResponseEntity<DBSResponseEntity> createBlogCall(
            @Valid @RequestBody CreateBlogRequest createBlogRequest)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            Blog createdBlog =blogService.createBlog(createBlogRequest);
            dbsResponseEntity.setMessage("Blog created successfully.");
            dbsResponseEntity.setData(createdBlog);
            return ResponseEntity.ok(dbsResponseEntity);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("v1/blogs")
    public ResponseEntity<DBSResponseEntity> updateBlogCall(
            @Valid @RequestBody UpdateBlogRequest updateBlogRequest)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            Blog updatedBlog =blogService.updateBlog(updateBlogRequest);
            dbsResponseEntity.setMessage("Blog updated successfully.");
            dbsResponseEntity.setData(updatedBlog);
            return ResponseEntity.ok(dbsResponseEntity);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

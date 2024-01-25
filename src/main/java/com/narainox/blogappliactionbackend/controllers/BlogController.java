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
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("v1/blogs/{blogId}")
    public ResponseEntity<DBSResponseEntity> updateBlogCall(
            @Valid @RequestBody UpdateBlogRequest updateBlogRequest,
            @PathVariable Integer blogId)
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
    @DeleteMapping("/v1/blogs/{blogId}")
    public ResponseEntity<DBSResponseEntity> deleteBlogCall(
            @PathVariable Integer blogId
    )
    {
        DBSResponseEntity dbsResponseEntity = new DBSResponseEntity();
        try {
            blogService.deleteBlog(blogId);
            dbsResponseEntity.setMessage("Blog deleted Successfully");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/blogs/blogId")
    public ResponseEntity<DBSResponseEntity> getBlogCall(@PathVariable Integer blogId)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
           blogService.getBlog(blogId);
           dbsResponseEntity.setData(blogId);
           return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}

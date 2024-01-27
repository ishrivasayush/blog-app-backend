package com.narainox.blogappliactionbackend.controllers;

import com.narainox.blogappliactionbackend.dto.BlogDto;
import com.narainox.blogappliactionbackend.dto.CommonPaginationRequest;
import com.narainox.blogappliactionbackend.dto.DBSResponseEntity;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("api/")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("v1/blogs/category/{categoryId}/user/{userId}")
    public ResponseEntity<DBSResponseEntity> createBlogCall(
            @Valid @RequestBody BlogDto blogDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            BlogDto blog = blogService.createBlog(blogDto, userId, categoryId);
            dbsResponseEntity.setMessage("Blog created successfully.");
            dbsResponseEntity.setData(blog);
            return new ResponseEntity<>(dbsResponseEntity,HttpStatus.CREATED);
        }
        catch (RecordNotFoundException ex)
        {
            throw ex;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("v1/blogs/{blogId}")
    public ResponseEntity<DBSResponseEntity> updateBlogCall(
            @Valid @RequestBody BlogDto blogDto,
            @PathVariable Integer blogId)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            BlogDto updatedBlog =blogService.updateBlog(blogDto,blogId);
            dbsResponseEntity.setMessage("Blog updated successfully.");
            dbsResponseEntity.setData(updatedBlog);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (RecordNotFoundException ex)
        {
            throw ex;
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("v1/blogs/{blogId}")
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
        catch (RecordNotFoundException ex)
        {
            throw ex;
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("v1/blogs/blogId")
    public ResponseEntity<DBSResponseEntity> getBlogCall(@PathVariable Integer blogId)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            BlogDto blog = blogService.getBlog(blogId);
            dbsResponseEntity.setData(blog);
           return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (RecordNotFoundException ex)
        {
            throw ex;
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("v1/user/{userId}/blogs")
    public ResponseEntity<DBSResponseEntity> getBlogsByUserCall(
            @PathVariable Integer userId,
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    )
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        CommonPaginationRequest commonPaginationRequest=new CommonPaginationRequest();
        commonPaginationRequest.setPageNo(pageNo);
        commonPaginationRequest.setPageSize(pageSize);
        commonPaginationRequest.setSortDir(sortDir);
        commonPaginationRequest.setSortBy(sortBy);
        try {
            List<BlogDto> blog=blogService.getBlogsByUser(userId,commonPaginationRequest);
            dbsResponseEntity.setData(blog);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("v1/category/{categoryId}/blogs")
    public ResponseEntity<DBSResponseEntity> getBlogsByCategoryCall(
            @PathVariable Integer categoryId,
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    )
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        CommonPaginationRequest commonPaginationRequest=new CommonPaginationRequest();
        commonPaginationRequest.setPageNo(pageNo);
        commonPaginationRequest.setPageSize(pageSize);
        commonPaginationRequest.setSortDir(sortDir);
        commonPaginationRequest.setSortBy(sortBy);
        try {
            List<BlogDto> blog=blogService.getBlogsByCategory(categoryId,commonPaginationRequest);
            dbsResponseEntity.setData(blog);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("v1/blogs")
    public ResponseEntity<DBSResponseEntity> getBlogsCall(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    )
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        CommonPaginationRequest commonPaginationRequest=new CommonPaginationRequest();
        commonPaginationRequest.setPageNo(pageNo);
        commonPaginationRequest.setPageSize(pageSize);
        commonPaginationRequest.setSortDir(sortDir);
        commonPaginationRequest.setSortBy(sortBy);
        try {
            List<BlogDto> blog=blogService.getBlogs(commonPaginationRequest);
            dbsResponseEntity.setData(blog);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

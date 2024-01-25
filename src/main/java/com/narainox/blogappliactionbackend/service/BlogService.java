package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.CreateBlogRequest;
import com.narainox.blogappliactionbackend.dto.UpdateBlogRequest;
import com.narainox.blogappliactionbackend.models.Blog;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog createBlog(CreateBlogRequest createBlogRequest) throws Exception;
    Blog updateBlog(UpdateBlogRequest updateBlogRequest) throws Exception;
    Blog deleteBlog(Integer blogId)throws Exception;
    Optional<Blog> getBlog(Integer blogId)throws Exception;
    List<Blog> getBlogs(Integer userId, Pageable pageable)throws Exception;

}

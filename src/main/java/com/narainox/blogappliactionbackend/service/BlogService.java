package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.models.Blog;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog createBlog(Blog blog) throws Exception;
    Blog updateBlog(Blog blog) throws Exception;
    Blog deleteBlog(Integer blogId)throws Exception;
    Optional<Blog> getBlog(Integer blogId)throws Exception;
    List<Blog> getBlogs(Integer userId, Pageable pageable)throws Exception;

}

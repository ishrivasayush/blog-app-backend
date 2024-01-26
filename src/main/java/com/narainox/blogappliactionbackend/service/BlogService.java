package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.BlogDto;
import com.narainox.blogappliactionbackend.models.Blog;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog createBlog(BlogDto blogDto) throws Exception;
    Blog updateBlog(BlogDto blogDto) throws Exception;
    Blog deleteBlog(Integer blogId)throws Exception;
    Optional<Blog> getBlog(Integer blogId)throws Exception;
    List<Blog> getBlogs(Integer userId, Pageable pageable)throws Exception;

}

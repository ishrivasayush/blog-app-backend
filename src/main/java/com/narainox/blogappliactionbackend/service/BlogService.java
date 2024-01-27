package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.BlogDto;
import com.narainox.blogappliactionbackend.dto.CommentDto;
import com.narainox.blogappliactionbackend.dto.CommonPaginationRequest;
import com.narainox.blogappliactionbackend.models.Blog;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    BlogDto createBlog(BlogDto blogDto,Integer userId,Integer categoryId);
    BlogDto updateBlog(BlogDto blogDto, Integer postId);
    void deleteBlog(Integer postId);
    List<BlogDto> getBlogs(Integer pageNumber,Pageable pageable);
    BlogDto getBlog(Integer postId);
    List<BlogDto> getBlogsByCategory(Integer categoryId,Pageable pageable);
    List<BlogDto> getBlogsByUser(CommonPaginationRequest commonPaginationRequest);

}

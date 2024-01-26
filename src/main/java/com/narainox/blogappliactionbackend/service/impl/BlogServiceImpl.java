package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.dto.BlogDto;
import com.narainox.blogappliactionbackend.repository.BlogRepository;
import com.narainox.blogappliactionbackend.service.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public BlogDto createBlog(BlogDto blogDto, Integer userId, Integer categoryId) {
        return null;
    }

    @Override
    public BlogDto updateBlog(BlogDto blogDto, Integer postId) {
        return null;
    }

    @Override
    public void deleteBlog(Integer postId) {

    }
    @Override
    public List<BlogDto> getBlogs(Integer pageNumber, Pageable pageable) {
        return null;
    }

    @Override
    public BlogDto getBlog(Integer postId) {
        return null;
    }
}

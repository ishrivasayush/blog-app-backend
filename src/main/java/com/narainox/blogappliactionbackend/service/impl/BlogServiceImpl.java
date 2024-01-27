package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.dto.BlogDto;
import com.narainox.blogappliactionbackend.dto.CommonPaginationRequest;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.models.Blog;
import com.narainox.blogappliactionbackend.models.Category;
import com.narainox.blogappliactionbackend.models.User;
import com.narainox.blogappliactionbackend.repository.BlogRepository;
import com.narainox.blogappliactionbackend.repository.CategoryRepository;
import com.narainox.blogappliactionbackend.repository.UserRepository;
import com.narainox.blogappliactionbackend.service.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public BlogDto createBlog(BlogDto blogDto, Integer userId, Integer categoryId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("User Not Found."));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category Not Found."));
        Blog blog = modelMapper.map(blogDto, Blog.class);
        blog.setImageName("Default Image");
        blog.setUser(user);
        blog.setCategory(category);
        blog.setCreatedAt(LocalDateTime.now());
        Blog save = blogRepository.save(blog);
        return modelMapper.map(save,BlogDto.class);
    }

    @Override
    public BlogDto updateBlog(BlogDto blogDto, Integer blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RecordNotFoundException("Blog is not found."));
        Category category = categoryRepository.findById(blogDto.getCategory().getId()).orElseThrow(() -> new RecordNotFoundException("Category Not Found."));
        blog.setUpdatedAt(LocalDateTime.now());
        blog.setCategory(category);
        blog.setContent(blogDto.getContent());
        blog.setPublish(blogDto.getPublish());
        blog.setTitle(blogDto.getTitle());
        blog.setImageName(blogDto.getImageName());
        return modelMapper.map(blogRepository.save(blog),BlogDto.class);
    }

    @Override
    public void deleteBlog(Integer blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RecordNotFoundException("Blog is not found."));
        blogRepository.delete(blog);
    }

    @Override
    public List<BlogDto> getBlogs(CommonPaginationRequest commonPaginationRequest) {
        Sort sort = (commonPaginationRequest.getSortDir().equalsIgnoreCase("asc")) ? Sort.by(commonPaginationRequest.getSortBy()).ascending() : Sort.by(commonPaginationRequest.getSortBy()).descending();
        Pageable pageable= PageRequest.of(commonPaginationRequest.getPageNo(),
                commonPaginationRequest.getPageSize(),
                sort);

        Page<Blog> b = blogRepository.findAll(pageable);
        List<BlogDto> blogDtos=new ArrayList<>();
        for (Blog blog:b)
        {
            blogDtos.add(modelMapper.map(blog,BlogDto.class));
        }
        return blogDtos;
    }

    @Override
    public BlogDto getBlog(Integer blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RecordNotFoundException("Blog is not found."));
        return modelMapper.map(blog,BlogDto.class);
    }

    @Override
    public List<BlogDto> getBlogsByCategory(Integer categoryId, CommonPaginationRequest commonPaginationRequest) {
        Sort sort = (commonPaginationRequest.getSortDir().equalsIgnoreCase("asc")) ? Sort.by(commonPaginationRequest.getSortBy()).ascending() : Sort.by(commonPaginationRequest.getSortBy()).descending();
        Pageable pageable= PageRequest.of(commonPaginationRequest.getPageNo(),
                commonPaginationRequest.getPageSize(),
                sort);
        List<Blog> b = blogRepository.findByCategory(categoryId, pageable);
        List<BlogDto> blogDtos=new ArrayList<>();
        for (Blog blog:b)
        {
            blogDtos.add(modelMapper.map(blog,BlogDto.class));
        }
        return blogDtos;
    }



    @Override
    public List<BlogDto> getBlogsByUser(Integer userId,CommonPaginationRequest commonPaginationRequest) {
        Sort sort = (commonPaginationRequest.getSortDir().equalsIgnoreCase("asc")) ? Sort.by(commonPaginationRequest.getSortBy()).ascending() : Sort.by(commonPaginationRequest.getSortBy()).descending();
        Pageable pageable= PageRequest.of(commonPaginationRequest.getPageNo(),
                commonPaginationRequest.getPageSize(),
                sort);

        List<Blog> b = blogRepository.findByUser(userId, pageable);
        List<BlogDto> blogDtos=new ArrayList<>();
        for (Blog blog:b)
        {
            blogDtos.add(modelMapper.map(blog,BlogDto.class));
        }
        return blogDtos;
    }
}

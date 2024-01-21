package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.models.Blog;
import com.narainox.blogappliactionbackend.repository.BlogRepository;
import com.narainox.blogappliactionbackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog createBlog(Blog blog) throws Exception {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog)throws Exception {
        return blogRepository.save(blog);
    }
    @Override
    public Blog deleteBlog(Integer blogId)throws Exception {
        return blogRepository.deleteByBlogId(blogId);
    }
    public Optional<Blog> getBlog(Integer blogId)throws Exception {
        return blogRepository.findById(blogId);
    }
    public List<Blog> getBlogs(Integer userId, Pageable pageable)throws Exception
    {
        return blogRepository.findByUser(userId,pageable);
    }
}

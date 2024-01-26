package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.dto.CommentDto;
import com.narainox.blogappliactionbackend.models.Comment;
import com.narainox.blogappliactionbackend.repository.CommentRepository;
import com.narainox.blogappliactionbackend.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentResponse saveComment( CommentDto commentDto) throws Exception {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Comment save = commentRepository.save(comment);
        return modelMapper.map(save,CommentResponse.class);
    }

    @Override
    public CommentResponse updateComment( CommentDto commentDto) throws Exception {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Comment save = commentRepository.save(comment);
        return modelMapper.map(save,CommentResponse.class);
    }

    @Override
    public void deleteComment(Integer commentId) throws Exception {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> getComments(Integer blogId, Pageable pageable) throws Exception {
        return null;
    }
}

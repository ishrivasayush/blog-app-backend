package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.CommentDto;
import com.narainox.blogappliactionbackend.dto.CommentResponse;
import com.narainox.blogappliactionbackend.models.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    CommentResponse saveComment( CommentDto commentDto)throws Exception;
    CommentResponse updateComment( CommentDto commentDto)throws Exception;
    void deleteComment(Integer commentId)throws Exception;
    List<Comment> getComments(Integer blogId, Pageable pageable)throws Exception;

}

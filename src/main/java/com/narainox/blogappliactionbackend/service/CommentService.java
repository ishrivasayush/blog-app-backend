package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.CommentDto;
import com.narainox.blogappliactionbackend.models.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    CommentDto saveComment( CommentDto commentDto)throws Exception;
    CommentDto updateComment( CommentDto commentDto)throws Exception;
    void deleteComment(Integer commentId)throws Exception;
    List<Comment> getComments(Integer blogId, Pageable pageable)throws Exception;

}

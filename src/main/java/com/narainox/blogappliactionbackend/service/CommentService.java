package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.CommentDto;
import com.narainox.blogappliactionbackend.models.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId)throws Exception;

    void deleteComment(Integer commentId) throws Exception;
}

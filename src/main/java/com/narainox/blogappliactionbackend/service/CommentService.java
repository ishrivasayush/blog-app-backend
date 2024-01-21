package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.models.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    void saveComment(Comment comment)throws Exception;
    void updateComment(Comment comment)throws Exception;
    void deleteComment(Integer commentId)throws Exception;
    List<Comment> getComments(Integer blogId, Pageable pageable)throws Exception;

}

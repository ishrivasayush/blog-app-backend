package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.models.Comment;
import com.narainox.blogappliactionbackend.repository.CommentRepository;
import com.narainox.blogappliactionbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment)throws Exception
    {
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment)throws Exception
    {
        commentRepository.save(comment);
    }

    public void deleteComment(Integer commentId)throws Exception
    {
        commentRepository.deleteById(commentId);
    }

    public List<Comment> getComments(Integer blogId, Pageable pageable)throws Exception
    {
        return commentRepository.findByBlog(blogId,pageable);
    }

}

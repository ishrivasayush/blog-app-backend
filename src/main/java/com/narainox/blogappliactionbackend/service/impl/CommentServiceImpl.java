package com.narainox.blogappliactionbackend.service.impl;
import com.narainox.blogappliactionbackend.dto.CommentDto;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.models.Blog;
import com.narainox.blogappliactionbackend.models.Comment;
import com.narainox.blogappliactionbackend.repository.BlogRepository;
import com.narainox.blogappliactionbackend.repository.CommentRepository;
import com.narainox.blogappliactionbackend.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentDto createComment(CommentDto commentDto, Integer blogId) throws Exception {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RecordNotFoundException("Blog Not Found Exception."));
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setBlog(blog);
        Comment save = commentRepository.save(comment);
        return modelMapper.map(save,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) throws Exception {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RecordNotFoundException("Comment is not Found."));
        commentRepository.delete(comment);
    }
}

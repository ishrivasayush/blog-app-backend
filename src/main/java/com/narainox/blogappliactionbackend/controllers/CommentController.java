package com.narainox.blogappliactionbackend.controllers;

import com.narainox.blogappliactionbackend.dto.*;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@Validated
@RequestMapping("/api/v1/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/blog/{blogId}/comments")
    public ResponseEntity<DBSResponseEntity> createCommentCall(
            @RequestBody @Valid CommentDto commentDto,
            @PathVariable Integer blogId)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CommentDto comment = commentService.createComment(commentDto, blogId);
            dbsResponseEntity.setMessage("Comment created successfully.");
            dbsResponseEntity.setData(comment);
            return new ResponseEntity<>(dbsResponseEntity,HttpStatus.CREATED);
        }
        catch (RecordNotFoundException ex)
        {
            throw ex;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<DBSResponseEntity> deleteCommentCall(
            @PathVariable Integer commentId
    )
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            commentService.deleteComment(commentId);
            dbsResponseEntity.setMessage("Comment deleted successfully.");
            return new ResponseEntity<>(dbsResponseEntity,HttpStatus.OK);
        }
        catch (RecordNotFoundException ex)
        {
            throw ex;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

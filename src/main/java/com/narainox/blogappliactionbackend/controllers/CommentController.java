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

import java.util.Objects;

@RestController
@Validated
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("v1/comments")
    public ResponseEntity<DBSResponseEntity> createCommentCall(@RequestBody @Valid CommentDto commentDto)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CommentResponse commentResponse = commentService.saveComment(commentDto);
            dbsResponseEntity.setData(commentResponse);
            dbsResponseEntity.setMessage("Comment Created Successfully.");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("v1/comments")
    public ResponseEntity<DBSResponseEntity> updateCommentCall(@RequestBody @Valid  CommentDto commentDto)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try {
            CommentResponse commentResponse = commentService.updateComment(commentDto);
            if (Objects.isNull(commentResponse)) throw new RecordNotFoundException("Comment Not Found.");
            dbsResponseEntity.setData(commentResponse);
            dbsResponseEntity.setMessage("Comment Updated Successfully.");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (RecordNotFoundException e)
        {
            throw e;
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("v1/comments/{commentId}")
    public ResponseEntity<DBSResponseEntity> deleteCategoryCall(
            @PathVariable Integer commentId
    )
    {
        DBSResponseEntity dbsResponseEntity = new DBSResponseEntity();
        try {
            commentService.deleteComment(commentId);
            dbsResponseEntity.setMessage("Comment deleted Successfully");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (Exception exception)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}

package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.Blog;
import com.narainox.blogappliactionbackend.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResponse {
    private Integer commentId;

    private String title;
    private User user;
    private Blog blog;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

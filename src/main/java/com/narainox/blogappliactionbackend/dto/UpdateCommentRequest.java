package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.Blog;
import com.narainox.blogappliactionbackend.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCommentRequest {
    @NotNull(message = "commentId is required parameter.")
    private Integer commentId;
    @NotBlank(message = "Title is required parameter.")
    private String title;
    @NotBlank(message = "User is required parameter.")
    private User user;
    @NotBlank(message = "blog is required parameter.")
    private Blog blog;
}

package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBlogRequest {
    @NotNull(message = "BlogId is required parameter.")
    private Integer blogId;
    @NotBlank(message = "Title is required parameter.")
    private String title;
    @NotBlank(message = "Description is required parameter.")
    private String description;
    @NotNull(message = "Publish is required parameter.")
    private Boolean publish;
    @NotNull(message = "User is required parameter.")
    private User user;
}

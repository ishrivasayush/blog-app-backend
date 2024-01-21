package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBlogRequest {
    private Integer blogId;
    private String title;
    private String description;
    private Boolean publish;
    private User user;
}

package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.User;

import java.time.LocalDateTime;

public class BlogResponse {
    private Integer blogId;
    private String title;
    private String description;
    private Boolean publish;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

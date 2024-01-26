package com.narainox.blogappliactionbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDto {
    private Integer postId;

    private String title;

    private String content;

    private String imageName;
    private Boolean publish;
    private CategoryDto category;

    private UserDto user;

    private Set<CommentDto> comments=new HashSet<>();
}

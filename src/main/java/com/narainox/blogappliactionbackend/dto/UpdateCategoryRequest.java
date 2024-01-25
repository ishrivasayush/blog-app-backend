package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCategoryRequest {
    private int id;
    private String categoryName;
    private String categoryDescription;
//    private List<Blog> blogs=new ArrayList<>();
}

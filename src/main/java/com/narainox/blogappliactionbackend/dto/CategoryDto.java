package com.narainox.blogappliactionbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {
    private int id;
    @NotBlank
    @Size(min = 4,message = "Min size of category title is 4")
    private String categoryName;

    @NotBlank
    @Size(min = 10, message = "min size of cateogry desc is 10")
    private String categoryDescription;
}

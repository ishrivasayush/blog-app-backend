package com.narainox.blogappliactionbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private int id;
    @NotBlank
    @Size(min = 4,message = "Min size of category title is 4")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10, message = "min size of category desc is 10")
    private String categoryDescription;

}

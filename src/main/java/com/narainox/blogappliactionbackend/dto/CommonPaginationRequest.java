package com.narainox.blogappliactionbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonPaginationRequest {
    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private String sortDir;
}

package com.narainox.blogappliactionbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUserRequest {

    @NotBlank(message = "User name is required parameter.")
    private String userName;

    @NotBlank(message = "Password is required parameter.")
    private String password;

    @NotNull(message = "Role is required parameter.")
    private Integer role;

    private int isSocialRegister;

}

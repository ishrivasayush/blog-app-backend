package com.narainox.blogappliactionbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserRequest {

    @Email(message = "User name required parameter.")
    private String userName;

    @NotBlank(message = "Password required parameter.")
    private String password;

    @NotNull(message = "Role required parameter.")
    private Integer role;

    private int isSocialRegister;

    @Override
    public String toString() {
        return "RegisterUserRequest{" +
                "userName='" + userName + '\'' +
                ", role=" + role +
                ", isSocialRegister=" + isSocialRegister +
                '}';
    }
}

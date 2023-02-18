package com.resellerapp.model.dto;

import com.resellerapp.vallidation.FieldMatch;
import com.resellerapp.vallidation.UniqueUserEmail;
import com.resellerapp.vallidation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match!"
)
public class UserRegisterDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    @UniqueUsername
    private String username;

    @NotBlank
    @Email
    @UniqueUserEmail
    private String email;

    @NotBlank
    @Size(min = 3, max = 20)
    private String password;

    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

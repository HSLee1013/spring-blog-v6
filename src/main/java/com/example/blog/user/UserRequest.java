package com.example.blog.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class UserRequest {
    @Data
    public static class LoginDTO {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }
}

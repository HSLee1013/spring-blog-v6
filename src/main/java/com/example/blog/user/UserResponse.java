package com.example.blog.user;

import lombok.Data;

import java.sql.Timestamp;

public class UserResponse {
    @Data
    public static class LoginDTO {
        private String username;
        private String password;
        private String email;
        private Timestamp createdAt;

        public LoginDTO(User user) {
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.createdAt = user.getCreatedAt();
        }
    }
}

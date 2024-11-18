package com.example.blog.board;

import lombok.Data;

public class BoardRequest {
    @Data
    public static class SaveDTO {
        private String title;
        private String content;
    }

    @Data
    public class UpdateDTO {
        private String title;
        private String content;
    }
}

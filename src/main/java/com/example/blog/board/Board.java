package com.example.blog.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

// 모델
// DB에서 조회해서 가져온 ResultSet을 기본 생성자를 호출해서 instance를 생성하고 리플렉션으로 값을 채운다.
@NoArgsConstructor
@Getter
@ToString
@Table(name="board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private int id;
    private String title;
    private String content;
    private Timestamp createdAt;
}

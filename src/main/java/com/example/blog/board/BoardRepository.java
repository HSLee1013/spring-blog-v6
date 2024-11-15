package com.example.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// 책임: DB 상호작용
@RequiredArgsConstructor
@Repository
public class BoardRepository {
    // JPA는 EntityManager로 DB에 접근한다 (자바에서 DBConnection)
    private final EntityManager entityManager;

    public List<Board> findAll() {
        Query q = entityManager.createNativeQuery("select * from board_tb order by id desc", Board.class);
        return q.getResultList();
    }
}

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

    // DTO에 의존하지 않게 하기 위해 DTO에서 꺼내서 매개변수를 받는다.
    public void update(int id, String title, String content) {
        Query q = entityManager.createNativeQuery("update board_tb set title=?, content=? where id=?");
        q.setParameter(1, title);
        q.setParameter(2, content);
        q.setParameter(3, id);
        q.executeUpdate();
    }

    public void delete(int id) {
        Query q = entityManager.createNativeQuery("delete from board_tb where id = ?");
        q.setParameter(1, id);
        q.executeUpdate();
    }

    public void save(String title, String content) {
        Query q = entityManager.createNativeQuery("insert into board_tb(title,content,created_at) values(?,?,now())");
        q.setParameter(1, title);
        q.setParameter(2, content);
        q.executeUpdate();
    }

    public List<Board> findAll() {
        Query q = entityManager.createNativeQuery("select * from board_tb order by id desc", Board.class);
        return q.getResultList();
    }

    public Board findById(int id) {
        Query q = entityManager.createNativeQuery("select * from board_tb where id = ?", Board.class);
        q.setParameter(1, id);
        return (Board) q.getSingleResult();
    }
}

package com.example.blog.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest // DB 관련된 자원들을 메모리에 올린다.
public class BoardRepositoryTest { // 클래스 명 뒤에 Test를 붙이는게 약속이다.
    @Autowired
    BoardRepository boardRepository;

    // 메서드명 뒤에 _test를 붙이는게 약속이다.
    @Test
    public void findAll_test() {
        // given parameter 입력할 매개변수
        // findAll에 매개변수가 없어서 생략

        // when method 테스트할 메서드
        List<Board> boardList = boardRepository.findAll();
        // then verify 검증

        // eye 직접 확인
        for (Board board : boardList) {
            System.out.println(board.getId());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
            System.out.println(board.getCreatedAt());
            System.out.println("============");
        }
    }
}

package com.example.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 책임: 비즈니스 로직 처리(트랙잭션 관리), DTO 생성
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponse.DTO> 게시글목록보기() {
        List<BoardResponse.DTO> dtoList = new ArrayList<BoardResponse.DTO>();
        List<Board> boardList = boardRepository.findAll();
        for (Board board : boardList) {
            BoardResponse.DTO dto = new BoardResponse.DTO(board);
            dtoList.add(dto);
        }
        return dtoList;
    }
}

package com.example.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// 책임: 비즈니스 로직 처리(트랙잭션 관리), DTO 생성
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void 게시글수정(int id, BoardRequest.UpdateDTO updateDTO) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 id의 게시글이 없습니다 : " + id));
        board.update(updateDTO.getTitle(), updateDTO.getContent());
        // 객체상태변경 - update + commit => 더티체킹
    }

    public BoardResponse.UpdateFormDTO 게시글수정화면보기(int id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 id의 게시글이 없습니다 : " + id));
        return new BoardResponse.UpdateFormDTO(board);
    }

    @Transactional
    public void 게시글삭제(int id) {
        boardRepository.delete(id);
    } // commit or rollback

    @Transactional
    public void 게시글쓰기(BoardRequest.SaveDTO saveDTO) {
        boardRepository.save(saveDTO.toEntity());
    } // commit or rollback

    public BoardResponse.DetailDTO 게시글상세보기(int id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 id의 게시글이 없습니다 : " + id));
        return new BoardResponse.DetailDTO(board);
    }

    public List<BoardResponse.DTO> 게시글목록보기() {
        return boardRepository.findAll().stream()
                .map(BoardResponse.DTO::new)
                .toList();
    }
}

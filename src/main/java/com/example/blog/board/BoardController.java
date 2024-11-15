package com.example.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// 책임: 외부 클라이언트의 요청을 받고 응답
@RequiredArgsConstructor // final이 붙은 필드를 매개변수로 받는 생성자를 만들어준다.
@Controller
public class BoardController {

    // Spring은 Component Scan을 수행할 때 기본 생성자를 우선적으로 사용하여 인스턴스를 생성한다.
//    public BoardController() {
//        System.out.println(boardService); // Dependency Injection이 안되어 null을 출력한다.
//    }

    // Spring Framework가 자동으로 Dependency Injection을 통해 BoardService 객체를 주입해준다.
//    public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }

    // final 키워드를 사용하면 반드시 초기화해야 하므로, 실수를 방지할 수 있다.
    private final BoardService boardService;

    // view resolver가 뷰를 찾아준다.
    @GetMapping("/")
    public String list(Model model) { // DS(request객체를 model이라는 객체로 랩핑해서 전달해준다)
        List<BoardResponse.DTO> boardList = boardService.게시글목록보기();
        model.addAttribute("models", boardList);
        return "list";
    }
}

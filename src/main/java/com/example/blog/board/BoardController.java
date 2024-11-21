package com.example.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// 책임: 외부 클라이언트의 요청을 받고 응답
@RequiredArgsConstructor // final이 붙은 필드를 매개변수로 받는 생성자를 만들어준다.
@Controller
public class BoardController {

    // final 키워드를 사용하면 반드시 초기화해야 하므로, 실수를 방지할 수 있다.
    private final BoardService boardService;

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable int id, BoardRequest.UpdateDTO updateDTO) {
        boardService.게시글수정(id, updateDTO);
        return "redirect:/board/" + id;
    }

    @GetMapping("/board/{id}/update")
    public String updateForm(@PathVariable int id, Model model) {
        BoardResponse.UpdateFormDTO updateFormDTO = boardService.게시글수정화면보기(id);
        model.addAttribute("model", updateFormDTO);
        return "update-form";
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        boardService.게시글삭제(id);
        return "redirect:/";
    }

    @PostMapping("/board/save")
    public String save(BoardRequest.SaveDTO saveDTO) {
        // TODO: 나중에 삭제하기
        if (saveDTO.getTitle().isBlank())
            throw new RuntimeException("title에 공백 혹은 null이 들어갈 수 없습니다.");
        boardService.게시글쓰기(saveDTO);
        return "redirect:/";
    }

    @GetMapping("/save-form")
    public String saveForm() {
        return "save-form";
    }

    /**
     * 쿼리스트링(where절) : /board?title=바다
     * 패스변수(where절) : /board/1
     */
    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        BoardResponse.DetailDTO boardDetail = boardService.게시글상세보기(id);
        model.addAttribute("model", boardDetail);
        return "detail";
    }

    // view resolver가 뷰를 찾아준다.
    @GetMapping("/")
    public String list(Model model) { // DS(request객체를 model이라는 객체로 랩핑해서 전달해준다)
        List<BoardResponse.DTO> boardList = boardService.게시글목록보기();
        model.addAttribute("models", boardList);
        return "list";
    }

    // Spring은 Component Scan을 수행할 때 기본 생성자를 우선적으로 사용하여 인스턴스를 생성한다.
//    public BoardController() {
//        System.out.println(boardService); // Dependency Injection이 안되어 null을 출력한다.
//    }

    // Spring Framework가 자동으로 Dependency Injection을 통해 BoardService 객체를 주입해준다.
//    public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }
}

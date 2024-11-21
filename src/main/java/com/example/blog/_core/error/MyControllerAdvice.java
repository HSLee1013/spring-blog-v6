package com.example.blog._core.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 예외처리
@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public String err(RuntimeException e) {
        String body = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>
                """.replace("${msg}", e.getMessage());

        return body;
    }
}

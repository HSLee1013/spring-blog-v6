package com.example.blog.user;

import com.example.blog._core.error.ex.Exception401;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User login(UserRequest.LoginDTO loginDTO) {
        User userPS = userRepository.findByUsername(loginDTO.getUsername());
        if (!userPS.getPassword().equals(loginDTO.getPassword())) {
            throw new Exception401("아이디나 비밀번호가 일치하지 않습니다.");
        }
        return userPS;
    }
}

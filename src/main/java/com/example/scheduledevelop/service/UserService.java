package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.user.SignUpResponseDto;
import com.example.scheduledevelop.dto.user.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    //UserRepository 호출
    private final UserRepository userRepository;

    //유저 저장 로직 구현
    public SignUpResponseDto signUp(String username, String email, String password) {

        User user = new User(username, email, password);

        //UserRepository 의 save 메소드 호출
        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    //id 로 유저 조회 로직 구현
    public UserResponseDto findById(Long id) {

        //Optional 로 객체 생성
        Optional<User> optionalUser = userRepository.findById(id);

        //null 예외 처리
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id = " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }
}

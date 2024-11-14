package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.user.SignUpResponseDto;
import com.example.scheduledevelop.dto.user.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//bean 으로 설정
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

        //findByIdOrElseThrow 메소드를 통해 객체 생성
        User findUser = userRepository.findByIdOrElseThrow(id);

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    //유저 삭제 로직 구현
    public void delete(Long id) {

        //repository 에서 id 로 찾아 객체 생성
        User findUser = userRepository.findByIdOrElseThrow(id);

        //repository 에서 삭제
        userRepository.delete(findUser);
    }
}

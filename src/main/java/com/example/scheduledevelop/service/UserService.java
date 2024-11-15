package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.user.LoginResponseDto;
import com.example.scheduledevelop.dto.user.SignUpResponseDto;
import com.example.scheduledevelop.dto.user.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    //로그인 로직 구현
    public LoginResponseDto login(String email, String password) {

        //repository 에서 email 로 찾아 객체 생성
        Optional<User> findUser = userRepository.findUserByEmail(email);

        //null 값 예외 처리
        if (findUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exist email = " + email);
        }

        //email 과 password 가 다를 경우 예외 처리
        if (!findUser.get().getEmail().equals(email) || !findUser.get().getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong email or password");
        }

        //email 과 password 가 같을 경우 id 값 반환
        return new LoginResponseDto(findUser.get().getId());
    }
}

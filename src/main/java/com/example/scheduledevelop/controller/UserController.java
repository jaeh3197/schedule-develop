package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.user.*;
import com.example.scheduledevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//유저 컨트롤러 생성
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //UserService 호출
    private final UserService userService;

    //유저 저장
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        //성공 시 응답
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    //특정 유저 조회
    //id 를 매개변수로 받아 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {

        //service 에서 id 를 이용한 조회 메서드 호출
        UserResponseDto userResponseDto = userService.findById(id);

        //성공 시 응답
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    //유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        //service 에서 delete 메서도 호출
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Validated  @RequestBody LoginRequestDto requestDto,
            HttpServletRequest request
    ) {
        //로그인 성공 시 로직
        //성공한 데이터를 LoginResponseDto 에 담아 객체 생성
        LoginResponseDto responseDto = userService.login(requestDto.getEmail(), requestDto.getPassword());

        //id 값을 Long 변수에 저장
        Long userId = responseDto.getId();

        //session 생성
        HttpSession session = request.getSession();

        //회원 정보 조회
        UserResponseDto userResponseDto = userService.findById(userId);

        //session 에 로그인 회원 정보를 저장
        session.setAttribute("sessionKey", userResponseDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.scheduledevelop.dto.user;

import lombok.Getter;

//로그인 시 요청 Dto
@Getter
public class LoginRequestDto {

    private final String email;

    private final String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

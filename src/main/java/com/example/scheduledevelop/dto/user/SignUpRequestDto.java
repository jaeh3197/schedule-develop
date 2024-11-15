package com.example.scheduledevelop.dto.user;

import lombok.Getter;

//유저 저장 시 요청 Dto
@Getter
public class SignUpRequestDto {

    private final String username;

    private final String email;

    private final String password;

    public SignUpRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

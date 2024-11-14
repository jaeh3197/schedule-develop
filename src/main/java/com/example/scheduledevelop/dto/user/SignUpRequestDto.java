package com.example.scheduledevelop.dto.user;

import lombok.Getter;

//유저 저장 요청 시 Dto
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

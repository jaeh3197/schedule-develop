package com.example.scheduledevelop.dto.user;

import lombok.Getter;

//로그인 시 응답 Dto
@Getter
public class LoginResponseDto {

    private final Long id;

    public LoginResponseDto(Long id) {
        this.id = id;
    }
}

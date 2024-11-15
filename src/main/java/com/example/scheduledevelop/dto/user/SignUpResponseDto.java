package com.example.scheduledevelop.dto.user;

import lombok.Getter;

//유저 저장 시 응답 Dto
@Getter
public class SignUpResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    public SignUpResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}

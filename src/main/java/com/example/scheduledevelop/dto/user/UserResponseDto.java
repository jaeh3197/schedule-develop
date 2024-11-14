package com.example.scheduledevelop.dto.user;

import lombok.Getter;

//유저 조회 시 응답 Dto
@Getter
public class UserResponseDto {

    private final String username;

    private final String email;

    public UserResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

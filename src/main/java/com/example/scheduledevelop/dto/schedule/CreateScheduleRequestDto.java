package com.example.scheduledevelop.dto.schedule;

import lombok.Getter;

//일정 저장 시 요청 Dto
@Getter
public class CreateScheduleRequestDto {

    private final String title;

    private final String contents;

    private final String username;

    public CreateScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}

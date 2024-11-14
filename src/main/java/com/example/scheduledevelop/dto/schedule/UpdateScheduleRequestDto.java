package com.example.scheduledevelop.dto.schedule;

import lombok.Getter;

//일정 수정 시 요청 Dto
@Getter
public class UpdateScheduleRequestDto {

    private final String title;

    private final String contents;

    public UpdateScheduleRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}

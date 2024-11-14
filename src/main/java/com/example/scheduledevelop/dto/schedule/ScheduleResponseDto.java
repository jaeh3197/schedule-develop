package com.example.scheduledevelop.dto.schedule;

import lombok.Getter;

//일정 저장 시 응답 Dto
@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }


}

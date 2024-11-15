package com.example.scheduledevelop.dto.schedule;

import com.example.scheduledevelop.entity.Schedule;
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

    //ScheduleResponseDto 를 편하게 생성하기 위해 static 메서드 생성
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }
}

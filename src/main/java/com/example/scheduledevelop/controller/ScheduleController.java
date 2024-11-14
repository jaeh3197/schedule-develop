package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.schedule.CreateScheduleRequestDto;
import com.example.scheduledevelop.dto.schedule.ScheduleResponseDto;
import com.example.scheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//일정 컨트롤러 생성
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    //ScheduleService 호출
    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );

        //성공 시 응답
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }
}
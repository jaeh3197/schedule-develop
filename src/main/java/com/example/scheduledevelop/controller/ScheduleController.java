package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.schedule.CreateScheduleRequestDto;
import com.example.scheduledevelop.dto.schedule.ScheduleResponseDto;
import com.example.scheduledevelop.dto.schedule.UpdateScheduleRequestDto;
import com.example.scheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //일정 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        //List 로 일정 조회
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    //일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {

        //update 메서드로 객체 생성
        ScheduleResponseDto updatedResponseDto = scheduleService.update(id, requestDto.getTitle(), requestDto.getContents());

        //성공 시 응답
        return new ResponseEntity<>(updatedResponseDto, HttpStatus.OK);

    }

    //일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        //delete 메서드 호출
        scheduleService.delete(id);

        //성공 시 응답
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.schedule.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//bean 으로 설정
@Service
@RequiredArgsConstructor
public class ScheduleService {

    //username 을 가져오기 위해 호출
    private final UserRepository userRepository;
    //ScheduleRepository 호출
    private final ScheduleRepository scheduleRepository;

    //일정 생성 로직 구현
    public ScheduleResponseDto save(String title, String contents, String username) {

        //username 으로 가져오기
        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        //객체 생성
        Schedule schedule = new Schedule(title, contents);
        //객체에 값 주입
        schedule.setUser(findUser);

        //객체를 repository 에 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents());
    }
}
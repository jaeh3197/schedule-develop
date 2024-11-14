package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.schedule.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//bean 으로 설정
@Service
@RequiredArgsConstructor
public class ScheduleService {

    //username 을 가져오기 위해 호출
    private final UserRepository userRepository;
    //ScheduleRepository 호출
    private final ScheduleRepository scheduleRepository;

    //일정 저장 로직 구현
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

    //일정 조회 로직 구현
    public List<ScheduleResponseDto> findAll() {

        //모든 일정을 List 에 담아 반환
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto :: toDto)
                .toList();
    }

    //일정 수정 로직 구현
    public ScheduleResponseDto update(Long id, String title, String contents) {

        //예외처리 메서드를 통해 객체 생성
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        //요청 받은 값 주입
        findSchedule.update(title, contents);

        //repository 에 저장
        Schedule updatedSchedule = scheduleRepository.save(findSchedule);

        return new ScheduleResponseDto(updatedSchedule.getId(), updatedSchedule.getTitle(), updatedSchedule.getContents());
    }

    //일정 삭제 로직 구현
    public void delete(Long id) {

        //예외처리 메서드를 통해 객체 생성
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        //repository 에서 삭제
        scheduleRepository.delete(findSchedule);
    }
}

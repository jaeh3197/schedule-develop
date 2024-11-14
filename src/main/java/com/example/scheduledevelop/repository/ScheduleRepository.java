package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

//JPA 적용 한 ScheduleRepository 새성
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    //null 값 예외 처리
    default Schedule findByIdOrElseThrow(Long id) {

        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Does not exist id = " + id
                        )
                );
    }
}

package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA 적용 한 ScheduleRepository 새성
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

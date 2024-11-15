package com.example.scheduledevelop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//BaseEntity 구현
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    //작성일 JPA Auditing 적용
    //수정 불가
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    //수정일 JPA Auditing 적용
    @LastModifiedDate
    private LocalDateTime modifiedAt;

}

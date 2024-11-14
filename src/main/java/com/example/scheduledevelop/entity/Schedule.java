package com.example.scheduledevelop.entity;

import jakarta.persistence.*;

//schedule entity 생성
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    //식별자 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //필드 생성
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    //연관관계 설정
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

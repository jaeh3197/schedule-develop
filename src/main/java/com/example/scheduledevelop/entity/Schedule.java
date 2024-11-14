package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

//schedule entity 생성
@Getter
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

    //많은 contents 저장
    @Column(columnDefinition = "longtext")
    private String contents;

    //연관관계 설정
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //기본 생성자 생성
    public Schedule() {
    }

    //생성자 생성
    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    //유저를 받아오기 위해 Setter 생성
    public void setUser(User user) {
        this.user = user;
    }

    //제목과 내용을 수정하기 위한 Setter 생성
    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}

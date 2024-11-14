package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

//user entity 생성
@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    //식별자 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //필드 생성
    @Column(nullable = false)
    private String username;

    //이메일로 로그인하기 위해 unique 지정
    @Column(nullable = false, unique = true)
    private String email;

    //비밀번호 필드 추가
    //필수값 지정
    @Column(nullable = false)
    private String password;

    //기본 생성자 생성
    public User() {
    }

    //생성자 생성
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

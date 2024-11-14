package com.example.scheduledevelop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    //식별자 구현
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}

package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

//JPA 적용하여 UserRepository 생성
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);

    //default 를 사용하여 메서드 구현
    //null 값 예외 처리
    //username 으로 찾을 경우
    default User findUserByUsernameOrElseThrow(String username) {

        return findUserByUsername(username)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Does not exist username = " + username
                        )
                );
    }

    //id 로 찾을 경우
    default User findByIdOrElseThrow(Long id) {

        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Does not exist id = " + id
                        )
        );
    }
}

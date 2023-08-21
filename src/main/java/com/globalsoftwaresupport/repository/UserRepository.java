package com.globalsoftwaresupport.repository;

import com.globalsoftwaresupport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository         // Not necessary because of extending JpaRepository, but it is a good practise
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserId(Long userId);
    void deleteUserByUserId(Long userId);
}

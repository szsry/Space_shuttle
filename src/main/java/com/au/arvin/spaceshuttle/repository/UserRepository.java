package com.au.arvin.spaceshuttle.repository;

import com.au.arvin.spaceshuttle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {

    List<User> findByUsername(String username);

    User findUserByEmail(String email);

    User findById(Long id);

    //only supported by Spring Boot 2
//    Optional<User> findOne(Long id);


    @Query("select u from User u")
    List<User> findAllUsers();
}

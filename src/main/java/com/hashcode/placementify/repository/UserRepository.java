package com.hashcode.placementify.repository;

import com.hashcode.placementify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = ?1 or u.email= ?1")
    Optional<User> findByUserNameOrEmail(String userNameOrEmail);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}

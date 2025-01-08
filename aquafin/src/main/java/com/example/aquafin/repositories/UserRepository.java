package com.example.aquafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aquafin.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

package com.example.javaBlog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaBlog.Model.Users;

public interface UserRepo extends JpaRepository <Users, Long> {
    
    Users findByUsername(String username);

}

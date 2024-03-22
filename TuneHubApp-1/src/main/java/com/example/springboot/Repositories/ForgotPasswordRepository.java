package com.example.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.ForgotPassword;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, Integer> {

}

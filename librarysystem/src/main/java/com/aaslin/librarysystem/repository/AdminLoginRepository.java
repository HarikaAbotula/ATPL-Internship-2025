package com.aaslin.librarysystem.repository;

import com.aaslin.librarysystem.model.AdminLogin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, String> {
    Optional<AdminLogin> findByUsernameAndPassword(String username, String password);
}


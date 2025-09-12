package com.aaslin.cbt.super_admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aaslin.cbt.super_admin.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);

    // Fetch last Super Admin ID
    @Query(value = "SELECT user_id FROM users WHERE user_id LIKE 'SADM%' ORDER BY user_id DESC LIMIT 1", nativeQuery = true)
    String findLastSuperAdminId();

    // Fetch last Developer ID
    @Query(value = "SELECT user_id FROM users WHERE user_id LIKE 'DEV%' ORDER BY user_id DESC LIMIT 1", nativeQuery = true)
    String findLastDeveloperId();
}


package com.aaslin.librarysystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaslin.librarysystem.model.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {
	Optional<UserLogin> findByUsername(String username);

	Optional<UserLogin> findByUsernameAndUserNum(String username, String userNum);
}


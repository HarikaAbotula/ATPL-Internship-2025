package com.aaslin.spring_security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaslin.spring_security.model.LoginRequest;

//import com.aaslin.spring_security.model.UserEntity;
//
//public interface UserRepository extends JpaRepository<UserEntity,Long> {
//	Optional<UserEntity> findByUsername(String username);	
//}

public interface UserRepository extends JpaRepository<LoginRequest, Long>{
	Optional<LoginRequest> findByusername(String username);
}
package com.aaslin.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaslin.librarysystem.model.User;

public interface UserRepository extends JpaRepository<User,String>{

}

package com.aaslin.librarysystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.librarysystem.model.User;
import com.aaslin.librarysystem.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Optional<User> findByUserNum(String userNum) {
		return userRepository.findById(userNum);
	}

	public boolean exists(String userNum) {
		return userRepository.existsById(userNum);
	}
}



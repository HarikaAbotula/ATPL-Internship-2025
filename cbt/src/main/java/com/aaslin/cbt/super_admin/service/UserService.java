package com.aaslin.cbt.super_admin.service;

import com.aaslin.cbt.super_admin.model.User;

public interface UserService {
	
    User login(String username, String password);
    User createSuperAdmin(String username, String password);
    User createDeveloper(String username, String password, String createdBy);
    
}
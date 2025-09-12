package com.aaslin.cbt.super_admin.service.Implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.cbt.super_admin.model.Role;
import com.aaslin.cbt.super_admin.model.User;
import com.aaslin.cbt.super_admin.repository.RoleRepository;
import com.aaslin.cbt.super_admin.repository.UserRepository;
import com.aaslin.cbt.super_admin.service.UserService;
import com.aaslin.cbt.super_admin.utils.CustomUserIdGenerator;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public User login(String username, String password) {
        return userRepo.findByUsername(username)
                .filter(u -> u.getPassword().equals(password)) 
                .orElse(null);
    }

    @Override
    public User createSuperAdmin(String username, String password) {
        String lastId = userRepo.findLastSuperAdminId();
        String newId = CustomUserIdGenerator.generateNextId(lastId, "SADM");

        Role role = roleRepo.findByRoleName("SUPER ADMIN")
                .orElseThrow(() -> new RuntimeException("Role not found: SUPER ADMIN"));

        User sa = new User();
        sa.setUserId(newId);
        sa.setUsername(username);
        sa.setPassword(password);
        sa.setRole(role);
        sa.setCreatedAt(LocalDateTime.now());
        sa.setCreatedBy(newId);
        sa.setUpdatedAt(LocalDateTime.now());
        sa.setUpdatedBy(newId);

        return userRepo.save(sa);
    }

    @Override
    public User createDeveloper(String username, String password, String createdBy) {
        String lastId = userRepo.findLastDeveloperId();
        String newId = CustomUserIdGenerator.generateNextId(lastId, "DEV");

        Role role = roleRepo.findByRoleName("DEVELOPER")
                .orElseThrow(() -> new RuntimeException("Role not found: DEVELOPER"));

        User dev = new User();
        dev.setUserId(newId);
        dev.setUsername(username);
        dev.setPassword(password);
        dev.setRole(role);
        dev.setCreatedAt(LocalDateTime.now());
        dev.setCreatedBy(createdBy);
        dev.setUpdatedAt(LocalDateTime.now());
        dev.setUpdatedBy(createdBy);

        return userRepo.save(dev);
    }
}

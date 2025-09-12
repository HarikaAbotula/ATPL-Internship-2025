package com.aaslin.cbt.super_admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aaslin.cbt.super_admin.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRoleName(String roleName);
}


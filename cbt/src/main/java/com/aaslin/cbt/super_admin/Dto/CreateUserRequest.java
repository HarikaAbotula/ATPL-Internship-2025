package com.aaslin.cbt.super_admin.Dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
}

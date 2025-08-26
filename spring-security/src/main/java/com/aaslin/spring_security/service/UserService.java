package com.aaslin.spring_security.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UserService {

<<<<<<< HEAD
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(Long userId) {
        return "User with ID " + userId + " deleted successfully!";
    }

    @PreAuthorize("hasRole('USER')")
    public String viewProfile(String username) {
        return "Profile details for user: " + username;
    }
=======
   @PreAuthorize("hasRole('ADMIN')")
   public String deleteUser(Long userId) {
       return "User with ID " + userId + " deleted successfully!";
   }

   @PreAuthorize("hasRole('USER')")
   public String viewProfile(String username) {
       return "Profile details for user: " + username;
   }
>>>>>>> 9cee4792e66a55232df7aedd097895fbc5b44705
}


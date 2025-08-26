package com.aaslin.springboot.repository;

import com.aaslin.springboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public User getUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) 
            	return user;
        }
        return null;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getAllUsers() {
        return userList;
    }
}

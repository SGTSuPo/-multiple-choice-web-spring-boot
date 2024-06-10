package com.example.multiplechoiceweb.service;

import java.util.List;

import com.example.multiplechoiceweb.model.User;
import com.example.multiplechoiceweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String authUser(User user) {
        if(user.getUsername().equals("student")) {
            if (user.getPassword().equals("1")) {
                return "STUDENT";
            }
        }
        if(user.getUsername().equals("teacher")) {
            if (user.getPassword().equals("1")) {
                return "TEACHER";
            }
        }
        return "";
    }
}
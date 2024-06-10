package com.example.ottn.repository;

import com.example.ottn.model.Member;
import com.example.ottn.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User getUserById(long id);
}

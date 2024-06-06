package com.example.multiplechoiceweb.repository;

import com.example.multiplechoiceweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

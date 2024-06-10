package com.example.ottn.repository;

import com.example.ottn.model.User;
import com.example.ottn.model.Class;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClassRepository extends JpaRepository<Class, Long> {
    Class getClassById(Long id);
    List<Class> getClassByHost(User user);
}

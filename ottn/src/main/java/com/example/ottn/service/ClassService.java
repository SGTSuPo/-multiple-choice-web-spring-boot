package com.example.ottn.service;

import com.example.ottn.model.Class;
import com.example.ottn.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Class getClassById(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    public Class createClass(Class classEntity) {
        return classRepository.save(classEntity);
    }

    public Class updateClass(Class classEntity) {
        return classRepository.save(classEntity);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
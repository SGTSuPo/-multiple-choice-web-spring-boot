//package com.example.multiplechoiceweb.service;
//
//import java.util.List;
//import com.example.multiplechoiceweb.model.Class;
//import com.example.multiplechoiceweb.repository.ClassRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ClassService {
//    @Autowired
//    private ClassRepository classRepository;
//
//    public List<Class> getAllClasses() {
//        return classRepository.findAll();
//    }
//
//    public Class getClassById(Long id) {
//        return classRepository.findById(id).orElse(null);
//    }
//
//    public Class createClass(Class classEntity) {
//        return classRepository.save(classEntity);
//    }
//
//    public Class updateClass(Class classEntity) {
//        return classRepository.save(classEntity);
//    }
//
//    public void deleteClass(Long id) {
//        classRepository.deleteById(id);
//    }
//}
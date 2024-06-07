//package com.example.multiplechoiceweb.service;
//
//import java.util.List;
//
//import com.example.multiplechoiceweb.model.Role;
//import com.example.multiplechoiceweb.repository.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RoleService {
//    @Autowired
//    private RoleRepository roleRepository;
//
//    public List<Role> getAllRoles() {
//        return roleRepository.findAll();
//    }
//
//    public Role getRoleById(Long id) {
//        return roleRepository.findById(id).orElse(null);
//    }
//
//    public Role createRole(Role role) {
//        return roleRepository.save(role);
//    }
//
//    public Role updateRole(Role role) {
//        return roleRepository.save(role);
//    }
//
//    public void deleteRole(Long id) {
//        roleRepository.deleteById(id);
//    }
//}
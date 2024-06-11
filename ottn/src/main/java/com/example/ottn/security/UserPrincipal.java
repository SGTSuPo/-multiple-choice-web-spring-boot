package com.example.ottn.security;

import com.example.ottn.model.Role;

import javax.security.auth.Subject;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;

public class UserPrincipal implements Principal, Serializable {
    private String username;
    private String password;
    private Role role;

    public UserPrincipal(String username, String password, Role roles) {
        this.username = username;
        this.password = password;
        this.role = roles;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }
}

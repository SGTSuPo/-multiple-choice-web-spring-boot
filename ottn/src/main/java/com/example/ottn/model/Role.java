package com.example.ottn.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String rolename;
}

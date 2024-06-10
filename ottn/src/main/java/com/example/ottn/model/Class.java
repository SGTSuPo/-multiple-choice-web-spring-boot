package com.example.ottn.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="class")
public class Class {
    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subject;

    private String grade;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;

    public Class(String name, String subject, String grade, User host) {
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.host = host;
    }
}

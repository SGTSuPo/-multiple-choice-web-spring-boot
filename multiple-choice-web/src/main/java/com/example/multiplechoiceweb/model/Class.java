package com.example.multiplechoiceweb.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;

@Entity
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classname;

    private String subject;

    private String grade;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;
    //constructor
    public Class(String classname, String subject, String grade, User host) {
        this.id = id;
        this.classname = classname;
        this.subject = subject;
        this.grade = grade;
        this.host = host;
    }
    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }
}

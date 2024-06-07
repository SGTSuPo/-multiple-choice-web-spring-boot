package com.example.multiplechoiceweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.StringJoiner;

@Getter
@Setter
@Entity
@Table(name = "class")
public class classEntity {
    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Nationalized
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Nationalized
    @Column(name = "subject", nullable = false, length = 50)
    private String subject;

    @Nationalized
    @Column(name = "grade", nullable = false, length = 5)
    private String grade;

    @Override
    public String toString() {
        return "classEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
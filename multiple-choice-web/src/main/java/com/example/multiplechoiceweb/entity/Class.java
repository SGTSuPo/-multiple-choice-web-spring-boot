package com.example.multiplechoiceweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "class")
public class Class {
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
    @Column(name = "grade", length = 5)
    private String grade;

}
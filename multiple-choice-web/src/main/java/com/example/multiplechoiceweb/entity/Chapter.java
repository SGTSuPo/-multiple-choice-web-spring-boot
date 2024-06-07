package com.example.multiplechoiceweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "chapter")
public class Chapter {
    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Nationalized
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Nationalized
    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classID", nullable = false)
    private classEntity classEntityID;

    @Column(name = "flag", nullable = false)
    private Integer flag;

}
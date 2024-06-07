package com.example.multiplechoiceweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Nationalized
    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Nationalized
    @Column(name = "detail", nullable = false, length = 200)
    private String detail;

    @Nationalized
    @Lob
    @Column(name = "A", nullable = false)
    private String a;

    @Nationalized
    @Lob
    @Column(name = "B", nullable = false)
    private String b;

    @Nationalized
    @Lob
    @Column(name = "C", nullable = false)
    private String c;

    @Nationalized
    @Lob
    @Column(name = "D", nullable = false)
    private String d;

    @Nationalized
    @Column(name = "ans", nullable = false, length = 1)
    private String ans;

    @Nationalized
    @Column(name = "explain", nullable = false, length = 200)
    private String explain;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chapterID", nullable = false)
    private Chapter chapterID;

}
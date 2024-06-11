package com.example.ottn.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="question")
public class Question {
    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String detail;

    private String a;

    private String b;

    private String c;

    private String d;

    private String ans;

    private String explaination;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    public Question(String type, String detail, String A, String B, String C, String D, String ans, String explaination, Chapter chapter) {
        this.type = type;
        this.detail = detail;
        this.a = A;
        this.b = B;
        this.c = C;
        this.d = D;
        this.ans = ans;
        this.explaination = explaination;
        this.chapter = chapter;
    }
}

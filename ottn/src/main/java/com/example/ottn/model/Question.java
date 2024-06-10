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

    private String A;

    private String B;

    private String C;

    private String D;

    private String ans;

    private String explain;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

}

//package com.example.multiplechoiceweb.model;
//
//import jakarta.persistence.*;
//import jakarta.persistence.Id;
//import org.springframework.data.annotation.*;
//
//@Entity
//public class Question {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String type;
//
//    private String detail;
//
//    private String A;
//
//    private String B;
//
//    private String C;
//
//    private String D;
//
//    private String answer;
//
//    private String explain;
//
//    @ManyToOne
//    @JoinColumn(name = "chapter_id")
//    private Chapter chapter;
//
//    // getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getDetail() {
//        return detail;
//    }
//
//    public void setDetail(String detail) {
//        this.detail = detail;
//    }
//
//    public String getA() {
//        return A;
//    }
//
//    public void setA(String A) {
//        this.A = A;
//    }
//
//    public String getB() {
//        return B;
//    }
//
//    public void setB(String B) {
//        this.B = B;
//    }
//
//    public String getC() {
//        return C;
//    }
//
//    public void setC(String C) {
//        this.C = C;
//    }
//
//    public String getD() {
//        return D;
//    }
//
//    public void setD(String D) {
//        this.D = D;
//    }
//
//    public String getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
//
//    public String getExplain() {
//        return explain;
//    }
//
//    public void setExplain(String explain) {
//        this.explain = explain;
//    }
//
//    public Chapter getChapter() {
//        return chapter;
//    }
//
//    public void setChapter(Chapter chapter) {
//        this.chapter = chapter;
//    }
//}

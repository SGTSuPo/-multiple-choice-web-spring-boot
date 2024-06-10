package com.example.ottn.repository;

import com.example.ottn.model.Chapter;
import com.example.ottn.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> getAllQuestionByChapter(Chapter chapter);
}

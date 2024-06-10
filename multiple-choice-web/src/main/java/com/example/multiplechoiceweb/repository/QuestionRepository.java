package com.example.multiplechoiceweb.repository;

import com.example.multiplechoiceweb.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

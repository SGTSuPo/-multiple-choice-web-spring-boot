package com.example.ottn.repository;

import com.example.ottn.model.Chapter;
import com.example.ottn.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> getAllByClassID(Class cl);
    Chapter getChapterById(Long id);
}

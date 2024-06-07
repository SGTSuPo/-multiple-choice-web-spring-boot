//package com.example.multiplechoiceweb.service;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.example.multiplechoiceweb.model.Chapter;
//import com.example.multiplechoiceweb.repository.ChapterRepository;
//
//@Service
//public class ChapterService {
//    @Autowired
//    private ChapterRepository chapterRepository;
//
//    public List<Chapter> getAllChapters() {
//        return chapterRepository.findAll();
//    }
//
//    public Chapter getChapterById(Long id) {
//        return chapterRepository.findById(id).orElse(null);
//    }
//
//    public Chapter createChapter(Chapter chapter) {
//        return chapterRepository.save(chapter);
//    }
//
//    public Chapter updateChapter(Chapter chapter) {
//        return chapterRepository.save(chapter);
//    }
//
//    public void deleteChapter(Long id) {
//        chapterRepository.deleteById(id);
//    }
//}
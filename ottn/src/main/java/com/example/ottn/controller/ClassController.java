package com.example.ottn.controller;

import com.example.ottn.model.Chapter;
import com.example.ottn.model.Class;
import com.example.ottn.repository.ChapterRepository;
import com.example.ottn.repository.ClassRepository;
import com.example.ottn.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClassController {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    ChapterRepository chapterRepository;
    @GetMapping("/student/class")
    public String studentClass(Model model, @RequestParam(value="id", required = true)Long userid, @RequestParam(value="c",required = true)Long c) {
//        Long cid = Long.parseLong(c);
        Class cl = classRepository.getClassById(c);
        List<Chapter> chapterList = chapterRepository.getAllByClassID(cl);
        model.addAttribute("chapterList", chapterList);
        model.addAttribute("id", userid);
        model.addAttribute("class", cl);
        return "joinClass";
    }
    @GetMapping("/teacher/class")
    public String teacherClass(Model model, @RequestParam(value="id", required = true)Long userid, @RequestParam(value="c",required = true)Long c) {
//        Long cid = Long.parseLong(c);
        Class cl = classRepository.getClassById(c);
        List<Chapter> chapterList = chapterRepository.getAllByClassID(cl);
        model.addAttribute("chapterList", chapterList);
        model.addAttribute("id", userid);
        model.addAttribute("class", cl);
        model.addAttribute("addChapter", new Chapter());
        return "editClass";
    }
    @PostMapping("/teacher/class")
    public String editClass(Model model, @ModelAttribute Chapter chapter,@RequestParam(value="id", required = true)Long userid, @RequestParam(value="c",required = true)Long c) {
//        Long cid = Long.parseLong(c);
        Class cl = classRepository.getClassById(c);
        chapter.setClassID(cl);
        Chapter ch = new Chapter(chapter.getName(),chapter.getDescription(),chapter.getClassID());
        chapterRepository.save(ch);
        List<Chapter> chapterList = chapterRepository.getAllByClassID(cl);
        model.addAttribute("chapterList", chapterList);
        model.addAttribute("id", userid);
        model.addAttribute("class", cl);
        model.addAttribute("addChapter", new Chapter());
        return "redirect:/teacher/class?id="+userid+"&c="+c;
    }
}

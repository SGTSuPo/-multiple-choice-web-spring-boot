package com.example.multiplechoiceweb.controller;

import com.example.multiplechoiceweb.model.Chapter;
import com.example.multiplechoiceweb.model.Class;
import com.example.multiplechoiceweb.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;
//    test
    public List<Chapter> getChapters() {
        List<Chapter> chapterList = new ArrayList<>();
        chapterList.add(new Chapter("C2","15P", new Class()));
        chapterList.add(new Chapter("C1+2+3","1T", new Class()));
        chapterList.add(new Chapter("All","HK", new Class()));
        return chapterList;
    }
    @GetMapping("/student/class")
    public String studentClass(Model model /*userid*/) {
        List<Chapter> chapterList = getChapters();
        String classname = chapterList.get(0).getClassEntity().getClassname();
        model.addAttribute("chapterList", chapterList);
        model.addAttribute("classname", classname);
        return "joinClass";
    }
    @GetMapping("/teacher/class")
    public String teacherClass(Model model) {
        List<Chapter> chapterList = getChapters();
        String classname = chapterList.get(0).getClassEntity().getClassname();
        model.addAttribute("chapterList", chapterList);
        model.addAttribute("classname", classname);
        model.addAttribute("addChapter", new Chapter());
        return "editClass";
    }
    @PostMapping("/teacher/class")
    public String editClass(Model model, @ModelAttribute Chapter chapter){
//        add Chapter
        return "redirect:/teacher/class";
    }
}

package com.example.ottn.controller;

import com.example.ottn.model.Chapter;
import com.example.ottn.model.Class;
import com.example.ottn.model.Question;
import com.example.ottn.repository.ChapterRepository;
import com.example.ottn.repository.ClassRepository;
import com.example.ottn.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ChapterController {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    QuestionRepository questionRepository;
    @GetMapping("/student/class/chapter")
    public String studentChapter(Model model, @RequestParam(value="id", required = true)Long userid, @RequestParam(value="c",required = true)Long c, @RequestParam(value = "ch",required = true)Long ch) {
//        Long chid = Long.parseLong(ch);
        Chapter chap = chapterRepository.getChapterById(ch);
        List<Question> questionList = questionRepository.getAllQuestionByChapter(chap);
        model.addAttribute("questionList", questionList);
        model.addAttribute("id", userid);
        model.addAttribute("cid", c);
        model.addAttribute("ch", chap);
        return "doChapter";
    }
    @GetMapping("/teacher/class/chapter")
    public String teacherChapter(Model model, @RequestParam(value="id", required = true)Long userid, @RequestParam(value="c",required = true)Long c, @RequestParam(value = "ch",required = true)Long ch) {
        Chapter chap = chapterRepository.getChapterById(ch);
        List<Question> questionList = questionRepository.getAllQuestionByChapter(chap);
        model.addAttribute("questionList", questionList);
        model.addAttribute("id", userid);
        model.addAttribute("cid", c);
        model.addAttribute("ch", chap);
        model.addAttribute("addQuestion", new Question());
        return "makeChapter";
    }
    @PostMapping("/teacher/class/chapter")
    public String makeChapter(Model model, @ModelAttribute("addQuestion")Question ques, @RequestParam(value="id", required = true)Long userid, @RequestParam(value="c",required = true)Long c, @RequestParam(value = "ch",required = true)Long ch) {
        Chapter chap = chapterRepository.getChapterById(ch);
        ques.setChapter(chap);
        Question q = new Question(ques.getType(),ques.getDetail(),ques.getA(),ques.getB(),ques.getC(),ques.getD(),ques.getAns(),ques.getExplaination(),ques.getChapter());
        questionRepository.save(q);
        List<Question> questionList = questionRepository.getAllQuestionByChapter(chap);
        model.addAttribute("chapterList", questionList);
        model.addAttribute("id", userid);
        model.addAttribute("cid", c);
        model.addAttribute("ch", chap);
        model.addAttribute("addQuestion", new Question());
        return "redirect:/teacher/class/chapter?id="+userid+"&c="+c+"&ch="+ch;
    }
}

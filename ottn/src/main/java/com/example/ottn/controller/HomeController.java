package com.example.ottn.controller;

import com.example.ottn.model.Member;
import com.example.ottn.model.User;
import com.example.ottn.model.Class;
import com.example.ottn.repository.ClassRepository;
import com.example.ottn.repository.MemberRepository;
import com.example.ottn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.*;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    MemberRepository memberRepository;
    @GetMapping("/student/home")
    public String studentHome(Model model, @RequestParam(value="id", required = true)Long userid) {
        User user = userRepository.getById(userid);
        List<Member> memberList = memberRepository.getAllByUserId(user.getId());
        List<Class> classList = new ArrayList<>();
        for (Member m : memberList) {
            classList.add(classRepository.getClassById(m.getClassEntity().getId()));
        }
        model.addAttribute("id", userid);
        model.addAttribute("classList", classList);
        return "studentHome";
    }
    @PostMapping("/student/home")
    public String joinClass(@RequestParam(value="id",required = true)Long userid,@RequestParam("classID") String code, Model model) {
        Long classId = Long.parseLong(code);
        User user = userRepository.getById(userid);
        Class cl = classRepository.getClassById(classId);
        if(cl!=null /*kiểm tra*/){
            memberRepository.save(new Member(user,cl));
            return "redirect:/student/home?id="+userid;
        }
        else {
            return "redirect:/student/home?id="+userid;
//            return "redirect:/student?id=11";
        }
    }
    @GetMapping("/teacher/home")
    public String teacherHome(@RequestParam(value = "id",required = true) Long userid,Model model) {
        User user = userRepository.getUserById(userid);
        List<Class> classList = classRepository.getClassByHost(user);
        model.addAttribute("classList", classList);
        model.addAttribute("id", userid);
        model.addAttribute("addClass", new Class());
        return "teacherHome";
    }

    @PostMapping("/teacher/home")
    public String createClass(@RequestParam(value = "id",required = true)Long userid,@ModelAttribute Class c, Model model) {
        //xử lí db
        User user = userRepository.getUserById(userid);
        c.setHost(user);
        Class cl = new Class(c.getName(),c.getGrade(),c.getSubject(),c.getHost());
        classRepository.save(c);
        return "redirect:/teacher/home?id="+userid;
    }

    @RequestMapping("/home")
    public String home(@RequestParam(value = "id",required = true) Long userid) {
        User user = userRepository.getUserById(userid);
        if(user.getRole().getRolename().equals("student")){
            return "redirect:/student/home?id="+userid;
        }
        return "redirect:/teacher/home?id="+userid;
    }
}

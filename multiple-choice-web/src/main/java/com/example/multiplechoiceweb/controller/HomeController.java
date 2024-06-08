package com.example.multiplechoiceweb.controller;

import com.example.multiplechoiceweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.multiplechoiceweb.model.Class;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    //test
    public List<Class> classList() {
        List<Class> classList = new ArrayList<>();
        classList.add(new Class("LS", "Anh", "10", new User("Lộc")));
        classList.add(new Class("SK", "Anh", "10", new User("Tân")));
        classList.add(new Class("RD", "Anh", "12", new User("Lộc")));
        return classList;
    }
    @GetMapping("/student")
    public String studentHome(Model model) {
        List<Class> classList = classList();
        model.addAttribute("classList", classList);
        model.addAttribute("joinClass", new Class());
        return "studentHome";
    }
    @PostMapping("/student")
    public String joinClass(@ModelAttribute Class c, Model model) {
        if(false /*kiểm tra*/){
            model.addAttribute("error","This code does not exist");
            return "redirect:/student";
        }
        else {
            List<Class> classList = classList();
            c.setClassname("new");
            c.setGrade("11");
            c.setSubject("IT");
            c.setHost(new User("Lộc nè"));
            classList.add(c);
            model.addAttribute("classList", classList());
//            model.addAttribute("mes", "Joined class successfully!");
            return "redirect:/student";
        }
    }
    @GetMapping("/teacher")
    public String teacherHome(Model model) {
        List<Class> classList = classList();
        model.addAttribute("classList", classList);
        model.addAttribute("addClass", new Class());
        return "teacherHome";
    }

    @PostMapping("/teacher")
    public String createClass(@ModelAttribute Class c, Model model) {
        //xử lí db
        List<Class> classList = classList();
        c.setHost(new User("Lộc"));
        classList.add(c);
        model.addAttribute("classList", classList());
        model.addAttribute("addClass", new Class());
        return "redirect:/teacher";
    }
}

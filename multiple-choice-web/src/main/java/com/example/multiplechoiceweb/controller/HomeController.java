package com.example.multiplechoiceweb.controller;

import com.example.multiplechoiceweb.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.multiplechoiceweb.model.Class;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/student")
    public String student() {return "studentHome";}
    //test
    @GetMapping("/student")
    public String studentHome(Model model) {
        List<Class> classList = new ArrayList<>();
        classList.add(new Class("LS", "Anh", "10", new User("Lộc")));
        classList.add(new Class("SK", "Anh", "10", new User("Tân")));
        classList.add(new Class("RD", "Anh", "12", new User("Lộc")));
        model.addAttribute("classList", classList);
        model.addAttribute("class",classList);
        return "studentHome";
    }
}

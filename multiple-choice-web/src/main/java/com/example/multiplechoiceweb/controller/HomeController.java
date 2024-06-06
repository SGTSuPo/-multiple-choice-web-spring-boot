package com.example.multiplechoiceweb.controller;

import com.example.multiplechoiceweb.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.multiplechoiceweb.model.Class;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/student")
    public String student() {return "studentHome";}

//    @GetMapping("/student")
//    @ResponseBody
//    public List<Class> studentHome() {
//        List<Class> classList = new ArrayList<Class>();
//        classList.add(new Class(new Long(1),"LS","Anh","10",new User("Lộc")));
//        classList.add(new Class(2,"SK","Anh","10",new User("Tân")));
//        classList.add(new Class(3,"RD","Anh","12",new User("Lộc")));
//        return "studentHome";
//    }
}

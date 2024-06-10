//package com.example.multiplechoiceweb.controller;
//
//
//import com.example.multiplechoiceweb.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import com.example.multiplechoiceweb.model.Class;
//import org.springframework.web.servlet.ModelAndView;
//
////import com.example.multiplechoiceweb.model.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
////import com.example.multiplechoiceweb.model.Class;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class HomeController {
//
//    //test
//    @GetMapping("/student")
//    public String studentHome(Model model) {
//        List<Class> classList = new ArrayList<>();
//        classList.add(new Class("LS", "Anh", "10", new User("Lộc")));
//        classList.add(new Class("SK", "Anh", "10", new User("Tân")));
//        classList.add(new Class("RD", "Anh", "12", new User("Lộc")));
//        model.addAttribute("classList", classList);
//        model.addAttribute("class",classList);
//        return "studentHome";
//    }
//    @PostMapping("/student")
//    public String joinClass(Model model, @RequestParam String code) {
//        if(true /*kiểm tra*/){
//            model.addAttribute("error","This code does not exist");
//            return "redirect:/student";
//        }
//        // ok
//        model.addAttribute("mes","Joined class successfully!");
//        return "redirect:/student";
//    }
//
//    //test
//    @GetMapping("/teacher")
//    public String teacherHome(Model model) {
//        List<Class> classList = new ArrayList<>();
//        classList.add(new Class("LS", "Anh", "10", new User("Lộc")));
//        classList.add(new Class("SK", "Anh", "10", new User("Tân")));
//        classList.add(new Class("RD", "Anh", "12", new User("Lộc")));
//        model.addAttribute("classList", classList);
//        model.addAttribute("class",classList);
//        return "teacherHome";
//    }
//
//    @PostMapping("/teacher")
//    public ResponseEntity<Class> createClass(@RequestBody Class newClass) {
//        //code
//
//        return ResponseEntity.ok(newClass);
//    }
//
//    @RequestMapping("/student")
//    public String student() {return "studentHome";}
//
////    @GetMapping("/student")
////    @ResponseBody
////    public List<Class> studentHome() {
////        List<Class> classList = new ArrayList<Class>();
////        classList.add(new Class(new Long(1),"LS","Anh","10",new User("Lộc")));
////        classList.add(new Class(2,"SK","Anh","10",new User("Tân")));
////        classList.add(new Class(3,"RD","Anh","12",new User("Lộc")));
////        return "studentHome";
////    }
//
//}

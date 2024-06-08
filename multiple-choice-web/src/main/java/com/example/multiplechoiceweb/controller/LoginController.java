package com.example.multiplechoiceweb.controller;

import com.example.multiplechoiceweb.model.User;
import com.example.multiplechoiceweb.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String toLogin(Model model){
//        HttpSession...
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Please enter your both username and password");
            return "login";
        }
        String user = userService.authUser(new User(username,password));
        // HttpSession session = request.getSession();
        // session.setAttribute("user", user);
        if(user.compareTo("STUDENT")==0)
            return "redirect:/student";
        else
            if(user.compareTo("TEACHER")==0) return "redirect:/teacher";
        model.addAttribute("error", "Invalid username or password");
        return "login";

    }
}

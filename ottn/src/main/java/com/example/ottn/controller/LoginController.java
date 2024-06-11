package com.example.ottn.controller;

import com.example.ottn.model.User;
import com.example.ottn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ottn.security.UserPrincipal;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
    public String toLogin(Model model){
//        HttpSession...
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userRepository.findByUsername(username);
        // HttpSession session = request.getSession();
        // session.setAttribute("user", user);
        if(user == null){
            model.addAttribute("error", "User not found!");
            return "login";
        }
        else{
            if(user.getPassword().equals(password)){
                if (user.getRole().getRolename().equals("student")){
                    return "redirect:/student/home?id=" + user.getId();
                }
                else return "redirect:/teacher/home?id=" + user.getId();
            }
            else {
                model.addAttribute("error", "Wrong password");
                return "login";
            }
        }
    }
}

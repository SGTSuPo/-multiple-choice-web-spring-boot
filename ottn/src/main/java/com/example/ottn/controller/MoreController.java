package com.example.ottn.controller;


import com.example.ottn.model.User;
import com.example.ottn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MoreController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:/login";
    }
    @GetMapping("/info")
    public String info(Model model,@RequestParam("id")Long id) {
        User user = userRepository.getUserById(id);
        model.addAttribute("id",id);
        model.addAttribute("user",user);
        return "info";
    }

    @GetMapping("/changepass")
    public String changepass(Model model, @RequestParam("id")Long id) {

        model.addAttribute("id", id);
        return "changePassword";
    }
    @PostMapping("/changepass")
    public String changepass(Model model, @RequestParam("oldpass") String oldpass, @RequestParam("newpass")String newpass,@RequestParam("confirmpass")String confirm,@RequestParam("id")Long id) {
        User user = userRepository.getUserById(id);
        if(oldpass.compareTo(user.getPassword())!=0) {
            model.addAttribute("error","Wrong current password");
        }
        else{
            if(newpass.compareTo(confirm)!=0) {
                model.addAttribute("error","Wrong confirm password");
            }
            else {
                user.setPassword(newpass);
                userRepository.save(user);
            }
        }
        model.addAttribute("id", id);
        return "redirect:/changepass?id="+id;
    }
}

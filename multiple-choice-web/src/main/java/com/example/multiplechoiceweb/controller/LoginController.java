package com.example.multiplechoiceweb.controller;

import com.example.multiplechoiceweb.model.User;
import com.example.multiplechoiceweb.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){return "login";}

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        // Kiểm tra tên đăng nhập và mật khẩu có hợp lệ không
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Please enter your both username and password");
            return "login";
        }
        // Kiểm tra tên đăng nhập và mật khẩu có tồn tại trong database không
        User user = userService.authUser(new User(username,password));
        if (user!= null) {
            // Tạo một phiên đăng nhập (session) và lưu trữ thông tin người dùng
        // HttpSession session = request.getSession();
        // session.setAttribute("user", user);
            return "redirect:/student";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}

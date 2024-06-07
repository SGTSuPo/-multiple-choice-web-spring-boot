package com.example.multiplechoiceweb.controller;

import com.example.multiplechoiceweb.entity.classEntity;
import com.example.multiplechoiceweb.utils.HibernateUtils;

import com.google.gson.Gson;
import netscape.javascript.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("getData")
    @ResponseBody
    public String getData() {
//
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            List<classEntity> classes = session.createQuery("from classEntity", classEntity.class).getResultList();
            // commit transaction
            transaction.commit();
            return new Gson().toJson(classes);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "error";
        }

    }

//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
//        // Kiểm tra tên đăng nhập và mật khẩu có hợp lệ không
//        if (username.isEmpty() || password.isEmpty()) {
//            model.addAttribute("error", "Please enter your both username and password");
//            return "login";
//        }
//        // Kiểm tra tên đăng nhập và mật khẩu có tồn tại trong database không
//        User user = userService.authUser(new User(username,password));
//        if (user!= null) {
//            // Tạo một phiên đăng nhập (session) và lưu trữ thông tin người dùng
//        // HttpSession session = request.getSession();
//        // session.setAttribute("user", user);
//            return "redirect:/student";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }
}

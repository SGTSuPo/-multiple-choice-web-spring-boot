package com.example.multiplechoiceweb.controller;

<<<<<<< HEAD
import com.example.multiplechoiceweb.entity.Class;
import com.example.multiplechoiceweb.entity.Role;
import com.example.multiplechoiceweb.entity.UserAccount;
import com.example.multiplechoiceweb.utils.HibernateUtil;

import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.Transaction;
=======
import com.example.multiplechoiceweb.model.User;
import com.example.multiplechoiceweb.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 14af741c897aade90963075ed70b960335f84a42
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
<<<<<<< HEAD


    @RequestMapping("getData")
    @ResponseBody
    public String getData() {
//
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            List<UserAccount > res = session.createQuery("from UserAccount ").getResultList();
            // commit transaction
            System.out.println(res.toString());
//            System.out.println(new Gson().toJson(res.toString()));
            transaction.commit();
//            return new Gson().toJson(res);
            return "succes";

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "error";
=======
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Please enter your both username and password");
            return "login";
>>>>>>> 14af741c897aade90963075ed70b960335f84a42
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

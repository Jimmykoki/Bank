package edu.bank.controller;


import edu.bank.entity.User;
import edu.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class UserController {
    @Autowired
    UserService userService;



    @RequestMapping({"/"})
    public String toLogin() {
        return "login";
    }

    @GetMapping("/toRegister")
    public String toRegister (){
        return "registration";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            HttpSession session, Model model){
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        if(username.length() < 1 || username.length() > 127 || !username.matches("[_\\-\\.0-9a-z]{1,127}")){
            model.addAttribute("error", "The username or password you entered is invalid");
            return "registration";
        }

        if(password.length() < 1 || password.length() > 127 || !password.matches("[_\\-\\.0-9a-z]{1,127}")){
            model.addAttribute("error", "The username or password you entered is invalid");
            return "registration";
        }

        if (userService.logIn(username, password)){
            session.setAttribute("user", username);
            return "forward:account";
        }
        model.addAttribute("error", "The username you entered have been registered");

        return "registration";
    }







//    @RequestMapping(value = "/forgot")
//    public String forgotGet() { return "forgot"; }
//
//    @RequestMapping(value = "/deposit")
//    public String depositGet(Model model, HttpSession session) {
//        String username = (String) session.getAttribute();
//        double balance = userService.checkDeposit(username);
//        model.addAttribute("balance",balance);
//        model.addAttribute("user",username);
//        return "deposit";
//    }
//
//    @RequestMapping(value = "/logout")
//    public String logoutGet(HttpSession session) {
//        session.removeAttribute();
//        return "/login";
//    }






}

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
            model.addAttribute("uerror", "The username or password you entered is invalid");
            return "registration";
        }

        if(password.length() < 1 || password.length() > 127){
            model.addAttribute("perror", "The password you entered is invalid");
            return "registration";
        }
        session.setAttribute("user", username);
        if (userService.createAccount(username, password)){
            return "redirect:account";
        }
        model.addAttribute("error", "The username you entered have been registered");

        return "registration";
    }


    @PostMapping (value = "/send")
    public String depositPost(
            @RequestParam(value = "send", required = true) String sendMoney,
            HttpSession session,Model model) {
        String username = (String) session.getAttribute("user");
        try {
            if(sendMoney.charAt(0)=='0'){
                throw new NumberFormatException();
            }
            if (userService.depositMoney(username, Double.parseDouble(sendMoney))) {
                double balance = userService.checkDeposit(username);
                model.addAttribute("balance", balance);
                model.addAttribute("user", username);
                return "account";
            }
        }catch (NumberFormatException nfe){
            System.out.println("amount you enter is invalid");
        }
        model.addAttribute("depositError","Deposit error invalid input");
        return "forward:account";
    }


    @PostMapping(value = "/withdraw")
    public String withdrawPost(
            @RequestParam(value = "withdraw", required = true) String amount,
            HttpSession session,Model model) {
        String username = (String) session.getAttribute("user");
        try{
            if(amount.charAt(0)=='0'){
                throw new NumberFormatException();
            }
            if(userService.withdrawMoney(username,Double.parseDouble(amount))){
                double balance = userService.checkDeposit(username);
                model.addAttribute("balance",balance);
                model.addAttribute("user",username);
                return "account";
            }
        }catch (NumberFormatException nfe){
            System.out.println("amount you enter is invalid ");
        }
        model.addAttribute("withdrawError","withdraw error, invalid input");
        return "forward:account";
    }

    @RequestMapping(value = "/account")
    public String depositGet(Model model, HttpSession session) {
        String username = (String) session.getAttribute("user");
        double balance = userService.checkDeposit(username);
        model.addAttribute("balance",balance);
        model.addAttribute("user",username);
        return "account";
    }


    @RequestMapping(value = "/logout")
    public String logoutGet(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping({"/login"})
    public String loginGet(@RequestParam(value = "target", required = false) String target,
                           HttpSession session) {
        //http://localhost:8080/swe266_war_exploded/login?target=http://google.com
        if(target!=null){
            return "redirect:"+target;
        }
        if(session.getAttribute("user")!=null){
            return "forward:account";
        }
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginPost(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            HttpSession session,
            Model model) {
        if (username == "" || password == "") {
            model.addAttribute("password_error","username or password cannot be empty");
            return "login";
        }
        if(userService.logIn(username,password)){
            session.setAttribute("user", username);
            return "forward:account";
        }
        model.addAttribute("password_error","username or password does not match");
        return "login";

    }



}

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



    @GetMapping({"/"})
    public String toLogin() {
        return "login";
    }

    @GetMapping("/toRegister")
    public String toRegister (){
        return "registration";
    }

    @GetMapping("/link")
    public String link(@RequestParam(value = "term") String term){
        if (term!= null){
            return "redirect:"+term;
        }

        return "registration";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "deposit", required = true) String deposit,
            HttpSession session, Model model){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("deposit = " + deposit);

        if(username.length() < 1 || username.length() > 127 || !username.matches("[_\\-\\.0-9a-z]{1,127}")){
            model.addAttribute("uerror", "The username you entered is invalid");
            return "registration";
        }

        if(password.length() < 1 || password.length() > 127){
            model.addAttribute("perror", "The password you entered is invalid");
            return "registration";
        }

        String REGEX = "^(0|[1-9][0-9]*){1}(\\.[0-9]{2})?$";
        double amount = Double.parseDouble(deposit);
        if (!deposit.matches(REGEX)){
            model.addAttribute("derror", "The initial deposit you entered is invalid");
            return "registration";
        }

        if (userService.createAccount(username, password, amount)){
            session.setAttribute("user", username);
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
            if(sendMoney.charAt(0)=='0' || !sendMoney.matches("[1-9]\\d*(\\.\\d{1,2}$)?|[0-9]\\.\\d{1,2}$")){
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
            if(amount.charAt(0)=='0' || !amount.matches("[1-9]\\d*(\\.\\d{1,2}$)?|[0-9]\\.\\d{1,2}$")){
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
        System.out.println("balance = " + balance);
        return "account";
    }


    @RequestMapping(value = "/logout")
    public String logoutGet(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }


    @PostMapping(value = "/login")
    public String loginPost(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            HttpSession session,
            Model model) {

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        if (username == "" || password == "") {
            model.addAttribute("emptyError","username or password cannot be empty");
            return "login";
        }
        if(userService.logIn(username,password)){
            session.setAttribute("user", username);
            return "forward:account";
        }
        model.addAttribute("matchError","username or password is invalid, please change your input and try again");
        return "login";

    }


}

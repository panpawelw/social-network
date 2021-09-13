package com.panpawelw.socialnetwork.controllers;

import javax.validation.Valid;

import com.panpawelw.socialnetwork.entities.User;
import com.panpawelw.socialnetwork.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpAction(@ModelAttribute @Valid User user, BindingResult result, @RequestParam String confirm, Model model) {
        if(!confirm.equals(user.getPassword())){
            model.addAttribute("passwordsDontMatch", "Passwords don't match!");
        }
        if(!result.hasErrors() && confirm.equals(user.getPassword())) {
            user.hashPassword(user.getPassword());
            userService.save(user);
            return "redirect:/";
        }else {
            return "signup";
        }
    }
}
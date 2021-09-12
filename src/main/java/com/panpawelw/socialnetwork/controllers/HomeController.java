package com.panpawelw.socialnetwork.controllers;

import java.util.List;

import com.panpawelw.socialnetwork.entities.User;
import com.panpawelw.socialnetwork.entities.Post;
import com.panpawelw.socialnetwork.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    private final PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/home")
    public String home(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        model.addAttribute("loggedInUser", loggedInUser);
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        return "home";
    }
}
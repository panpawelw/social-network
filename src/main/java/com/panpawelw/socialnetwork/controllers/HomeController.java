package com.panpawelw.socialnetwork.controllers;

import java.util.List;

import com.panpawelw.socialnetwork.entities.User;
import com.panpawelw.socialnetwork.repositories.PostRepository;
import com.panpawelw.socialnetwork.entities.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    private final PostRepository postRepository;

    public HomeController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/home")
    public String home(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        model.addAttribute("loggedInUser", loggedInUser);
        List<Post> allPosts = postRepository.findAllByOrderByCreatedDesc();
        model.addAttribute("allPosts", allPosts);
        return "home";
    }
}
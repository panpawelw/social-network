package pl.pjm77.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Post;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.PostRepository;

@Controller
public class SocialNetworkController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/social_network")
    public String twater(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        model.addAttribute("loggedInUser", loggedInUser);
        List<Post> allTwats = new ArrayList<>();
        allTwats = postRepository.findAllByOrderByCreatedDesc();
        model.addAttribute("allTwats", allTwats);
        return "social_network";
    }
}
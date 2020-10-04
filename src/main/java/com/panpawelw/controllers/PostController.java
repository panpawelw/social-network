package com.panpawelw.controllers;

import java.util.List;

import javax.validation.Valid;

import com.panpawelw.repositories.CommentRepository;
import com.panpawelw.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.panpawelw.entities.Comment;
import com.panpawelw.entities.Post;
import com.panpawelw.entities.User;

@Controller
public class PostController {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    public PostController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("post")
    public String postView(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        Post post = postRepository.findById(id);
        List<Comment> allComments = commentRepository.findAllByPostIdOrderByCreatedDesc(id);
        model.addAttribute("allComments", allComments);
        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return "postview";
    }

    @GetMapping("/newpost")
    public String newPostForm(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        model.addAttribute("post", new Post());
        model.addAttribute("loggedInUser", loggedInUser);
        return "newpost";
    }

    @PostMapping("/newpost")
    public String newPostAction(@SessionAttribute("loggedInUser") User loggedInUser, @ModelAttribute @Valid Post post, BindingResult result) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        if(!result.hasErrors()) {
            post.setUser(loggedInUser);
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
            post.setCreated(created);
            postRepository.saveAndFlush(post);
            return "redirect:/home";
        }else {
            return "newpost";
        }

    }
}
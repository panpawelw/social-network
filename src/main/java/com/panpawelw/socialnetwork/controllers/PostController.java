package com.panpawelw.socialnetwork.controllers;

import java.util.List;

import javax.validation.Valid;

import com.panpawelw.socialnetwork.entities.Comment;
import com.panpawelw.socialnetwork.entities.Post;
import com.panpawelw.socialnetwork.entities.User;
import com.panpawelw.socialnetwork.services.CommentService;
import com.panpawelw.socialnetwork.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PostController {

    private final PostService postService;

    private final CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/post")
    public String postView(@SessionAttribute("loggedInUser") User loggedInUser,
                           @RequestParam(required = false) Long id, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        if(id == null) {
            model.addAttribute("post", new Post());
            model.addAttribute("loggedInUser", loggedInUser);
            return "newpost";
        }
        Post post = postService.findById((long)id);
        List<Comment> allComments = commentService.findAllByPostId(id);
        model.addAttribute("allComments", allComments);
        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return "postview";
    }

    @PostMapping("/post")
    public String newPostAction(@SessionAttribute("loggedInUser") User loggedInUser, @ModelAttribute @Valid Post post, BindingResult result) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        if(!result.hasErrors()) {
            post.setUser(loggedInUser);
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
            post.setCreated(created);
            postService.save(post);
            return "redirect:/home";
        }else {
            return "newpost";
        }
    }
}
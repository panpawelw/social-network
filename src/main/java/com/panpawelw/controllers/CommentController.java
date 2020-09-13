package com.panpawelw.controllers;

import java.util.List;

import javax.validation.Valid;

import com.panpawelw.repositories.CommentRepository;
import com.panpawelw.repositories.PostRepository;
import com.panpawelw.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.panpawelw.entities.Comment;
import com.panpawelw.entities.Post;
import com.panpawelw.entities.User;

@Controller
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("addcomment")
    public String addComment(@SessionAttribute("loggedInUser") User loggedInUser, @ModelAttribute @Valid Comment comment, BindingResult result, @RequestParam long postId, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        if(!result.hasErrors()) {
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
            comment.setCreated(created);
            comment.setUser(loggedInUser);
            comment.setPost(postRepository.findById(postId));
            commentRepository.save(comment);
            return "redirect:/post?id=" + comment.getPost().getId();
        }else {
            Post post = postRepository.findById(postId);
            List<Comment> allComments = commentRepository.findAllByPostIdOrderByCreatedDesc(postId);
            model.addAttribute("allComments", allComments);
            model.addAttribute("post", post);
            return "postview";
        }
    }
}
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CommentController {

    private final CommentService commentService;

    private final PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/comment")
    public String addComment(@SessionAttribute("loggedInUser") User loggedInUser, @ModelAttribute @Valid Comment comment, BindingResult result, @RequestParam long postId, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        if(!result.hasErrors()) {
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
            comment.setCreated(created);
            comment.setUser(loggedInUser);
            comment.setPost(postService.findById(postId));
            commentService.save(comment);
            return "redirect:/post?id=" + comment.getPost().getId();
        }else {
            Post post = postService.findById(postId);
            List<Comment> allComments = commentService.findAllByPostId(postId);
            model.addAttribute("allComments", allComments);
            model.addAttribute("post", post);
            return "postview";
        }
    }
}
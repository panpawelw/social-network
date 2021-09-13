package com.panpawelw.socialnetwork.controllers;

import java.util.List;

import javax.validation.Valid;

import com.panpawelw.socialnetwork.entities.Message;
import com.panpawelw.socialnetwork.entities.Post;
import com.panpawelw.socialnetwork.entities.User;
import com.panpawelw.socialnetwork.services.MessageService;
import com.panpawelw.socialnetwork.services.PostService;
import com.panpawelw.socialnetwork.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MessageController {

    private final MessageService messageService;

    private final UserService userService;

    private final PostService postService;

    public MessageController(MessageService messageService, UserService userService,
                             PostService postService) {
        this.messageService = messageService;
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/message")
    public String viewMessage(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        Message message = messageService.findById(id);
        if(loggedInUser.getId()==message.getReceiver().getId()) {
            message.setUnread(false);
            messageService.save(message);
        }
        model.addAttribute("message", message);
        return "messageview";
    }

    @PostMapping("/message")
    public String sendMessage(@SessionAttribute("loggedInUser") User loggedInUser, @ModelAttribute @Valid Message message, BindingResult result,
                              @RequestParam long senderId, String text, long receiverId, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        System.out.println(message);
        if(!result.hasErrors()) {
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
            message.setCreated(created);
            message.setSender(userService.findById(senderId));
            message.setText(text);
            message.setReceiver(userService.findById(receiverId));
            messageService.save(message);
            System.out.println("Success!");
            return "redirect:/user?id=" + receiverId;
        }else {
            List<Post> usersPosts = postService.findAllByUser(receiverId);
            model.addAttribute("usersPosts", usersPosts);
            System.out.println("Failure!");
            return "userview";
        }
    }
}
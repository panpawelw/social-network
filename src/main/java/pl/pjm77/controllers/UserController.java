package pl.pjm77.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Message;
import pl.pjm77.entities.Post;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.MessageRepository;
import pl.pjm77.repositories.PostRepository;
import pl.pjm77.repositories.UserRepository;

@Controller
public class UserController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("user")
    public String userView(@SessionAttribute ("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        List<Post> usersPosts = postRepository.findAllByUserIdOrderByCreatedDesc(id);
        model.addAttribute("usersTwats", usersPosts);
        if(loggedInUser.getId()==id){
            User user = userRepository.findById(loggedInUser.getId());
            user.setPassword(null);
            model.addAttribute("user", user);
            List<Message> receivedMessages = messageRepository.findAllByReceiverIdOrderByCreatedDesc(loggedInUser.getId());
            List<Message> sentMessages = messageRepository.findAllBySenderIdOrderByCreatedDesc(loggedInUser.getId());
            model.addAttribute("receivedMessages", receivedMessages);
            model.addAttribute("sentMessages", sentMessages);
            return "userownview";
        }else {
            model.addAttribute("message", new Message());
            return "userview";
        }
    }

    @PostMapping("user")
    public String changeUserDetails(@SessionAttribute ("loggedInUser") User loggedInUser,
                                    @ModelAttribute @Valid User user, BindingResult result, @RequestParam String confirm, Model model){
        if(loggedInUser.getUsername()==null) {
            return "redirect:/";
        }
        if(!confirm.equals(user.getPassword())){
            model.addAttribute("outcomeMessage", "Passwords don't match!");
        }
        if(!result.hasErrors() && confirm.equals(user.getPassword())) {
            loggedInUser.setUsername(user.getUsername());
            loggedInUser.hashPassword(user.getPassword());
            loggedInUser.setEmail(user.getEmail());
            userRepository.saveAndFlush(loggedInUser);
            model.addAttribute("passwordsDontMatch", "Your details have been changed!");
            return "redirect:/user?id=" + loggedInUser.getId();
        }else {
            List<Post> usersTwats = postRepository.findAllByUserIdOrderByCreatedDesc(loggedInUser.getId());
            model.addAttribute("usersTwats", usersTwats);
            List<Message> receivedMessages = messageRepository.findAllByReceiverIdOrderByCreatedDesc(loggedInUser.getId());
            List<Message> sentMessages = messageRepository.findAllBySenderIdOrderByCreatedDesc(loggedInUser.getId());
            model.addAttribute("receivedMessages", receivedMessages);
            model.addAttribute("sentMessages", sentMessages);
            return "userownview";
        }
    }
}
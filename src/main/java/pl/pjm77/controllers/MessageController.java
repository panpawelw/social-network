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
import pl.pjm77.entities.Twat;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.MessageRepository;
import pl.pjm77.repositories.TwatRepository;
import pl.pjm77.repositories.UserRepository;

@Controller
public class MessageController {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TwatRepository twatRepository;

	@PostMapping("sendmessage")
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
			message.setSender(userRepository.findById(senderId));
			message.setText(text);
			message.setReceiver(userRepository.findById(receiverId));
			messageRepository.saveAndFlush(message);
			System.out.println("Success!");
			return "redirect:/user?id=" + receiverId;
		}else {
			List<Twat> usersTwats = twatRepository.findAllByUserIdOrderByCreatedDesc(receiverId); 
			model.addAttribute("usersTwats", usersTwats);
			System.out.println("Failure!");
			return "userview";
		}
		
	}

	@GetMapping("message")
	public String viewMessage(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		Message message = messageRepository.findById(id);
		if(loggedInUser.getId()==message.getReceiver().getId()) {
			message.setUnread(false);
			messageRepository.saveAndFlush(message);
		}
		model.addAttribute("message", message);
		return "messageview";
	}
}
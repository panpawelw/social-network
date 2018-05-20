package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Message;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.MessageRepository;
import pl.pjm77.repositories.UserRepository;

@Controller
public class MessageController {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("sendmessage")
	public String sendMessage(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam long sender, String text, long receiver) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		System.out.println(sender + " " + text + " " + receiver);
		Message message = new Message();
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
		message.setCreated(created);
		message.setSender(userRepository.findById(sender));
		message.setText(text);
		message.setReceiver(userRepository.findById(receiver));
		messageRepository.saveAndFlush(message);
		return "redirect:/user?id=" + receiver;
	}

	@GetMapping("message")
	public String viewMessage(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		Message message = messageRepository.findById(id);
		message.setUnread(false);
		messageRepository.saveAndFlush(message);
		model.addAttribute("message", message);
		return "messageview";
	}
}
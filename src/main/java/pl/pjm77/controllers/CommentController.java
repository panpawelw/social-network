package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Comment;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.CommentRepository;
import pl.pjm77.repositories.TwatRepository;
import pl.pjm77.repositories.UserRepository;

@Controller
public class CommentController {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	TwatRepository twatRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("addcomment")
	public String addComment(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam String text, long userId, long twatId) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		Comment comment = new Comment();
		comment.setText(text);
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
		comment.setCreated(created);
		comment.setUser(userRepository.findById(userId));
		comment.setTwat(twatRepository.findById(twatId));
		commentRepository.save(comment);
		return "redirect:/twat?id=" + twatId;
	}
}
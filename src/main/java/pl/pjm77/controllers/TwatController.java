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

import pl.pjm77.entities.Comment;
import pl.pjm77.entities.Twat;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.CommentRepository;
import pl.pjm77.repositories.TwatRepository;

@Controller
public class TwatController {
	
	@Autowired
	private TwatRepository twatRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping("twat")
	public String twatView(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		Twat twat = twatRepository.findById(id);
		List<Comment> allComments = commentRepository.findAllByTwatIdOrderByCreatedDesc(id);
		model.addAttribute("allComments", allComments);
		model.addAttribute("twat", twat);
		model.addAttribute("comment", new Comment());
		return "twatview";
	}
	
	@GetMapping("/newtwat")
	public String newTwatForm(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		model.addAttribute("twat", new Twat());
		model.addAttribute("loggedInUser", loggedInUser);
		return "newtwat";
	}
	
	@PostMapping("/newtwat")
	public String newTwatAction(@SessionAttribute("loggedInUser") User loggedInUser, @ModelAttribute @Valid Twat twat, BindingResult result) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		if(!result.hasErrors()) {
			twat.setUser(loggedInUser);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
			twat.setCreated(created);
			twatRepository.saveAndFlush(twat);
			return "redirect:/twater";
		}else {
			return "newtwat";
		}
		
	}
}
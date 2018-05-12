package pl.pjm77.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		Twat twat = twatRepository.findById(id);
		List<Comment> allComments = commentRepository.findAllByTwatIdOrderByCreatedDesc(id);
		model.addAttribute("allComments", allComments);
		model.addAttribute("twat", twat);
		System.out.println(allComments);
		return "twatview";
	}
}
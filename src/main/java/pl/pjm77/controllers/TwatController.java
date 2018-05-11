package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Comment;
import pl.pjm77.entities.Twat;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.TwatRepository;

@Controller
public class TwatController {
	
	@Autowired
	private TwatRepository twatRepository;
	
	@GetMapping("twat")
	public String twatView(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
		Twat twat = twatRepository.findById(id);
		model.addAttribute(twat);
		return "twatview";
	}
}
package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Twat;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.TwaterRepository;

@Controller
public class TwaterController {
	
	@Autowired
	private TwaterRepository twaterRepository;

	@GetMapping("/twater")
	public String twater(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
		model.addAttribute("loggedInUser", loggedInUser);
		return "twater";
	}
	
	@GetMapping("/newtwat")
	public String newTwatForm(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
		model.addAttribute("twat", new Twat());
		model.addAttribute("loggedInUser", loggedInUser);
		return "newtwat";
	}
	
	@PostMapping("/newtwat")
	public String newTwatAction(@SessionAttribute("loggedInUser") User loggedInUser, @ModelAttribute Twat twat) {
		twat.setUser(loggedInUser);
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
		twat.setCreated(created);
		twaterRepository.save(twat);
		System.out.println(twat);
		return "twater";
	}
}
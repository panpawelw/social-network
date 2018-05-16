package pl.pjm77.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Twat;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.TwatRepository;

@Controller
public class TwaterController {
	
	@Autowired
	private TwatRepository twatRepository;

	@GetMapping("/twater")
	public String twater(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		model.addAttribute("loggedInUser", loggedInUser);
		List<Twat> allTwats = new ArrayList<>();
		allTwats = twatRepository.findAllByOrderByCreatedDesc();
		model.addAttribute("allTwats", allTwats);
		return "twater";
	}
}
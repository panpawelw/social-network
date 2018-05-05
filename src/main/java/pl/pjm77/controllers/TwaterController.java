package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
public class TwaterController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/twater")
	public String twater(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
		System.out.println(loggedInUser.toString());
		model.addAttribute("loggedInUser", loggedInUser);
		return "twater";
	}
}
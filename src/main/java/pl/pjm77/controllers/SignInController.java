package pl.pjm77.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
public class SignInController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String signIn(Model model) {
		model.addAttribute("user", new User());
		return "signin";
	}
	
	@PostMapping("/")
	public String signInAction(@ModelAttribute User user) {
		System.out.println(user.toString());
		User userFromDatabase = userRepository.findByUsername(user.getUsername());
		System.out.println(userFromDatabase.toString());
		return "redirect:/twater";
	}
}
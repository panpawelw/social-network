package pl.pjm77.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
public class SignUpController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/signup")
	public String signUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUpAction(@ModelAttribute User user, @RequestParam String confirm) {
		System.out.println(user.toString());
		System.out.println(confirm);
		if(BCrypt.checkpw(confirm, user.getPassword())) {
			userRepository.save(user);
			return "redirect:/twater";
		}else {
		    return "redirect:/signup";
		}
	}
}
package pl.pjm77.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
public class SignInController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String signIn() {
		return "signin";
	}
	
	@PostMapping("/")
	public String signInAction(Model model, @RequestParam String username, String password) {
		User user = userRepository.findByUsername(username);
		if(user==null) {
			model.addAttribute("usernameError", "This username doesn't exist!");
			return "signin";
		}
		if(BCrypt.checkpw(password, user.getPassword())) {
			return "redirect:/twater";
		}else {
			model.addAttribute("passwordError", "Incorrect password!");
			return "signin";
		}
	}
}
package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
public class SignUpController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/signup")
	public String signUpForm() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUpAction(Model model, @RequestParam String username, String email, String password, String confirm) {
		System.out.println("username: " + username + ", email: " + email + ", password: " + password + ", confirm: " + confirm);
		if(password.equals(confirm)) {
			User user = new User();
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			userRepository.save(user);
			return "redirect:/";
		}else {
		    model.addAttribute("username", username);
		    model.addAttribute("email", email);
		    return "redirect:/signuperror1/";
		}
	}
}
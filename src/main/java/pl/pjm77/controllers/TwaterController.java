package pl.pjm77.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TwaterController {

	@GetMapping("/")
	public String twater() {
		return "twater";
	}
	
	@GetMapping("/signin")
	public String signInForm() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String signUpForm() {
		return "signup";
	}
	
	@PostMapping("/signin")
	public String signInAction(@RequestParam String username, String password) {
		System.out.println("username: " + username + ", password: " + password);
		return "redirect:/";
	}
	
	@PostMapping("/signup")
	public String signUpAction(@RequestParam String username, String email, String password, String confirm ) {
		System.out.println("username: " + username + ", email: " + email + ", password: " + password + ", confirm: " + confirm);
		return "redirect:/";
	}
}
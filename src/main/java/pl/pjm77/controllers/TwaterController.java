package pl.pjm77.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String signUp() {
		return "signup";
	}
	
	@PostMapping("/signin")
	public String signInAction() {
		return "twater";
	}
}
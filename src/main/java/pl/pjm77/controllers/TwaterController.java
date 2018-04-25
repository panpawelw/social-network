package pl.pjm77.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TwaterController {

	@GetMapping("/")
	public String twater() {
		return "twater";
	}
	
	@GetMapping("/signin")
	public String signIn() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String signUp() {
		return "signup";
	}
}
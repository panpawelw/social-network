package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.pjm77.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("user")
	public String userView() {
		return "userview";
	}
}
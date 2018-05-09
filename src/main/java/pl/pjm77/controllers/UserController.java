package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("user")
	public String userView(@SessionAttribute ("loggedInUser") User loggedInUser, @RequestParam long id) {
		if(loggedInUser.getId()==id){
			return "userownview";
		}else {
			return "userview";
		}
	}
}
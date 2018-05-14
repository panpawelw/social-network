package pl.pjm77.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Twat;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.TwatRepository;
import pl.pjm77.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private TwatRepository twatRepository;
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("user")
	public String userView(@SessionAttribute ("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		List<Twat> usersTwats = twatRepository.findAllByUserIdOrderByCreatedDesc(id); 
		model.addAttribute("usersTwats", usersTwats);
		if(loggedInUser.getId()==id){
			model.addAttribute("user", loggedInUser);
			return "userownview";
		}else {
			return "userview";
		}
	}
	
	@PostMapping("user")
	public String changeUserDetails(@SessionAttribute ("loggedInUser") User loggedInUser, 
			@ModelAttribute User user, @RequestParam String password, @RequestParam String confirm){
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		if(password.equals(confirm)) {
			loggedInUser.setUsername(user.getUsername());
			loggedInUser.setPassword(password);
			loggedInUser.setEmail(user.getEmail());
			userRepository.saveAndFlush(loggedInUser);
		}
		return "redirect:/user?id=" + loggedInUser.getId();
	}
}
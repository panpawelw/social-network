package pl.pjm77.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Twat;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.TwatRepository;

@Controller
public class UserController {
	
	@Autowired
	private TwatRepository twatRepository;

	@GetMapping("user")
	public String userView(@SessionAttribute ("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
		List<Twat> usersTwats = twatRepository.findAllByUserIdOrderByCreatedDesc(id); 
		model.addAttribute("usersTwats", usersTwats);
		if(loggedInUser.getId()==id){
			return "userownview";
		}else {
			return "userview";
		}
	}
}
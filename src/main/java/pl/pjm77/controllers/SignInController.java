package pl.pjm77.controllers;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
@SessionAttributes("loggedInUser")
public class SignInController {
	
	@ModelAttribute("loggedInUser")
	public User setUpUser() {
		return new User();
	}
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String signIn(Model model) {
		model.addAttribute("user", new User());
		return "signin";
	}
	
	@PostMapping("/")
	public String signInAction(@ModelAttribute @Valid User user, BindingResult result, Model model) {
		if(!result.hasErrors()) {
			User loggedInUser = userRepository.findByUsername(user.getUsername());
			if(loggedInUser==null){
				model.addAttribute("usernameError", "This username does not exist!");
				return "signin";
			}
			if(!BCrypt.checkpw(user.getPassword(), loggedInUser.getPassword())) {
				model.addAttribute("passwordError", "Incorrect password!");
				return "signin";
			}
			model.addAttribute("loggedInUser", loggedInUser);
			return "redirect:/twater";
		}else {
		    return "signin";
		}
	}
	
	@GetMapping("/signout")
	public String signOut(Model model) {
		model.addAttribute("loggedInUser", new User());
		return "redirect:/";
	}
}
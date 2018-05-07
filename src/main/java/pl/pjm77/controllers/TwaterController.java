package pl.pjm77.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
public class TwaterController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/twater")
	public String twater() {
		return "twater";
	}
	
//	@GetMapping("/signin")
//	public String signInForm() {
//		return "signin";
//	}
//	
//	@GetMapping("/signup")
//	public String signUpForm() {
//		return "signup";
//	}
//	
//	@GetMapping("/signinerror1")
//	public String signInFormError1(Model model, @RequestParam String username) {
//		System.out.println(username);
//		model.addAttribute("passError", "Wrong username or password!");
//		return "signin";
//	}
//	
//	@GetMapping("/signuperror1")
//	public String signUpFormError1(Model model, @RequestParam String username, String email) {
//		System.out.println(username + " , " + email);
//		model.addAttribute("passError", "Passwords don't match! Try again!");
//		return "signup";
//	}
//	
//	@PostMapping("/signin")
//	public String signInAction(Model model, @RequestParam String username, String password) {
//		User user = new User();
//		user = userRepository.findUserByUsername(username);
//		System.out.println(user.toString());
//		if(BCrypt.checkpw(password, user.getPassword())) {
//			return "redirect:/";
//		}else {
//			model.addAttribute("username", username);
//			return "redirect:/signinerror1/";
//		}
//	}
//	
//	@PostMapping("/signup")
//	public String signUpAction(Model model, @RequestParam String username, String email, String password, String confirm) {
//		System.out.println("username: " + username + ", email: " + email + ", password: " + password + ", confirm: " + confirm);
//		if(password.equals(confirm)) {
//			User user = new User();
//			user.setUsername(username);
//			user.setEmail(email);
//			user.setPassword(password);
//			userRepository.saveUser(user);
//			return "redirect:/";
//		}else {
//		    model.addAttribute("username", username);
//		    model.addAttribute("email", email);
//		    return "redirect:/signuperror1/";
//		}
//	}
}
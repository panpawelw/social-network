package pl.pjm77.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.pjm77.entities.User;
import pl.pjm77.repositories.UserRepository;

@Controller
public class SignUpController {
	
	@Autowired
	Validator validator;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/signup")
	public String signUpForm(HttpServletRequest request, Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUpAction(@ModelAttribute @Valid User user, BindingResult result, @RequestParam String confirm, RedirectAttributes redirectAttributes, Model model) {
		if(!confirm.equals(user.getPassword())){
			model.addAttribute("passwordsDontMatch", "Hasła nie pasują!");
		}
		if(!result.hasErrors() && confirm.equals(user.getPassword())) {
			user.hashPassword(user.getPassword());
			userRepository.save(user);
			return "redirect:/";
		}else {
		    return "/signup";
		}
	}
}
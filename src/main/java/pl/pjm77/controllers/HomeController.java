package pl.pjm77.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Post;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.PostRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/home")
	public String home(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		model.addAttribute("loggedInUser", loggedInUser);
		List<Post> allPosts = postRepository.findAllByOrderByCreatedDesc();
		model.addAttribute("allPosts", allPosts);
		return "home";
	}
}
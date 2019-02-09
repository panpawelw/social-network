package pl.pjm77.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.pjm77.entities.Comment;
import pl.pjm77.entities.Post;
import pl.pjm77.entities.User;
import pl.pjm77.repositories.CommentRepository;
import pl.pjm77.repositories.PostRepository;

@Controller
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping("twat")
	public String twatView(@SessionAttribute("loggedInUser") User loggedInUser, @RequestParam long id, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		Post post = postRepository.findById(id);
		List<Comment> allComments = commentRepository.findAllByPostIdOrderByCreatedDesc(id);
		model.addAttribute("allComments", allComments);
		model.addAttribute("twat", post);
		model.addAttribute("comment", new Comment());
		return "twatview";
	}
	
	@GetMapping("/newpost")
	public String newTwatForm(@SessionAttribute("loggedInUser") User loggedInUser, Model model) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		model.addAttribute("post", new Post());
		model.addAttribute("loggedInUser", loggedInUser);
		return "newpost";
	}
	
	@PostMapping("/newpost")
	public String newTwatAction(@SessionAttribute("loggedInUser") User loggedInUser, @ModelAttribute @Valid Post post, BindingResult result) {
		if(loggedInUser.getUsername()==null) {
			return "redirect:/";
		}
		if(!result.hasErrors()) {
			post.setUser(loggedInUser);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp created = new java.sql.Timestamp(date.getTime());
			post.setCreated(created);
			postRepository.saveAndFlush(post);
			return "redirect:/home";
		}else {
			return "newpost";
		}
		
	}
}
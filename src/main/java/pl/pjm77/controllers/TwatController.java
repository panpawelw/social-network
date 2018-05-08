package pl.pjm77.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.pjm77.repositories.TwatRepository;

@Controller
public class TwatController {
	
	@Autowired
	private TwatRepository twatRepository;

	@GetMapping("twat")
	public String twatView() {
		return "twatview";
	}
}
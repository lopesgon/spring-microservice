package ch.flopes.spring.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Profile({"dev"})
public class TestingController {

	@GetMapping
	public String getTopics() {
		return "index.html";
	}

}

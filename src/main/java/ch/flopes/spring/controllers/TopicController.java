package ch.flopes.spring.controllers;

import java.util.List;
import java.util.Arrays;

import ch.flopes.spring.models.impl.*;
import ch.flopes.spring.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping
	public List<Topic> getTopics() {
		return this.topicService.getAllTopics();
	}
	
	@GetMapping("/{id}")
	public Topic getTopic(@PathVariable String id) {
		return this.topicService.getTopic(id);
	}
	
	@PostMapping("")
	public void addTopic(@RequestBody Topic topic) {
		this.topicService.addTopic(topic);
	}

}

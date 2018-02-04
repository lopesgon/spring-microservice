package ch.flopes.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import ch.flopes.spring.models.impl.Topic;
import ch.flopes.spring.services.TopicService;

@CrossOrigin(origins = "http://localhost:8080/topics")
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
	
	@PostMapping("/load-data-objects")
	@Profile({"dev", "intg"})
	public void loadDataObject(@RequestBody String jsonString) {
		DBObject topics = (DBObject) JSON.parse(jsonString);
		topicService.loadTopicsObject(topics);
	}
	
	@PostMapping("/load-data-array")
	@Profile({"dev", "intg"})
	public void loadDataArray(@RequestBody String jsonString) {
		DBObject topics = (DBObject) JSON.parse(jsonString);
		topicService.loadTopicsArray(topics);
	}

}

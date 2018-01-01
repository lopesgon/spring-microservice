package ch.flopes.spring.services;

import java.util.List;

import org.springframework.context.annotation.Profile;

import ch.flopes.spring.models.impl.Topic;

public interface TopicService {

	public List<Topic> getAllTopics();
	public Topic getTopic(String id);
	public void addTopic(Topic topic);
	
	@Profile({"dev", "intg"})
	public void loadTopics(List<Topic> topics);
	
}

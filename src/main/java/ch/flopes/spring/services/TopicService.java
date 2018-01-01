package ch.flopes.spring.services;

import java.util.List;

import ch.flopes.spring.models.impl.Topic;

public interface TopicService {

	public List<Topic> getAllTopics();
	public Topic getTopic(String id);
	public void addTopic(Topic topic);
	
}

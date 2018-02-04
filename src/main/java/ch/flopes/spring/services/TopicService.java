package ch.flopes.spring.services;

import java.util.List;

import org.springframework.context.annotation.Profile;

import com.mongodb.DBObject;

import ch.flopes.spring.models.impl.Topic;

public interface TopicService {

	public List<Topic> getAllTopics();
	public Topic getTopic(String id);
	public void addTopic(Topic topic);
	
	@Profile({"dev", "other"})
	public void loadTopicsObject(DBObject topics);
	@Profile({"dev", "other"})
	public void loadTopicsArray(DBObject topics);
	
}

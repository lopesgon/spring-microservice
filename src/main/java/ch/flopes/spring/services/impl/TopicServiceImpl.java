package ch.flopes.spring.services.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ch.flopes.spring.models.impl.Topic;
import ch.flopes.spring.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	public TopicServiceImpl() { }

	@Override
	public List<Topic> getAllTopics() {
		//return this.topics;
		return null;
	}
	
	@Override
	public Topic getTopic(String id) {
		// return topics.stream().filter(t -> t.getId().equals(new Long(id))).findFirst().get();
		return null;
	}

	@Override
	public void addTopic(Topic topic) {
		// this.topics.add(topic);
	}

	@Override
	@Profile({"dev", "intg"})
	public void loadTopics(List<Topic> topics) {
		// TODO Auto-generated method stub
	}
	
}

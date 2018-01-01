package ch.flopes.spring.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import ch.flopes.spring.models.impl.Topic;
import ch.flopes.spring.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

/*	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("Spring", "A first app introduction to spring boot"),
			new Topic("Learning", "Learning many ways of developing apps")
	));*/
	
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
}

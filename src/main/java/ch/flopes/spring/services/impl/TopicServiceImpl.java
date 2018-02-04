package ch.flopes.spring.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.bson.BasicBSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import ch.flopes.spring.models.TopicRepository;
import ch.flopes.spring.models.impl.Topic;
import ch.flopes.spring.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public TopicServiceImpl() { }

	@Override
	public List<Topic> getAllTopics() {
		return this.topicRepository.findAll();
	}
	
	@Override
	public Topic getTopic(String id) {
		return this.topicRepository.findById(id);
		// return topics.stream().filter(t -> t.getId().equals(new Long(id))).findFirst().get();
	}

	@Override
	public void addTopic(Topic topic) {
		this.topicRepository.insert(topic);
	}

	@Override
	@Profile({"dev", "other"})
	public void loadTopicsObject(DBObject jsonObjects) {		
		System.out.println("Cleaning Collection of Topics");
		topicRepository.deleteAll();
		
		BasicDBObject items = (BasicDBObject) jsonObjects;
		
		List<Topic> topics = new ArrayList<>();
		for(String item : items.keySet()) {
			Topic topic = new Topic();
			topic.setTitle(item);
			
			BasicBSONObject values = (BasicBSONObject) items.get(item);
			topic.setDescription((String)values.get(TopicFields.DESC.toString()));
			
			topics.add(topic);
		}
		
		this.topicRepository.save(topics);
		System.out.println("New Collection injected into MongoDB");
	}
	
	@Override
	@Profile({"dev", "other"})
	public void loadTopicsArray(DBObject jsonObjects) {		
		System.out.println("Cleaning Collection of Topics");
		topicRepository.deleteAll();
		
		BasicDBList items = (BasicDBList) jsonObjects.get(TopicFields.DATA.toString());
		Iterator<Object> iterator = items.iterator();
		
		HashSet<Topic> topics = new HashSet<>(items.size());
		while(iterator.hasNext()) {
			Topic topic = new Topic();
			BasicBSONObject item = (BasicBSONObject) iterator.next();			
			topics.add(topic);
		}
		
		this.topicRepository.save(topics);
		System.out.println("New Collection injected into MongoDB");
	}
}

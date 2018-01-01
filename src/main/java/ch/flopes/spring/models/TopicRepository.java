package ch.flopes.spring.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ch.flopes.spring.models.impl.Topic;

@RepositoryRestResource(collectionResourceRel = "topic")
public interface TopicRepository extends MongoRepository<Topic, ObjectId> {
	
	public Topic findById(String id);
	
}

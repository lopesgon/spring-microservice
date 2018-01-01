package ch.flopes.spring.models.impl;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="topic")
public class Topic {
	
	@Id
	private ObjectId id;

	@Field("title")
	private String title;

	@Field("description")
	private String description;
	
	private Topic() {
		// nothing to do
	}
	public Topic(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package ch.flopes.spring.models.impl;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
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
	
	@Field("timestamp")
	private Date timestamp;
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Topic() {
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(this.title)
				.append(this.description)
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this);
	}

}

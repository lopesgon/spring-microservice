package ch.flopes.spring.services.impl;

public enum TopicFields {
	
	DATA("data"),
	
	NAME("name"),
	DESC("description"),
	EXTRACT_DATE("timestamp");
	
	private String field;
	
	TopicFields(String field) {
		this.field = field;
	}
	
	public String toString() {
		return this.field;
	}
	
}

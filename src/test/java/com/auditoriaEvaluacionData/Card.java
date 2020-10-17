package com.auditoriaEvaluacionData;

public class Card {
	
	public Card(String type, String title, String description) {
	
		this.type = type;
		
		this.title = title;
		
		this.description = description;
		
	}
	
	public String getType() {
		
		return type;
	
	}

	public void setType(String type) {
	
		this.type = type;
	
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

	private String type;
	
	private String title;
	
	private String description;
	
}

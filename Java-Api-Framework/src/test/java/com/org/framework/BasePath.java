package com.org.framework;

public enum BasePath {
	
	WEATHER("/weather");
	
	private String value;

	BasePath(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}

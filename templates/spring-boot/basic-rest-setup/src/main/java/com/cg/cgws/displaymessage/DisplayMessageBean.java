package com.cg.cgws.displaymessage;

public class DisplayMessageBean {
	private String message;

	public DisplayMessageBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("Bean [message=%s]", message);
	}


}

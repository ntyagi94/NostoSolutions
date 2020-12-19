package com.nosto.model;


public class ResponseObject {
	
	private final boolean status;
	private final String content;
	private final String error;
	private final long time;
	
	public ResponseObject(boolean status, String content) {
		this.status = status;
		this.content = content;
		this.error = null;
		this.time = System.currentTimeMillis();
	}
	
	public ResponseObject(boolean status, String content, String error) {
		this.status = status;
		this.content = content;
		this.error = error.toString();
		this.time = System.currentTimeMillis();		
	}
	
	public ResponseObject(boolean status, String content, String error, long time) {
		this.status = status;
		this.content = content;
		this.error = error.toString();
		this.time = time;	
		
	}

	public boolean isStatus() {
		return status;
	}

	public String getContent() {
		return content;
	}

	public String getErrors() {
		return error;
	}

	public long getTime() {
		return time;
	}
}

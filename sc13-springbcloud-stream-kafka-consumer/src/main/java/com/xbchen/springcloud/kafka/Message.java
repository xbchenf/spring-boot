package com.xbchen.springcloud.kafka;


public class Message {
    private long timestamp;
    public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;
    
    public Message()
    {
    	
    }
    
    public Message(long timestamp, String message)
    {
    	this.timestamp = timestamp;
    	this.message = message;
    }

	@Override
	public String toString() {
		return "User [timestamp=" + timestamp + ", message=" + message+ "]";
	}
    
}

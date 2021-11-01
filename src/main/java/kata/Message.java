package kata;

import java.time.LocalTime;

public class Message {
	
	private String message;
	private LocalTime timeStamp;

	public Message(String message) {
		this.message = message;
		this.timeStamp = ApplicationTime.getApplicationTime();
	}
	
	public String getMessage() {
		return this.message;
	}

	public LocalTime getTimeStamp() {
		return timeStamp;
	}
}

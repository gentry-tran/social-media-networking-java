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

	public String getTimeElapsedInfo() {
		
		int minutesElapsedSincePosting = TimeElapsedCalculator.calculateElapsedTimeInMinutes(timeStamp);
		
		if(minutesElapsedSincePosting > 0) {
			return "(" + minutesElapsedSincePosting + " minutes ago)"; 
		}
		
		return null;
	}
}

package kata;

import java.time.LocalTime;

public class TimeElapsedCalculator {
	
	public static Integer calculateElapsedTimeInMinutes(LocalTime timeStamp) {
		return ApplicationTime.getApplicationTime().getMinute() - timeStamp.getMinute();
	}
}

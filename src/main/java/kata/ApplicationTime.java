package kata;

import java.time.LocalTime;

public class ApplicationTime {
	
	private static LocalTime applicationTime = LocalTime.now();

	
	static void setApplicationTime(LocalTime time) {
		applicationTime = time;
	}

	public static LocalTime getApplicationTime() {
		return applicationTime;
	}
}

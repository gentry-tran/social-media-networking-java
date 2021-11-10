package kata;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class TimeElapsedCalculator {
	
	public static String calculateElapsedTime(LocalTime timestamp) {
		Long timeDifference = timestamp.until(ApplicationTime.getApplicationTime(), ChronoUnit.SECONDS);
		
		if(timeDifference/86400 >= 1) {
			return formatTimeDifferenceWithTimeUnit(timeDifference/86400, "days");
		}
		if(timeDifference/3600 >= 1) {
			return formatTimeDifferenceWithTimeUnit(timeDifference/3600, "hours");
		}
		
		if(timeDifference/60 >= 1) {
			return formatTimeDifferenceWithTimeUnit(timeDifference/60, "minutes");
		}
		

		return formatTimeDifferenceWithTimeUnit(timeDifference, "seconds");
	}

	
	public static String formatTimeDifferenceWithTimeUnit(Long timeStamp, String timeUnit) {
		return String.format("(%d %s ago)", Math.abs(timeStamp.intValue()), timeUnit);
	}
}

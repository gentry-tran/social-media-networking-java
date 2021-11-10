package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class TestTimeElapsedCalculator {
	
	@Test
	public void timeUtilityMethodCanReturnElapsedTimeWithMinutesFromTimeStamps() {
		ApplicationTime.setApplicationTime(LocalTime.NOON);
		Message message = new Message("First Post at 12:00.");
		ApplicationTime.setApplicationTime(LocalTime.NOON.plusMinutes(1));
		Message message2 = new Message("Second Post at 12:01.");
		ApplicationTime.setApplicationTime(LocalTime.NOON.plusMinutes(2));
		assertEquals("(2 minutes ago)", message.getTimeElapsedInfo());
		assertEquals("(1 minutes ago)", message2.getTimeElapsedInfo());
	}
	

	@Test
	public void timeUtilityMethodCanReturnElapsedTimeWithSecondsFromTimeStamps() {
		ApplicationTime.setApplicationTime(LocalTime.NOON);
		Message message = new Message("First Post at 11:59:45.");
		ApplicationTime.setApplicationTime(LocalTime.NOON.minusSeconds(15));
		assertEquals("(15 seconds ago)", message.getTimeElapsedInfo());
	}
}

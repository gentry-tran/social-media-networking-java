package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class TestMessage {

	@Test
	public void messageReturnsATimestamp() {
		ApplicationTime.setApplicationTime(LocalTime.NOON);
		Message message = new Message("I love Integral!");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		assertEquals("12:00", message.getTimeStamp().format(formatter));
	}
}

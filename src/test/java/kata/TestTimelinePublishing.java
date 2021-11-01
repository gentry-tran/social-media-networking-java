package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestTimelinePublishing {
	
	@Test
	public void newUserReturnsName() {
		User user = new User("Alice");
		assertEquals("Alice", user.getName());
	}
}

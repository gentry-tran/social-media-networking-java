package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTimelineViewing {
	
	User user;
	TimelineManager timelineManager;
	
	@BeforeEach
	public void before() {
		user = new User("Alice");
		timelineManager = new TimelineManager();
	}
	
	@Test
	public void userCanViewTimelineMessages() {
		timelineManager.publish(user, new Message("I love the weather today."));
		assertEquals("I love the weather today.", timelineManager.getTimeline(user).getMessages().get(0).getMessage());
	}

}

package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTimelinePublishing {
	
	User user;
	
	@BeforeEach
	public void before() {
		user = new User("Alice");
	}
	
	@Test
	public void newUserReturnsName() {
		assertEquals("Alice", user.getName());
	}
	
	@Test
	public void timelineReturnsZeroMessages() {
		Timeline timeline = new Timeline();
		assertEquals(0, timeline.getSize());
	}
	
	@Test
	public void oneMessageIsReturnedWhenUserPublishesToTimeline() {
		TimelineManager timelineManager = new TimelineManager();
		Message message = new Message("");
		timelineManager.publish(user, message);
		Timeline timeline = timelineManager.getTimeline(user);
		assertEquals(1, timeline.getSize());
	}
}

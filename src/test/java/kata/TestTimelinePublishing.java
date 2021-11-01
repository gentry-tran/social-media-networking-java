package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestTimelinePublishing {
	
	@Test
	public void newUserReturnsName() {
		User user = new User("Alice");
		assertEquals("Alice", user.getName());
	}
	
	@Test
	public void timelineReturnsZeroMessages() {
		Timeline timeline = new Timeline();
		assertEquals(0, timeline.getSize());
	}
	
	@Test
	public void oneMessageIsReturnedWhenUserPublishesToTimeline() {
		User user = new User("Alice");
		TimelineManager timelineManager = new TimelineManager();
		Message message = new Message("");
		timelineManager.publish(user, message);
		Timeline timeline = timelineManager.getTimeline(user);
		assertEquals(1, timeline.getSize());
	}
}

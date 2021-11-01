package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestTimelineViewing {
	
	User user;
	User user2;
	User user3;
	TimelineManager timelineManager;
	
	@BeforeEach
	public void before() {
		user = new User("Alice");
		user2 = new User("Bob");
		user3 = new User("Charlie");
		timelineManager = new TimelineManager();
	}
	
	@Test
	public void userCanViewTimelineMessages() {
		publishMessage("I love the weather today.");
		assertEquals("I love the weather today.", timelineManager.getTimeline(user).getMessages().get(0).getMessage());
	}
	
	@Test
	public void userViewsMessagesFromTimelineAsMostRecentlyPosted() {
		publishMessage("First Post - should return second.");
		publishMessage("Second Post - should return first.");
		assertEquals("Second Post - should return first.", timelineManager.getTimeline(user).getMessages().get(0).getMessage());
		assertEquals("First Post - should return second.", timelineManager.getTimeline(user).getMessages().get(1).getMessage());
	}
	
	@Test
	@Disabled
	public void userCanViewAnAggregatedTimelineOfAllFollowees() {
		FollowingService service = new FollowingService();
		service.followUser(user3, user); // Charlie follows Alice
		service.followUser(user3, user2); // Charlie follows Bob
		
		// TODO did not finish...
	}
	
	private void publishMessage(String message) {
		timelineManager.publish(user, new Message(message));
	}
}

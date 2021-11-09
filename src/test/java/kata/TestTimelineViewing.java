package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

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
		publishMessage(user, "I love the weather today.");
		assertEquals("I love the weather today.", timelineManager.getTimeline(user).getMessages().get(0).getMessage());
	}
	
	@Test
	public void userViewsMessagesFromTimelineAsMostRecentlyPosted() {
		publishMessage(user, "First Post - should return second.");
		publishMessage(user, "Second Post - should return first.");
		assertEquals("Second Post - should return first.", timelineManager.getTimeline(user).getMessages().get(0).getMessage());
		assertEquals("First Post - should return second.", timelineManager.getTimeline(user).getMessages().get(1).getMessage());
	}
	
	@Test
	public void userCanViewAnAggregatedTimelineOfAllFollowees() {
		user3.follow(user); // Charlie follows Alice
		user3.follow(user2); // Charlie follows Bob
		ApplicationTime.setApplicationTime(LocalTime.NOON);
		String alicesExpectedPost = "I love the weather today.";
		String bobsFirstPost = "Damn! We lost!";
		String bobsSecondPost = "Good game though.";
		String charliesExpectedPost = "I'm in New York today! Anyone wants to have a coffee?";
		publishMessage(user, alicesExpectedPost);
		ApplicationTime.setApplicationTime(LocalTime.NOON.plusMinutes(2));
		publishMessage(user2, bobsFirstPost);
		ApplicationTime.setApplicationTime(LocalTime.NOON.plusMinutes(5));
		publishMessage(user2, bobsSecondPost);
		ApplicationTime.setApplicationTime(LocalTime.NOON.plusMinutes(5).plusSeconds(15));
		publishMessage(user3, charliesExpectedPost);
		assertTrue(timelineManager.getAggregatedTimeline(user3).contains(charliesExpectedPost));
		assertTrue(timelineManager.getAggregatedTimeline(user3).contains(bobsSecondPost));
		assertTrue(timelineManager.getAggregatedTimeline(user3).contains(bobsFirstPost));
		
		assertEquals(charliesExpectedPost, timelineManager.getAggregatedTimeline(user3).get(0));
		assertEquals(bobsSecondPost, timelineManager.getAggregatedTimeline(user3).get(1));
		assertEquals(bobsFirstPost, timelineManager.getAggregatedTimeline(user3).get(2));
		assertEquals(alicesExpectedPost, timelineManager.getAggregatedTimeline(user3).get(3));
	}
	
	private void publishMessage(User user, String message) {
		timelineManager.publish(user, new Message(message));
	}
}

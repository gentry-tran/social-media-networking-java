package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestFollowing {
	
	@Test
	public void aUserCanFollowOtherUsers() {
		User famousRapper1 = new User("Kanye");
		User famousRapper2 = new User("Jay-Z");
		User goddess = new User("Kim");
		
		// Kanye follows Jay & Kim
		famousRapper1.follow(goddess);
		famousRapper1.follow(famousRapper2);
		List<User> followees = famousRapper1.getFollowees();
		assertEquals("Kim", followees.get(0).getName());
		assertEquals("Jay-Z", followees.get(1).getName());
	}
}

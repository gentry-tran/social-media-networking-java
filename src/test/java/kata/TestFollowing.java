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
		FollowingService service = new FollowingService();

		// Kanye follows Jay & Kim
		service.followUser(famousRapper1, goddess);
		service.followUser(famousRapper1, famousRapper2);
		List<User> followees = service.getFollowees(famousRapper1);
		
		assertEquals("Kim", followees.get(0).getName());
		assertEquals("Jay-Z", followees.get(2).getName());
	}
}

package kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FollowingService {
	
	Map<User, List<User>> mapOfAllFollowersAndFollowees = new HashMap<>();

	public void followUser(User follower, User followee) {
		List<User> followees = getFollowees(follower);
		
		if(followees == null) {
			List<User> peopleTheUserFollows = new ArrayList<User>();
			peopleTheUserFollows.add(followee);
			mapOfAllFollowersAndFollowees.put(follower, peopleTheUserFollows);
		}
	}

	public List<User> getFollowees(User follower) {
		return mapOfAllFollowersAndFollowees.get(follower);
	}
	
}

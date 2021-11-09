package kata;

import java.util.List;

public class User {

	private String name;
	FollowingService service = new FollowingService();
	
	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void follow(User followee) {
		service.followUser(this, followee);
	}

	public List<User> getFollowees() {
		return service.getFollowees(this);
	}
}

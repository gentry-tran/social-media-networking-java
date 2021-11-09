package kata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimelineManager {
	
	Map<User, Timeline> timelines = new HashMap<User, Timeline>();

	public void publish(User user, Message message) {
		Timeline timeline = this.getTimeline(user);
		timeline.add(message);
	}

	public Timeline getTimeline(User user) {
		Timeline timeline = this.timelines.get(user);
		
		if(timeline == null) {
			timeline = new Timeline();
			timelines.put(user, timeline);
		} 
		
		return timeline;
	}

	public List<String> getAggregatedTimeline(User user) {
		List<User> followees = user.getFollowees();
		List<Message> messages = new ArrayList<>(getTimeline(user).getMessages());
		for(User followee: followees) {
			getTimeline(followee).getMessages().stream().forEach(message -> messages.add(message));;
		}
		

		return messages.stream().sorted(new Comparator<Message>() {

			@Override
			public int compare(Message o1, Message o2) {
				return o2.getTimeStamp().compareTo(o1.getTimeStamp());
			}
		})
				.map(message -> message.getMessage()).collect(Collectors.toList());
	}

}

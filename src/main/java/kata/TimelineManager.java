package kata;

import java.util.HashMap;
import java.util.Map;

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

}

package kata;

import java.util.ArrayList;
import java.util.List;

public class Timeline {
	
	List<Message> messages = new ArrayList<>();	

	public Integer getSize() {
		return messages.size();
	}

	public void add(Message message) {
		messages.add(message);
	}

	public List<Message> getMessages() {
		return messages;
	}

}

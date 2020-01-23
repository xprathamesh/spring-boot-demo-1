package io.javabrains.sb.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 
 * Spring looks at service, creates new instance and registers it as one
 */
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}
	
	public void delTopic(String id) {
		
//		for (int i=0; i<topics.size();i++) {
//			Topic t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.remove(i);
//			}
//		}
		
		topicRepository.deleteById(id);
	}
}
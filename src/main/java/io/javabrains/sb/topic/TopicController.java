package io.javabrains.sb.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * creates a new instance
 */
@RestController
public class TopicController {
	
	/*
	 * Something that needs dependency injection
	 * looks at registry and sees instance of TopicService
	 * Takes the instance and injects to variable
	 */
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		/*
		 * @pathvariable maps {id} to id
		 */
		return topicService.getTopic(id);
	}
	
	/*
	 * @Request Body  gets the body in Topic
	 * 
	 * post from postman, header -> content-type application/json
	 * 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void addTopic(@RequestBody Topic topic, @PathVariable String id){
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void addTopic(@PathVariable String id) {
		topicService.delTopic(id);
	}
}

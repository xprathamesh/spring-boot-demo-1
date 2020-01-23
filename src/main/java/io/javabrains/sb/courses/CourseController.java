package io.javabrains.sb.courses;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.sb.topic.Topic;

/*
 * creates a new instance
 */
@RestController
public class CourseController {
	
	/*
	 * Something that needs dependency injection
	 * looks at registry and sees instance of TopicService
	 * Takes the instance and injects to variable
	 */
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		/*
		 * @pathvariable maps {id} to id
		 */
		return courseService.getCourse(id);
	}
	
	/*
	 * @Request Body  gets the body in Topic
	 * 
	 * post from postman, header -> content-type application/json
	 * 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void setCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void delCourse(@PathVariable String id) {
		courseService.delCourse(id);
	}
}

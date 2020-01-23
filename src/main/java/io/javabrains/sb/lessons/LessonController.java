package io.javabrains.sb.lessons;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.sb.courses.Course;
import io.javabrains.sb.topic.Topic;

/*
 * creates a new instance
 */
@RestController
public class LessonController {
	
	/*
	 * Something that needs dependency injection
	 * looks at registry and sees instance of TopicService
	 * Takes the instance and injects to variable
	 */
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/topics/{topicid}/courses/{id}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String id) {
		return lessonService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable String id) {
		/*
		 * @pathvariable maps {id} to id
		 */
		return lessonService.getLesson(id);
	}
	
	/*
	 * @Request Body  gets the body in Topic
	 * 
	 * post from postman, header -> content-type application/json
	 * 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId,"","",""));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void setLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id){
		lesson.setCourse(new Course(courseId,"","",""));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void delLesson(@PathVariable String id) {
		lessonService.delLesson(id);
	}
}

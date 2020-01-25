package io.javabrains.sb.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 
 * Spring looks at service, creates new instance and registers it as one
 */

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findById(id).orElse(null);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void delCourse(String id) {
		
//		for (int i=0; i<topics.size();i++) {
//			Topic t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.remove(i);
//			}
//		}
		courseRepository.deleteById(id);
	}
}
package io.javabrains.sb.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 
 * Spring looks at service, creates new instance and registers it as one
 */
@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllCourses(String courseId){
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(lessons::add);
		return lessons;
	}
	
	public Lesson getLesson(String id) {
		return lessonRepository.findById(id).orElse(null);
	}
	
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public void delLesson(String id) {
		lessonRepository.deleteById(id);
	}
}
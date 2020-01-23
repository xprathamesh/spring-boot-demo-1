package io.javabrains.sb.lessons;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
/*
 * extend the Crud Interface and all Crud Methods Automatically are available
 */
public interface LessonRepository extends CrudRepository<Lesson, String>{
	
	 /*
	  * custom abstract methods when written in correct format auto-translate into queries and implementations
	  * findBy"Property"(DataType property)
	  */
	
	public List<Lesson> findByCourseId(String courseId);
}

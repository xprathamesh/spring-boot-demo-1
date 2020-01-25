package io.javabrains.sb.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
/*
 * extend the Crud Interface and all Crud Methods Automatically are available
 */
public interface CourseRepository extends CrudRepository<Course, String>{
	
	 /*
	  * custom abstract methods when written in correct format auto-translate into queries and implementations
	  * findBy"Property"(DataType property)
	  */
	
//// examples
//	public List<Course> findByName(String name);
//	public List<Course> findByDescription(String desc);
//	When String to refer a field of an object, use findByObjectField
	public List<Course> findByTopicId(String topicId);
}

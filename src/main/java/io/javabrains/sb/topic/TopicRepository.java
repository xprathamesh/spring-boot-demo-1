package io.javabrains.sb.topic;

import org.springframework.data.repository.CrudRepository;
/*
 * extend the Crud Interface and all Crud Methods Automatically are available
 */
public interface TopicRepository extends CrudRepository<Topic, String>{
	
	 
	
}

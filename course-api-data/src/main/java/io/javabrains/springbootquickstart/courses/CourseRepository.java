package io.javabrains.springbootquickstart.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CourseRepository extends CrudRepository<Course,String>{
	//get all topics
	//get topic given an id
	//update topic(Topic t)
	// delete topic(String id)
	
	public List<Course> findByTopicId(String topicId);
	
}

package io.javabrains.springbootquickstart.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,String>{
	//get all topics
	//get topic given an id
	//update topic(Topic t)
	// delete topic(String id)
	
}

package io.javabrains.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	//Creates an arrayList of topics
	private List<Topic> topics = new ArrayList(Arrays.asList(
			
			new Topic("Spring","Spring boot framework","Spring boot framework description"),
			new Topic("Python","Django framework","Python django framework description"),
			new Topic ("Javascript", "Javascript nodeJs framework","Node js framework description"),
			new Topic("Php", "Laravel Framework","Laravel framework description")
			));
	
	//create a service method
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
	}
	
	//add an entity of topic
	public Topic addTopic(Topic topic) {
		topicRepository.save(topic);
		return topic;
		
	}
	
	//update a topic
	public Topic updateTopic(String id,Topic topic) {
		topicRepository.save(topic);
		return topic;
	}
	
	//Delete a topic
	public void deletTopic(String id) {
		topicRepository.deleteById(id);
		
	}
}

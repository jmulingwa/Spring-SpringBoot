package io.javabrains.springbootquickstart.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return  topicService.getAllTopics();
	}
	
	//get a single topic
	@RequestMapping("topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//add topic
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	///Update or PUT something in topics 
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id){
		return topicService.updateTopic(id,topic);
		
	}
	
	//Delete
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public String deleteTopic(@PathVariable String id) {
		topicService.deletTopic(id); 
		return "Record was removed successfully";
		
	}

}

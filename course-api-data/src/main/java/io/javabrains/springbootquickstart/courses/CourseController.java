package io.javabrains.springbootquickstart.courses;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootquickstart.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	//getting all the courses that belong to a particular topic
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return  courseService.getAllCourses(topicId);
	}
	
	//get a single course from a particular topic
	@RequestMapping("topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	//add topic
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public Course addCourse(@RequestBody Course course, @PathVariable String topicId ){
		course.setTopic(new Topic(topicId,"",""));
		return courseService.addCourse(course);
	}
	
	///Update or PUT something in topics 
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public Course updateCourse(@RequestBody Course course, @PathVariable String topicId, String id){
		course.setTopic(new Topic(topicId,"",""));
		return courseService.updateCourse(course);
		
	}
	
	//Delete
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public String deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id); 
		return "Record was removed successfully";
		
	}

}

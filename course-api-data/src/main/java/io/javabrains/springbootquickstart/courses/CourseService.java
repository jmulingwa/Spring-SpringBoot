package io.javabrains.springbootquickstart.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	//Creates an arrayList of topics
//	private List<Course> topics = new ArrayList(Arrays.asList(
//			
//			new Course("Spring","Spring boot framework","Spring boot framework description"),
//			new Course("Python","Django framework","Python django framework description"),
//			new Course ("Javascript", "Javascript nodeJs framework","Node js framework description"),
//			new Course("Php", "Laravel Framework","Laravel framework description")
//			));
	
	//create a service method
	public List<Course> getAllCourses(String topicId){
		List<Course> course = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(course::add);
		return course;
	}
	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);
	}
	
	//add an entity of topic
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
		
	}
	
	//update a topic
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
	}
	
	//Delete a topic
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
		
	}
}

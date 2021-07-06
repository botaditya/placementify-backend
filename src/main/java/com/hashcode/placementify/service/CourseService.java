package com.hashcode.placementify.service;

import com.hashcode.placementify.exception.CourseNotFoundException;
import com.hashcode.placementify.model.Course;
import com.hashcode.placementify.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Map<String, String>> getCoursesNameList(){
        final List<Map<String, String>> coursesList = new ArrayList<>();
        List<Course> courses = getAllCourses();
        for ( Course course: courses ){
            Map<String, String> courseProperties = new HashMap<String, String>(){{
                put("cuid", String.valueOf(course.getCuid()));
                put("courseName",course.getCourseName().toString());
                put("coursePattern",course.getCoursePattern().toString());
            }};
            coursesList.add(courseProperties);
        }
        return coursesList;
    }

    public Course findCourseByCuid(Long cuid){
        return courseRepository.findCourseByCuid(cuid).orElseThrow(() -> new CourseNotFoundException("Course by id "+ cuid +" was not found"));
    }

    public void deleteCourse(Long cuid) {
        courseRepository.deleteCourseByCuid(cuid);
    }

}

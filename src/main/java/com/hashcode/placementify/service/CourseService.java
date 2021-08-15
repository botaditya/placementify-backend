package com.hashcode.placementify.service;

import com.hashcode.placementify.dto.AddCourseDTO;
import com.hashcode.placementify.dto.CourseView;
import com.hashcode.placementify.exception.BatchNotFoundException;
import com.hashcode.placementify.exception.CourseNotFoundException;
import com.hashcode.placementify.model.Batch;
import com.hashcode.placementify.model.Course;
import com.hashcode.placementify.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        Course courseObject = courseRepository.findCourseByCuid(course.getCuid()).orElseThrow(() -> new CourseNotFoundException("Course by id "+ course.getCuid() +" was not found"));
        Course updatedCourseObject = new Course();
        updatedCourseObject.setCuid(courseObject.getCuid());
        updatedCourseObject.setCourseName(courseObject.getCourseName());
        updatedCourseObject.setCoursePattern(courseObject.getCoursePattern());
        updatedCourseObject.setCourseDuration(courseObject.getCourseDuration());
        updatedCourseObject.setCourseUniversity(courseObject.getCourseUniversity());
        return courseRepository.save(updatedCourseObject);
    }

    public Course findCourseById(@PathVariable Long cuid){
        return courseRepository.findCourseByCuid(cuid).orElseThrow(() -> new CourseNotFoundException("Course by id "+ cuid +" was not found"));
    }

    public List<CourseView> getCoursesNameList(){
        final List<CourseView> coursesList = new ArrayList<>();
        List<Course> courses = getAllCourses();
        for ( Course course: courses ){
            CourseView courseProperties = new CourseView();
            courseProperties.setCuid(course.getCuid());
            courseProperties.setCourseName(course.getCourseName());
            courseProperties.setCoursePattern(course.getCoursePattern());
            coursesList.add(courseProperties);
        }
        return coursesList;
    }

    public Course findCourseByCuid(Long cuid){
        return courseRepository.findCourseByCuid(cuid).orElseThrow(() -> new CourseNotFoundException("Course by id "+ cuid +" was not found"));
    }

    public void deleteCourse(Long cuid) {
        Course courseObject = courseRepository.findCourseByCuid(cuid).orElseThrow(() -> new CourseNotFoundException("Course by id "+ cuid +" was not found"));;
        courseRepository.delete(courseObject);
    }

}

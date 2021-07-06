package com.hashcode.placementify.service;

import com.hashcode.placementify.dto.CourseView;
import com.hashcode.placementify.model.Course;
import com.hashcode.placementify.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseDetailsService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final CourseService courseService;

    public CourseDetailsService(CourseRepository courseRepository, CourseService courseService) {
        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

    public List<CourseView> getAllCourseNames() {
        List<CourseView> courseList = new ArrayList<>();
        List<Course> courses = courseService.getAllCourses();

        for (Course course : courses) {
            CourseView courseView = new CourseView();
            courseView.setCuid(course.getCuid());
            courseView.setCourseName(course.getCourseName());
            courseList.add(courseView);
        }
        return courseList;
    }
}

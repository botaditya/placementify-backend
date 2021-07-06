package com.hashcode.placementify.controller;

import com.hashcode.placementify.dto.CourseView;
import com.hashcode.placementify.model.Course;
import com.hashcode.placementify.service.CourseDetailsService;
import com.hashcode.placementify.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;
    private final CourseDetailsService courseDetailsService;

    public CourseController(CourseService courseService, CourseDetailsService courseDetailsService) {
        this.courseService = courseService;
        this.courseDetailsService = courseDetailsService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ORGANISATION') or hasRole('ADMIN')")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/courseNames")
    @PreAuthorize("hasRole('ORGANISATION') or hasRole('ADMIN')")
    public ResponseEntity<List<CourseView>> getAllArticles() {
        return new ResponseEntity<>(courseDetailsService.getAllCourseNames(), HttpStatus.OK);
    }

    @GetMapping("/find/{cuid}")
    @PreAuthorize("hasRole('ORGANISATION') or hasRole('ADMIN')")
    public ResponseEntity<Course> getCoursesByCuid(@PathVariable("cuid") Long cuid){
        Course course = courseService.findCourseByCuid(cuid);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course newCourse = courseService.addCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        Course updateCourse = courseService.updateCourse(course);
        return new ResponseEntity<>(updateCourse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cuid}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCourse(@PathVariable("cuid") Long cuid){
        courseService.deleteCourse(cuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

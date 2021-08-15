package com.hashcode.placementify.controller;

import com.hashcode.placementify.dto.CourseView;
import com.hashcode.placementify.model.Course;
import com.hashcode.placementify.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/app/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/courseNames")
    public ResponseEntity<List<CourseView>> getCoursesNames() {
        List<CourseView> courseNames = courseService.getCoursesNameList();
        return new ResponseEntity<>(courseNames, HttpStatus.OK);
    }

    @GetMapping("/find/{cuid}")
    public ResponseEntity<Course> getCoursesByCuid(@PathVariable("cuid") Long cuid){
        Course course = courseService.findCourseByCuid(cuid);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping( path = "/add",method = RequestMethod.POST)
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course newCourse = courseService.addCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        Course updateCourse = courseService.updateCourse(course);
        return new ResponseEntity<>(updateCourse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cuid}")
    public ResponseEntity<?> deleteCourse(@PathVariable("cuid") Long cuid){
        courseService.deleteCourse(cuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

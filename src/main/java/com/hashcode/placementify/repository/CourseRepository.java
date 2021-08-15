package com.hashcode.placementify.repository;

import com.hashcode.placementify.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {

    Optional<Course> findCourseByCuid(Long cuid);
}

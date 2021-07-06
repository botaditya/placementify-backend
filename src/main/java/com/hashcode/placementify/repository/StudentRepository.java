package com.hashcode.placementify.repository;

import com.hashcode.placementify.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    void deleteStudentBySuid(Long suid);

    Optional<Student> findStudentBySuid(Long suid);
}


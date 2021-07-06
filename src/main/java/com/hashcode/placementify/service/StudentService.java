package com.hashcode.placementify.service;

import com.hashcode.placementify.exception.StudentNotFoundException;
import com.hashcode.placementify.model.Student;
import com.hashcode.placementify.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        student.setFormId(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudentBySuid(Long suid){
        return studentRepository.findStudentBySuid(suid).orElseThrow(() -> new StudentNotFoundException("Student by id "+ suid +" was not found"));
    }

    public void deleteStudent(Long suid) {
        studentRepository.deleteStudentBySuid(suid);
    }
}

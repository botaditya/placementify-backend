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

    private final EmailService emailService;

    public StudentService(StudentRepository studentRepository, EmailService emailService) {
        this.studentRepository = studentRepository;
        this.emailService = emailService;
    }

    public Student addStudent(Student student) {
        student.setApplicationId(UUID.randomUUID().toString());
        emailService.sendSuccessfulRegistrationEmail(student);
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

    public Student findStudentByApplicationId(String applicationId, String emailId){
        return studentRepository.findStudentByApplicationIdAndEmailId(applicationId, emailId).orElseThrow(() -> new StudentNotFoundException("Student application with id "+ applicationId + " and email address "+emailId+" was not found"));
    }

    public void deleteStudent(Long suid) {
        studentRepository.deleteStudentBySuid(suid);
    }
}

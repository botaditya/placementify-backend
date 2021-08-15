package com.hashcode.placementify.service;

import com.hashcode.placementify.dto.FilterStudentDTO;
import com.hashcode.placementify.exception.StudentNotFoundException;
import com.hashcode.placementify.model.MarkingScheme;
import com.hashcode.placementify.model.Student;
import com.hashcode.placementify.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        student.setApplicationId(UUID.randomUUID().toString());
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

    public List<Student> filterStudents(FilterStudentDTO filterStudentDTO) {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream()
                .filter((student) ->
                        filterStudentDTO.getSscMarkScheme().equals(MarkingScheme.CGPA) ?
                                student.getSscCGPA() <= filterStudentDTO.getSscMarks() :
                                student.getSscPercent() <= filterStudentDTO.getSscMarks() && filterStudentDTO.getHscMarkScheme().equals(MarkingScheme.CGPA) ?
                                        student.getHscCGPA() <= filterStudentDTO.getHscMarks() :
                                        student.getGradPercent() <= filterStudentDTO.getHscMarks() && filterStudentDTO.getGradMarkScheme().equals(MarkingScheme.CGPA) ?
                                                student.getGradCGPA() <= filterStudentDTO.getGradMarks() :
                                                student.getGradPercent() <= filterStudentDTO.getGradMarks() && filterStudentDTO.getCurrentMarkScheme().equals(MarkingScheme.CGPA) ? student.getCurrentCourseCGPA() <= filterStudentDTO.getCurrentMarks() :
                                                        student.getCurrentCoursePercent() <= filterStudentDTO.getCurrentMarks()
                        ).collect(Collectors.toList());
    }

    public void deleteStudent(Long suid) {
        studentRepository.deleteStudentBySuid(suid);
    }
}

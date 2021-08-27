package com.hashcode.placementify.controller;

import com.hashcode.placementify.dto.FilterStudentDTO;
import com.hashcode.placementify.model.Student;
import com.hashcode.placementify.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/app/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/find/{suid}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Student> getStudentsBySuid(@PathVariable("suid") Long suid){
        Student student = studentService.findStudentBySuid(suid);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updateStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{suid}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteStudent(@PathVariable("suid") Long suid){
        studentService.deleteStudent(suid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

/*    @PostMapping("/filterStudents")
    public ResponseEntity<List<Student>> filterStudents(@RequestBody FilterStudentDTO filterStudentDTO) {
        List<Student> filteredStudents = studentService.filterStudents(filterStudentDTO);
        return new ResponseEntity<>(filteredStudents,HttpStatus.OK);
    }*/
}

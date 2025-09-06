package com.springboot.restapis.learningRestAPIS.controller;

import com.springboot.restapis.learningRestAPIS.dto.AddNewStudent;
import com.springboot.restapis.learningRestAPIS.dto.StudentDto;
import com.springboot.restapis.learningRestAPIS.entities.Student;
import com.springboot.restapis.learningRestAPIS.respository.StudentRespository;
import com.springboot.restapis.learningRestAPIS.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {


//    private final StudentRespository studentRespository;
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List <StudentDto> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddNewStudent addNewStudent){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addNewStudent));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<StudentDto> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody @Valid AddNewStudent addNewStudent)
    {
        return ResponseEntity.ok(studentService.updateStudent(id,addNewStudent));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody @Valid Map<String,Object> updates)
    {
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }
}

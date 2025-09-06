package com.springboot.restapis.learningRestAPIS.service;

import com.springboot.restapis.learningRestAPIS.dto.AddNewStudent;
import com.springboot.restapis.learningRestAPIS.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public List<StudentDto> getAllStudents();
    public StudentDto getStudentById(Long id);
    public StudentDto createNewStudent(AddNewStudent addNewStudent);

    public void deleteStudentById(Long id);

   public StudentDto updateStudent(Long id, AddNewStudent addNewStudent);

    public StudentDto updatePartialStudent(Long id, Map<String,Object> updates);
}

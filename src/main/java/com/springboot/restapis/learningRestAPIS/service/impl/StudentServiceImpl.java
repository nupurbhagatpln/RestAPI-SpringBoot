package com.springboot.restapis.learningRestAPIS.service.impl;

import com.springboot.restapis.learningRestAPIS.dto.AddNewStudent;
import com.springboot.restapis.learningRestAPIS.dto.StudentDto;
import com.springboot.restapis.learningRestAPIS.entities.Student;
import com.springboot.restapis.learningRestAPIS.respository.StudentRespository;
import com.springboot.restapis.learningRestAPIS.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRespository studentRespository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students= studentRespository.findAll();
        return (List<StudentDto>) students.stream().map(
                student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
    }

    public StudentDto getStudentById(Long id){
//       List<StudentDto> allStudent=getAllStudents();
        Student student= studentRespository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student can not be found"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddNewStudent addNewStudent) {
        Student newStudent = modelMapper.map(addNewStudent,Student.class);
        Student student= studentRespository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updateStudent(Long id, AddNewStudent addNewStudent) {
        Student newStudent= studentRespository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student can not be found"));
        modelMapper.map(addNewStudent,newStudent);
        Student student=studentRespository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRespository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exit "+ id);
        }
        studentRespository.deleteById(id);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String,Object> updates) {
        Student newStudent= studentRespository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student can not be found"));

        updates.forEach((field, value)->{
            switch (field){
                case "name":
                    newStudent.setName((String) value);
                    break;
                case "email":
                    newStudent.setEmail((String) value);
                    break;

                default: throw new IllegalArgumentException("Field does not exist");

            }
        });
        Student student= studentRespository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }
}

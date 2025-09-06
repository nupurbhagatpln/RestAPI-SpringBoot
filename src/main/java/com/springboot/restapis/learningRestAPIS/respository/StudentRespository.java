package com.springboot.restapis.learningRestAPIS.respository;

import com.springboot.restapis.learningRestAPIS.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {

}

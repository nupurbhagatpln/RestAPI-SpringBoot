package com.springboot.restapis.learningRestAPIS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;

   
    private String name;
    private String email;
// @data - helps me to create all the constructor getter, setter, hashcode for this class -by lombok
}

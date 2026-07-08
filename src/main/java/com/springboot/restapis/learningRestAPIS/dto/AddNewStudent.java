package com.springboot.restapis.learningRestAPIS.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddNewStudent {

    @NotBlank(message = "Please enter Name")
    @Size(min = 3, max=32, message = "Name should be between 3 to 32 characters")
    private String name;
    
    @Email
    @NotBlank(message = "Please enter Email")
    private String email;
}

package com.springboot.restapis.learningRestAPIS.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModalConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}

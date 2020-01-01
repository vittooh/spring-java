package com.example.learning.api.producer;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperProducer {

    @Bean
    public ModelMapper produce(){
        return new ModelMapper();
    }
}

package com.edts.concerts.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

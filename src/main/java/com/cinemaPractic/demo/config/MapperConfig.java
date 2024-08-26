package com.cinemaPractic.demo.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    private ModelMapper mapper;

    public MapperConfig(){
        mapper = new ModelMapper();
    }

    @Bean
    public ModelMapper modelMapper(){
        return mapper;
    }

}

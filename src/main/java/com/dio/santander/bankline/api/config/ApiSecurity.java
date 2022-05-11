package com.dio.santander.bankline.api.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ApiSecurity extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //TODO Aplicar uma política de cors e remover a permissão genérica
        registry.addMapping("/**");
    }
}

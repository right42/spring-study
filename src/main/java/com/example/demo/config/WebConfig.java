package com.example.demo.config;

import com.example.demo.databinder.AbstractEntityConverterFactory;
import com.example.demo.databinder.StringToModesConverter;
import com.example.demo.mvc.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToModesConverter());
        registry.addConverterFactory(new AbstractEntityConverterFactory());
    }
}

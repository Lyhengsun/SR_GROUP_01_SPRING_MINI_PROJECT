//package com.example.gamified_habit_tracker.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Configuration
//public class FileConfig implements WebMvcConfigurer {
//
//    @Value("${spring.upload-file-path}")
//    private String filePath;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        Path rootPath = Paths.get(filePath);
//        registry.addResourceHandler("/files/**").addResourceLocations("file:" + rootPath + "/");
//    }
//}

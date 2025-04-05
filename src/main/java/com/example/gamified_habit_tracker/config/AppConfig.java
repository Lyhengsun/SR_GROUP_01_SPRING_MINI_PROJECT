package com.example.gamified_habit_tracker.config;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
    @BeanProperty
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

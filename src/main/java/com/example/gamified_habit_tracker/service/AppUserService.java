package com.example.gamified_habit_tracker.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.gamified_habit_tracker.model.dto.request.AppUserRequest;
import com.example.gamified_habit_tracker.model.dto.response.AppUserResponse;

public interface AppUserService extends UserDetailsService {
    public AppUserResponse registerUser(AppUserRequest request);
}

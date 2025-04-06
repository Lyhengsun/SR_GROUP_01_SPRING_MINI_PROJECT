package com.example.gamified_habit_tracker.service.impl;

import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gamified_habit_tracker.exception.NotFoundException;
import com.example.gamified_habit_tracker.mapper.AppUserMapper;
import com.example.gamified_habit_tracker.model.dto.request.AppUserRequest;
import com.example.gamified_habit_tracker.model.dto.request.ProfileRequest;
import com.example.gamified_habit_tracker.model.dto.response.AppUserResponse;
import com.example.gamified_habit_tracker.model.entity.AppUser;
import com.example.gamified_habit_tracker.repository.AppUserRepository;
import com.example.gamified_habit_tracker.service.AppUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppUserMapper appUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = appUserRepository.getUserByEmail(username);
        if (userDetails == null) {
            userDetails = appUserRepository.getUserByUsername(username);
        }
        if (userDetails == null) {
            throw new NotFoundException("User does not exist");
        }
        return userDetails;
    }

    @Override
    public AppUserResponse registerUser(AppUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        AppUser appUser = appUserRepository.registerUser(request);
        return appUserMapper.toAppUserResponse(appUser);
    }

    @Override
    public AppUserResponse getCurrentUser() {
        AppUser currentAppUser = (AppUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new IllegalStateException("User is not authenticated");
        }
        return getUserById(currentAppUser.getAppUserId());
    }

    @Override
    public AppUserResponse getUserById(UUID userId) {
        AppUser appUser = appUserRepository.getUserByUserId(userId);
        return appUserMapper.toAppUserResponse(appUser);
    }

    @Override
    public AppUserResponse updateUserProfile(ProfileRequest request) {
        AppUser appUser = appUserRepository.updateUserProfile(getCurrentUser().getAppUserId(), request);
        if (appUser == null) {
            throw new NotFoundException("User does not exist");
        }
        return appUserMapper.toAppUserResponse(appUser);
    }

    @Override
    public AppUserResponse deleteUserProfile() {
        AppUser appUser = appUserRepository.deleteUserProfileById(getCurrentUser().getAppUserId());
        if (appUser == null) {
            throw new NotFoundException("User does not exist");
        }
        return appUserMapper.toAppUserResponse(appUser);
    }

}

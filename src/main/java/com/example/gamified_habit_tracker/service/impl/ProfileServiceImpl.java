package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.model.entity.Profile;
import com.example.gamified_habit_tracker.repository.ProfileRepository;
import com.example.gamified_habit_tracker.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;


    @Override
    public Profile getUserProfile() {
        return profileRepository.getUserProfile();
    }
}

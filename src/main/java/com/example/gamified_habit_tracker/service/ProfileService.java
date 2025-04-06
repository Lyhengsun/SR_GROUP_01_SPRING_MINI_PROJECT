package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.dto.request.ProfileRequest;
import com.example.gamified_habit_tracker.model.entity.Profile;

public interface ProfileService {
    Profile getUserProfile();

    Profile updateUserProfile(ProfileRequest request);

    void deleteUserProfile();
}

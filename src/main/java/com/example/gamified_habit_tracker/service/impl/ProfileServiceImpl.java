package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.model.dto.request.ProfileRequest;
import com.example.gamified_habit_tracker.model.entity.Profile;
import com.example.gamified_habit_tracker.repository.ProfileRepository;
import com.example.gamified_habit_tracker.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public Profile getUserProfile() {
        return profileRepository.getUserProfile();
    }


    @Override
    public Profile updateUserProfile(ProfileRequest profileRequest) {
        long id = 1;
        return profileRepository.updateUserProfile(id, profileRequest.getUserName(), profileRequest.getProfileImage());
    }

    @Override
    public void deleteUserProfile() {
        profileRepository.deleteUserProfile();

    }

}

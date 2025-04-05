package com.example.gamified_habit_tracker.Service.Impl;

import com.example.gamified_habit_tracker.Repository.ProfileRepository;
import com.example.gamified_habit_tracker.Service.ProfileService;
import com.example.gamified_habit_tracker.model.entity.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class profileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public profileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile updateProfile(String userName, String profileImage) {
        Long id=25L;
        return profileRepository.updateProfile(id,userName,profileImage);
    }

    @Override
    public Profile getOnlyUserProfile() {
        return profileRepository.getAllUserProfile();
    }

    @Override
    public void deleteUserProfile() {
        profileRepository.deleteUserProfile();

    }


//    @Override
//    public void deleteUserProfile() {
//        // Delete the only existing user
//        profileRepository.deleteUserProfile();
//    }


}

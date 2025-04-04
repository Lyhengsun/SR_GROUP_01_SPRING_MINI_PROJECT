package com.example.gamified_habit_tracker.Service.Impl;
import com.example.gamified_habit_tracker.Repository.ProfileRepository;
import com.example.gamified_habit_tracker.Service.ProfileService;
import com.example.gamified_habit_tracker.model.entity.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class profileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public profileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public List<Profile> getAllUserProfile() {
        return profileRepository.getAllUserProfile() ;
    }
}

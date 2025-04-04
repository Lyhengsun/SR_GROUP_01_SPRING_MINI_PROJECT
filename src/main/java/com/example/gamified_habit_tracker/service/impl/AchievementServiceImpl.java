package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.model.entity.Achievement;
import com.example.gamified_habit_tracker.repository.AchievementRepository;
import com.example.gamified_habit_tracker.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository achievementRepository;

    @Override
    public List<Achievement> getAllAchievements(Integer page, Integer size) {
        return achievementRepository.getAllAchievements(page, size);
    }

    @Override
    public Achievement getAchievementByAppUsersId(Long appUsersId) {
        return achievementRepository.getAchievementByAppUsersId(appUsersId);
    }
}

package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.exception.NotFoundException;
import com.example.gamified_habit_tracker.model.entity.Achievement;
import com.example.gamified_habit_tracker.repository.AchievementRepository;
import com.example.gamified_habit_tracker.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository achievementRepository;

    @Override
    public List<Achievement> getAllAchievements(Integer page, Integer size) {
        List<Achievement> achievements = achievementRepository.getAllAchievements(page, size);
        if (achievements == null || achievements.isEmpty()) {
            throw new NotFoundException("No Achievement found");
        }
        return achievements;
    }

    @Override
    public Achievement getAchievementByAppUsersId(UUID appUserId) {
        if (appUserId == null) {
            throw new IllegalArgumentException("App User ID cannot be null");
        }
        Achievement achievement = achievementRepository.getAchievementsByAppUserId(appUserId);
        if (achievement == null) {
            throw new NotFoundException("Achievement with ID " + appUserId + " not found");
        }
        return achievement;
    }

}

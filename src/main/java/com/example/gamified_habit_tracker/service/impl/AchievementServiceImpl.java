package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.exception.NotFoundException;
import com.example.gamified_habit_tracker.model.entity.Achievement;
import com.example.gamified_habit_tracker.model.entity.AppUser;
import com.example.gamified_habit_tracker.repository.AchievementRepository;
import com.example.gamified_habit_tracker.repository.AppUserRepository;
import com.example.gamified_habit_tracker.service.AchievementService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository achievementRepository;
    private final AppUserRepository appUserRepository;

    @Override
    public List<Achievement> getAllAchievements(Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        List<Achievement> achievements = achievementRepository.getAllAchievements(offset, size);
        if (achievements == null || achievements.isEmpty()) {
            throw new NotFoundException("No Achievement found");
        }
        return achievements;
    }

    @Override
    public List<Achievement> getAchievementByAppUsersId(Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        AppUser currentAppUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new IllegalArgumentException("User is not authenticated");
        }
        AppUser appUser = appUserRepository.getUserByUserId(currentAppUser.getAppUserId());
        List<Achievement> collectedAchievements = achievementRepository.getAchievementUnderXpRequired(appUser.getXp());
        if (collectedAchievements.size() > 0) {
            collectedAchievements.forEach(achievement -> achievementRepository
                    .insertUserAchievement(appUser.getAppUserId(), achievement.getAchievementId()));
        }
        List<Achievement> achievements = achievementRepository.getAchievementsByAppUserId(appUser.getAppUserId(),
                offset, size);
        return achievements;
    }
}

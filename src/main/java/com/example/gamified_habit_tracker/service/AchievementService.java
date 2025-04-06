package com.example.gamified_habit_tracker.service;


import com.example.gamified_habit_tracker.model.entity.Achievement;

import java.util.List;
import java.util.UUID;

public interface AchievementService {
    List<Achievement> getAllAchievements(Integer page, Integer size);

    Achievement getAchievementByAppUsersId(UUID appUserID);
}

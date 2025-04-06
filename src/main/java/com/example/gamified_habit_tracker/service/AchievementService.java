package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.entity.Achievement;

import java.util.List;

public interface AchievementService {
    List<Achievement> getAllAchievements(Integer page, Integer size);

    List<Achievement> getAchievementByAppUsersId(Integer page, Integer size);
}

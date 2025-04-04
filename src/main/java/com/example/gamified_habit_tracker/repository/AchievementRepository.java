package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.model.entity.Achievement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AchievementRepository {
    List<Achievement> getAllAchievements(Integer page, Integer size);

    Achievement getAchievementByAppUsersId(Long appUsersId);
}

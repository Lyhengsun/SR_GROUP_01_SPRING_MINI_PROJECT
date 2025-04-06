package com.example.gamified_habit_tracker.mapper;

import org.mapstruct.Mapper;

import com.example.gamified_habit_tracker.model.dto.response.HabitResponse;
import com.example.gamified_habit_tracker.model.entity.Habit;

@Mapper(componentModel = "spring")
public interface HabitMapper {
    HabitResponse toHabitResponse(Habit habit);
}

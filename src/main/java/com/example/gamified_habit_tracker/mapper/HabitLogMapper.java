package com.example.gamified_habit_tracker.mapper;

import org.mapstruct.Mapper;

import com.example.gamified_habit_tracker.model.dto.response.HabitLogReponse;
import com.example.gamified_habit_tracker.model.entity.HabitLog;

@Mapper(componentModel = "spring")
public interface HabitLogMapper {
    HabitLogReponse toHabitLogReponse(HabitLog habitLog);
}

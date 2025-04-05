package com.example.gamified_habit_tracker.mapper;

import org.mapstruct.Mapper;

import com.example.gamified_habit_tracker.model.dto.response.AppUserResponse;
import com.example.gamified_habit_tracker.model.entity.AppUser;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUserResponse toAppUserResponse(AppUser appUser);
}

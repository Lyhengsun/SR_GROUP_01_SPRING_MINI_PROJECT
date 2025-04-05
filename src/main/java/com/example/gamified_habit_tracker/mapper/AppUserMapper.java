package com.example.gamified_habit_tracker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.gamified_habit_tracker.model.dto.response.AppUserResponse;
import com.example.gamified_habit_tracker.model.entity.AppUser;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    @Mapping(source = "appUsername", target = "username")
    AppUserResponse toAppUserResponse(AppUser appUser);
}

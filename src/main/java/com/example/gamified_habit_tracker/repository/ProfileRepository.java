package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.model.entity.Profile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProfileRepository {


    @Select("""
    select * from app_users;
    """)
    Profile getUserProfile();
}

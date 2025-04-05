package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.model.entity.Habits;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitRepository {

    @Select("""
        SELECT * FROM achievements
        OFFSET #{offset} LIMIT #{size}
        """)
    @Results(id = "AchievementMapper",value = {
            @Result(property = "habitId",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "habitId",column = "id"),
            @Result(property = "habitId",column = "id"),
    })
    List<Habits> getAllHabit(int offset,int size);

    @Select("""
        
        """)
    Habits getHabitById(UUID uuid);


    @Update("""
        
        """)
    Habits updateHabitById();

    @Select("""
        
        """)
    Habits createHabit();

    @Delete("""
        
        """)
    Habits deleteHabitById(UUID uuid);
}

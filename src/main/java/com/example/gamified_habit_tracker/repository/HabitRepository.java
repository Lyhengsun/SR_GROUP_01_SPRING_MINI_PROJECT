package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.config.UUIDTypeHandler;
import com.example.gamified_habit_tracker.model.dto.request.HabitRequest;
import com.example.gamified_habit_tracker.model.entity.Habit;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitRepository {

    @Results(id = "habitMapper", value = {
            @Result(property = "habitId", column = "habit_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "frequency", column = "frequency"),
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "appUserResponse", column = "app_user_id",
                    one = @One(select = "com.example.gamified_habit_tracker.repository.ProfileRepository.getUserProfile"))
    })
    @Select("SELECT * FROM habits OFFSET #{offset} LIMIT #{limit};")
    List<Habit> getAllHabits(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @ResultMap("habitMapper")
    @Select("SELECT * FROM habits WHERE habit_id = #{habitId};")
    Habit getHabitById(@Param("habitId") UUID habitId);

    @Insert("""
        INSERT INTO habits (title, description, frequency, app_user_id)
        VALUES (#{req.title}, #{req.description}, #{req.frequency}, #{req.appUserId})
        RETURNING *;
    """)
    Habit createHabit(@Param("req") HabitRequest habitRequest);

    @Update("""
        UPDATE habits
        SET title = #{req.title}, description = #{req.description}, frequency = #{req.frequency}
        WHERE habit_id = #{habitId}
        RETURNING *;
    """)
    Habit updateHabit(@Param("habitId") UUID habitId, @Param("req") HabitRequest habitRequest);

    @Delete("""
        DELETE FROM habits
        WHERE habit_id = #{habitId}
        RETURNING *;
    """)
    Habit deleteHabit(@Param("habitId") UUID habitId);
}
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
            @Result(property = "isActive", column = "is_active"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "appUserId", column = "app_user_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class)
    })
    @Select("""
                SELECT * FROM habits
                WHERE app_user_id = #{user_id}
                OFFSET #{offset} LIMIT #{limit};
            """)
    List<Habit> getAllHabitsByUserId(@Param("user_id") UUID userId, @Param("offset") Integer offset,
            @Param("limit") Integer limit);

    @ResultMap("habitMapper")
    @Select("SELECT * FROM habits WHERE habit_id = #{habitId}")
    Habit getHabitById(@Param("habitId") UUID habitId);

    @ResultMap("habitMapper")
    @Select("""
                INSERT INTO habits (title, description, frequency, app_user_id)
                VALUES (#{req.title}, #{req.description}, #{req.frequency}, #{user_id})
                RETURNING *;
            """)
    Habit createHabit(@Param("user_id") UUID userId, @Param("req") HabitRequest habitRequest);

    @ResultMap("habitMapper")
    @Select("""
                UPDATE habits
                SET title = #{req.title}, description = #{req.description}, frequency = #{req.frequency}
                WHERE habit_id = #{habitId}
                RETURNING *;
            """)
    Habit updateHabit(@Param("habitId") UUID habitId, @Param("req") HabitRequest habitRequest);

    @ResultMap("habitMapper")
    @Select("""
                DELETE FROM habits
                WHERE habit_id = #{habitId}
                RETURNING *;
            """)
    Habit deleteHabit(@Param("habitId") UUID habitId);
}
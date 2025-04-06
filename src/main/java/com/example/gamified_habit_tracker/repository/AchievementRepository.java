package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.config.UUIDTypeHandler;
import com.example.gamified_habit_tracker.model.entity.Achievement;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AchievementRepository {

    @Results(id = "achievementMapper", value = {
            @Result(property = "achievementId", column = "achievement_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),
            @Result(property = "frequency", column = "frequency"),
            @Result(property = "xpRequired", column = "xp_required"),
            @Result(property = "profile", column = "app_user_id", one = @One(select = "com.example.gamified_habit_tracker.repository.AppUserRepository.getAppUserById")),
    })
    @Select("SELECT * FROM achievements OFFSET #{offset} LIMIT #{limit};")
    List<Achievement> getAllAchievements(@Param("offset") Integer page, @Param("limit") Integer size);

    @ResultMap("achievementMapper")
    @Select("""
        SELECT a.*
        FROM achievements a
        INNER JOIN app_user_achievements aa ON a.achievement_id = aa.achievement_id
        WHERE aa.app_user_id = #{appUserId};
    """)
    Achievement getAchievementsByAppUserId(@Param("appUserId") UUID appUserId);
}
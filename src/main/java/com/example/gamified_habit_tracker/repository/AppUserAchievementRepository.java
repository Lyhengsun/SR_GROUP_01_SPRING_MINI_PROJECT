package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.model.entity.Profile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppUserAchievementRepository {

//    @Insert("""
//        INSERT INTO app_user_achievements (app_user_id, achievement_id)
//        VALUES (#{appUserId}, #{achievementId});
//    """)
//    void saveAppUserAchievement(@Param("eventId") Long achievementId, @Param("appUserID") Long appUserId);
//
//    @Results({
//            @Result(property = "achievementId", column = "achievement_id"),
//            @Result(property = "appUserId", column = "app_user_id")
//    })
//    @Select("""
//        SELECT  *
//        FROM app_users a
//        INNER JOIN app_user_achievements aa ON a.app_user_id = aa.app_user_id
//        WHERE aa.achievement_id = #{appUserId};
//    """)
//    List<Profile> getAllAppUserAchievements(@Param("attendeeId") Long appUserId);

}

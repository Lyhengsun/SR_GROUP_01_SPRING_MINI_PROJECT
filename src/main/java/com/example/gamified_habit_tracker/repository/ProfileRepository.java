package com.example.gamified_habit_tracker.repository;
import com.example.gamified_habit_tracker.model.entity.Profile;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProfileRepository {

    @Results(
            id = "MapperProfile" , value = {
            @Result (property = "appUserId" , column = "app_user_id"),
            @Result(property = "userName" , column = "username"),
            @Result(property = "profileImage" , column = "profile_image"),
            @Result(property = "isVerified" , column = "is_verified"),
            @Result(property = "createdAt" , column = "created_at")

    }
    )

    @Select("""
        SELECT * FROM app_users limit 1;
""")

    Profile getUserProfile();


    @Select("""
                 UPDATE app_users
                 SET profile_image = #{image}, username= #{name}
                 WHERE app_user_id=#{id}
                 RETURNING *;
""")
    Profile updateUserProfile(long id, String name, String image);


    @Delete("""
                DELETE FROM app_users
                WHERE app_user_id=(SELECT app_user_id FROM app_users Limit 1)
                RETURNING *
            """)


    void deleteUserProfile();
}












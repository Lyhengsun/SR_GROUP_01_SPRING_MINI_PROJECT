package com.example.gamified_habit_tracker.Repository;

import com.example.gamified_habit_tracker.model.entity.Profile;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProfileRepository {

    @Results(id = "profileMapper", value = {
            @Result(property = "appUserId", column = "app_user_id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "profileImage", column = "profile_image"),
            @Result(property = "isVerified", column = "is_verified"),
            @Result(property = "createdAt", column = "created_at"),
    })
    @Select("""
                select * FROM app_users LIMIT 1
              """)
    Profile getAllUserProfile();



    @Select("""
        UPDATE app_users
        SET username = #{userName},
            profile_image = #{profileImage}
        WHERE app_user_id = #{id} RETURNING *
    """)
    @ResultMap("profileMapper")
    Profile updateProfile(Long id,   String userName, String profileImage);

    @Select("SELECT * FROM app_users LIMIT 1")
    Optional<Profile> findFirstUser();



    @Delete("""
    DELETE FROM app_users
    WHERE app_user_id = (SELECT app_user_id FROM app_users LIMIT 1)
    RETURNING *
""")
//    Profile deleteUserProfile();
    void deleteUserProfile();
}

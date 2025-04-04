    package com.example.gamified_habit_tracker.Repository;

    import com.example.gamified_habit_tracker.model.entity.Profile;
    import org.apache.ibatis.annotations.*;

    import java.util.List;
    @Mapper
    public interface ProfileRepository {

        @Select("""
                    select * FROM app_users
                   """)
        List<Profile> getAllUserProfile();


//        @Results(id = "profileMapper", value = {
//                @Result(property = "appUserID", column = "app_user_id"),
//                @Result(property = "userName", column = "username"),
//                @Result(property = "email", column = "email"),
//                @Result(property = "password", column = "password"),
//                @Result(property = "level", column = "level"),
//                @Result(property = "xp", column = "xp"),
//                @Result(property = "profileImage", column = "is_verified"),
//                @Result(property = "isVerified", column = "is_verified"),
//                @Result(property = "createdAt", column = "created_at"),
//        })
//        @Select("""
//                    select * FROM app_users
//                   """)
//
//        List<Profile> getAllUserProfile();
//
//        @Select("""
//                UPDATE app_users
//                SET username = #{profile.userName},
//                    profile_image=#{profile.profileImage}
//                    WHERE app_users_id =#{profile.appUserID}
//                """)
//        Profile updateProfile( @Param("profile")Long id, String name,String img, ProfileRequest request);
    }

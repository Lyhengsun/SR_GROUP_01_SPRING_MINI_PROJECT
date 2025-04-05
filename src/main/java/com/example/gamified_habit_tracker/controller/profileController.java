package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.Service.ProfileService;
import com.example.gamified_habit_tracker.model.Request.ProfileRequest;
import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.entity.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/api/profile")
public class profileController {
    private final ProfileService profileService;

    public profileController(ProfileService profileService) {
        this.profileService = profileService;
    }

//    @GetMapping
//    public Profile getALlUserProfile(){
//        return profileService.getAllUserProfile();
//    }



@GetMapping
public ApiResponse<Profile> getOnlyUserProfile() {
    Profile profile = profileService.getOnlyUserProfile();
    return ApiResponse.<Profile>builder()
            .message("Successfully retrieved the user profile")
            .payload(profile)
            .status(HttpStatus.OK)
            .timestamp(LocalDateTime.now())
            .build();
    }
//    @PutMapping
//    public Profile updateProfile(@RequestBody ProfileRequest request) {
//            Profile profile = profileService.updateProfile(request.getUserName(), request.getProfileImage());
//    //        log.info("sdfghjk : {}",profile);
//        return profile;
//    }
@PutMapping
public ApiResponse<Profile> updateProfile(@RequestBody ProfileRequest request) {
    Profile updatedProfile = profileService.updateProfile(request.getUserName(), request.getProfileImage());

    return ApiResponse.<Profile>builder()
            .message("Successfully updated the user profile")
            .payload(updatedProfile)
            .status(HttpStatus.OK)
            .timestamp(LocalDateTime.now())
            .build();
}

//@DeleteMapping
//    public Profile deleteProfile(@PathVariable ){
//        Profile profile = profileService.deleteProfile()
//}
@DeleteMapping
public ApiResponse<String> deleteUserProfile() {
    profileService.deleteUserProfile();
    return ApiResponse.<String>builder()
            .message("Successfully deleted the user profile")
            .payload(null)
            .status(HttpStatus.OK)
            .timestamp(LocalDateTime.now())
            .build();
}






}






















//    @GetMapping
//    public List<Profile> getALlUserProfile(){
//        return profileService.getAllUserProfile();
//    }

//    @PutMapping
//    public ApiResponse<Profile> updateProfile(@RequestBody ProfileRequest request) {
//        Profile updatedProfile = profileService.updateProfile(request.getUserName(), request.getProfileImage());
//        return ApiResponse.<Profile>builder()
//                .message("Profile updated successfully")
//                .payload(updatedProfile)
//                .status(HttpStatus.OK)
//                .timestamp(LocalDateTime.now())
//                .build();
//    }
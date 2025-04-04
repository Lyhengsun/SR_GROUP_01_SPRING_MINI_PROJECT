package com.example.gamified_habit_tracker.controller;
import com.example.gamified_habit_tracker.Service.ProfileService;
import com.example.gamified_habit_tracker.model.entity.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;
    public ProfileController ( ProfileService profileService){
        this.profileService=profileService;
    }
   @GetMapping
    public List<Profile> getALlUserProfile(){
        return profileService.getAllUserProfile();
   }


}

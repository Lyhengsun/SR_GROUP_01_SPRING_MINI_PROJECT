package com.example.gamified_habit_tracker.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRequest {
    private String appUsername;
    private String email;
    private String password;
    private String profileImageUrl;
}

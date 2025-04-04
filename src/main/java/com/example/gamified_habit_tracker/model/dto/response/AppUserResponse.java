package com.example.gamified_habit_tracker.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponse {
    private Long appUsersId;
    private String username;
    private String email;
    private Long level;
    private Long xp;
    private String profileImageUrl;
    private boolean isVerified;
    private LocalDateTime createdAt;
}

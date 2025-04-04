package com.example.gamified_habit_tracker.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {
    private String userName;
    private String email;
    private String password;
    private Long level;
    private Long xp;
    private String profileImage;
    private boolean isVerified;
    private LocalDateTime createdAt;
}

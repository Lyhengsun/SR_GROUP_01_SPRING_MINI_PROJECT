package com.example.gamified_habit_tracker.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserRequest {
    private String appUserName;
    private String appUserEmail;
    private Long level;
    private String profileImageUrl;
    private Boolean isVerified;
    private LocalDateTime createAt;
}

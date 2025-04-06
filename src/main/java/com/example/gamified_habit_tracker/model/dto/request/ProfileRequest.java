package com.example.gamified_habit_tracker.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "username is required")
    private String profileImageUrl;
}

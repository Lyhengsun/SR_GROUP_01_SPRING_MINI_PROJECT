package com.example.gamified_habit_tracker.model.dto.response;

import java.time.LocalDateTime;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private HttpStatus status;
    private T payload;
    private final LocalDateTime timestamp = LocalDateTime.now();
}

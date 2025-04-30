package com.gdc.review_and_rating.dto.response;

import java.util.UUID;

public class UserAverageRatingResponseDTO {
    private UUID userId;
    private double averageRating;
    private long totalRatings;
    private String message;

    public UserAverageRatingResponseDTO(UUID userId, double averageRating, long totalRatings, String message) {
        this.userId = userId;
        this.averageRating = averageRating;
        this.totalRatings = totalRatings;
        this.message = message;
    }

    public UUID getUserId() {
        return userId;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public long getTotalRatings() {
        return totalRatings;
    }

    public String getMessage() {
        return message;
    }
}

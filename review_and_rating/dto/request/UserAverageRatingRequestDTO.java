package com.gdc.review_and_rating.dto.request;

import java.util.UUID;

public class UserAverageRatingRequestDTO {
    private UUID userId;
    // Getter and Setter
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}

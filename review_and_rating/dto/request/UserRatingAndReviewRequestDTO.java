package com.gdc.review_and_rating.dto.request;
import lombok.Data;

import java.util.UUID;

@Data
public class UserRatingAndReviewRequestDTO {
    private UUID userId;
    private UUID rideId;
    private UUID driverId;
    private String review;
    private int rating;
}

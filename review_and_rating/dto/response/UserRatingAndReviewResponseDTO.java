package com.gdc.review_and_rating.dto.response;
import com.gdc.review_and_rating.Enum.ReviewStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UserRatingAndReviewResponseDTO {
    private UUID id;
    private UUID userId;
    private UUID rideId;
    private UUID driverId;
    private String review;
    private int rating;
    private ReviewStatus reviewStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.gdc.review_and_rating.dto.response;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class DriverAverageRatingResponseDTO {
    private UUID driverId;
    private double averageRating;
    private long totalRatings;
    private String message;
}

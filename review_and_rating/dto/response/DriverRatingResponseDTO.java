package com.gdc.review_and_rating.dto.response;
import lombok.Data;

import java.util.UUID;

@Data
public class DriverRatingResponseDTO {
    private UUID id;
    private UUID userId;
    private UUID driverId;
    private UUID rideId;
    private int rating;
}

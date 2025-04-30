package com.gdc.review_and_rating.dto.request;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateDriverRatingRequestDTO {
    private UUID userId;
    private UUID driverId;
    private UUID rideId;
    private int rating;
}

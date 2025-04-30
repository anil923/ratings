package com.gdc.review_and_rating.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class DriverAverageRatingRequestDTO {
    private UUID driverId;
}

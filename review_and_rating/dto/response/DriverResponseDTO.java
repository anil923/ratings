package com.gdc.review_and_rating.dto.response;

import com.gdc.review_and_rating.Enum.VehicleType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class DriverResponseDTO {
    private UUID driverId;
    private UUID userId;
    private VehicleType vehicleType;
    private String licenseNumber;
    private String vehicleNumber;
    private Double vehicleCapacity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

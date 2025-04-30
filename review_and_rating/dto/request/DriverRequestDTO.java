package com.gdc.review_and_rating.dto.request;

import com.gdc.review_and_rating.Enum.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class DriverRequestDTO {

    @NotNull(message = "User ID is required")
    private UUID userId;

    @NotNull(message = "Vehicle type is required")
    private VehicleType vehicleType;

    @NotBlank(message = "License number cannot be blank")
    @Size(min = 5, max = 20, message = "License number must be between 5 and 20 characters")
    private String licenseNumber;

    @NotBlank(message = "Vehicle number cannot be blank")
    @Size(min = 5, max = 15, message = "Vehicle number must be between 5 and 15 characters")
    private String vehicleNumber;

    @NotNull(message = "Vehicle capacity is required")
    private Double vehicleCapacity;
}

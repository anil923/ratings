package com.gdc.review_and_rating.Service;

import com.gdc.review_and_rating.Repository.DriverRepository;
import com.gdc.review_and_rating.Repository.UserRepository;
import com.gdc.review_and_rating.dto.request.DriverRequestDTO;
import com.gdc.review_and_rating.dto.response.DriverResponseDTO;
import com.gdc.review_and_rating.entity.Driver;
import com.gdc.review_and_rating.entity.User;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final UserRepository userRepository;

    // Create a new driver
    public DriverResponseDTO createDriver(DriverRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "User not found with ID: " + dto.getUserId()));

        Driver driver = Driver.builder()
                .user(user)
                .vehicleType(dto.getVehicleType())
                .licenseNumber(dto.getLicenseNumber())
                .vehicleNumber(dto.getVehicleNumber())
                .vehicleCapacity(dto.getVehicleCapacity())
                .build();

        Driver savedDriver = driverRepository.save(driver);
        return toResponseDTO(savedDriver);
    }

    // Get all drivers
    public List<DriverResponseDTO> getAllDrivers() {
        return driverRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Get driver by ID
    public DriverResponseDTO getDriverById(UUID id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Driver not found with ID: " + id));
        return toResponseDTO(driver);
    }

    // Mapper from Driver entity to DriverResponseDTO
    private DriverResponseDTO toResponseDTO(Driver driver) {
        return DriverResponseDTO.builder()
                .driverId(driver.getId())
                .userId(driver.getUser().getId())
                .vehicleType(driver.getVehicleType())
                .licenseNumber(driver.getLicenseNumber())
                .vehicleNumber(driver.getVehicleNumber())
                .vehicleCapacity(driver.getVehicleCapacity())
                .createdAt(driver.getCreatedAt().toLocalDateTime())
                .updatedAt(driver.getUpdatedAt().toLocalDateTime())
                .build();
    }
}

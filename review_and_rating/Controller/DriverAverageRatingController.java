package com.gdc.review_and_rating.Controller;

import com.gdc.review_and_rating.Service.DriverAverageRatingService;
import com.gdc.review_and_rating.dto.request.DriverAverageRatingRequestDTO;
import com.gdc.review_and_rating.dto.response.DriverAverageRatingResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver-average-rating")
@RequiredArgsConstructor
public class DriverAverageRatingController {

    private final DriverAverageRatingService driverAverageRatingService;

    @PostMapping
    public ResponseEntity<String> calculateDriverAverage(@RequestBody DriverAverageRatingRequestDTO request) {
        DriverAverageRatingResponseDTO response = driverAverageRatingService.calculateAndSaveAverageRating(request.getDriverId());
        return ResponseEntity.ok("Driver ID " + response.getDriverId() + " average rating is " + response.getAverageRating());
    }
}

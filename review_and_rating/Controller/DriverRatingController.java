package com.gdc.review_and_rating.Controller;
import com.gdc.review_and_rating.Service.DriverRatingService;
import com.gdc.review_and_rating.dto.request.CreateDriverRatingRequestDTO;
import com.gdc.review_and_rating.dto.response.DriverRatingResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/driver-ratings")
@RequiredArgsConstructor
public class DriverRatingController {

    private final DriverRatingService driverRatingService;

    @PostMapping
    public ResponseEntity<String> createRating(@RequestBody CreateDriverRatingRequestDTO dto) {
        driverRatingService.createDriverRating(dto);
        return ResponseEntity.ok("Driver rating submitted successfully");
    }


    @GetMapping("/{id}")
    public ResponseEntity<DriverRatingResponseDTO> getRatingById(@PathVariable UUID id) {
        return ResponseEntity.ok(driverRatingService.getDriverRatingById(id));
    }
}

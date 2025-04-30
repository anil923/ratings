package com.gdc.review_and_rating.Controller;

import com.gdc.review_and_rating.dto.request.UserAverageRatingRequestDTO;
import com.gdc.review_and_rating.dto.response.UserAverageRatingResponseDTO;
import com.gdc.review_and_rating.Service.UserAverageRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-average-rating")
@RequiredArgsConstructor
public class UserAverageRatingController {

    private final UserAverageRatingService userAverageRatingService;

    @PostMapping
    public ResponseEntity<UserAverageRatingResponseDTO> calculateAverage(@RequestBody UserAverageRatingRequestDTO requestDTO) {
        return ResponseEntity.ok(userAverageRatingService.calculateUserAverageRating(requestDTO));
    }
}

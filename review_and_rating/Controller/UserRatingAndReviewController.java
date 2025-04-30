package com.gdc.review_and_rating.Controller;

import com.gdc.review_and_rating.Service.UserRatingAndReviewService;
import com.gdc.review_and_rating.dto.request.UserRatingAndReviewRequestDTO;
import com.gdc.review_and_rating.dto.response.UserRatingAndReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user-reviews")
@RequiredArgsConstructor
public class UserRatingAndReviewController {

    private final UserRatingAndReviewService reviewService;

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody UserRatingAndReviewRequestDTO dto) {
        String result = reviewService.createReview(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRatingAndReviewResponseDTO> getReviewById(@PathVariable UUID id) {
        UserRatingAndReviewResponseDTO response = reviewService.getReviewById(id);
        return ResponseEntity.ok(response);
    }
}
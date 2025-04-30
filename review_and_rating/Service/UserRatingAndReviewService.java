package com.gdc.review_and_rating.Service;

import com.gdc.review_and_rating.dto.request.UserRatingAndReviewRequestDTO;
import com.gdc.review_and_rating.dto.response.UserRatingAndReviewResponseDTO;

import com.gdc.review_and_rating.entity.*;
import com.gdc.review_and_rating.Enum.ReviewStatus;
import com.gdc.review_and_rating.Repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRatingAndReviewService {

    private final UserRepository userRepository;
    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;
    private final UserRatingAndReviewRepository reviewRepository;

    public String createReview(UserRatingAndReviewRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Ride ride = rideRepository.findById(dto.getRideId())
                .orElseThrow(() -> new RuntimeException("Ride not found"));
        Driver driver = driverRepository.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        UserRatingAndReview review = UserRatingAndReview.builder()
                .user(user)
                .ride(ride)
                .driver(driver)
                .review(dto.getReview())
                .rating(dto.getRating())
                .reviewStatus(ReviewStatus.SUCCESS)
                .build();

        reviewRepository.save(review);
        return "User rating and review submitted successfully";
    }

    public UserRatingAndReviewResponseDTO getReviewById(UUID id) {
        UserRatingAndReview review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));

        return UserRatingAndReviewResponseDTO.builder()
                .id(review.getId())
                .userId(review.getUser().getId())
                .rideId(review.getRide().getId())
                .driverId(review.getDriver().getId())
                .review(review.getReview())
                .rating(review.getRating())
                .reviewStatus(review.getReviewStatus())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}

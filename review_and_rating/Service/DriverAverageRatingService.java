package com.gdc.review_and_rating.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import com.gdc.review_and_rating.Repository.DriverAverageRatingRepository;
import com.gdc.review_and_rating.Repository.UserRatingAndReviewRepository;
import com.gdc.review_and_rating.Repository.DriverRepository;
import com.gdc.review_and_rating.dto.request.DriverAverageRatingRequestDTO;
import com.gdc.review_and_rating.dto.response.DriverAverageRatingResponseDTO;
import com.gdc.review_and_rating.entity.Driver;
import com.gdc.review_and_rating.entity.DriverAverageRating;
import com.gdc.review_and_rating.entity.UserRatingAndReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;
@Service
@RequiredArgsConstructor
public class DriverAverageRatingService {

    private final DriverAverageRatingRepository driverAverageRatingRepository;
    private final UserRatingAndReviewRepository userRatingAndReviewRepository;
    private final DriverRepository driverRepository;

    public DriverAverageRatingResponseDTO calculateAndSaveAverageRating(UUID driverId) {
        List<UserRatingAndReview> ratings = userRatingAndReviewRepository.findByDriverId(driverId);

        if (ratings.isEmpty()) {
            throw new RuntimeException("No ratings found for this driver");
        }

        double total = ratings.stream().mapToDouble(UserRatingAndReview::getRating).sum();
        int count = ratings.size();
        double average = total / count;

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        DriverAverageRating averageRating = DriverAverageRating.builder()
                .driver(driver)
                .totalRatings(count)
                .averageRating(average)
                .build();

        driverAverageRatingRepository.save(averageRating);

        return new DriverAverageRatingResponseDTO(
                driverId,
                average,
                count,
                "Driver ID " + driverId + " average rating is " + average);
    }
}


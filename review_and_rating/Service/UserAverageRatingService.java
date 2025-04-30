package com.gdc.review_and_rating.Service;

import com.gdc.review_and_rating.dto.request.UserAverageRatingRequestDTO;
import com.gdc.review_and_rating.dto.response.UserAverageRatingResponseDTO;
import com.gdc.review_and_rating.entity.DriverRating;
import com.gdc.review_and_rating.entity.User;
import com.gdc.review_and_rating.entity.UserAverageRating;
import com.gdc.review_and_rating.Repository.DriverRatingRepository;
import com.gdc.review_and_rating.Repository.UserAverageRatingRepository;
import com.gdc.review_and_rating.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAverageRatingService {

    private final DriverRatingRepository driverRatingRepository;
    private final UserRepository userRepository;
    private final UserAverageRatingRepository userAverageRatingRepository;

    public UserAverageRatingResponseDTO calculateUserAverageRating(UserAverageRatingRequestDTO requestDTO) {
        UUID userId = requestDTO.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        List<DriverRating> ratings = driverRatingRepository.findByUser(user);
        if (ratings.isEmpty()) {
            throw new RuntimeException("No ratings found for this user");
        }

        double average = ratings.stream().mapToInt(DriverRating::getRating).average().orElse(0.0);
        long total = ratings.size();

        UserAverageRating userAverageRating = UserAverageRating.builder()
                .user(user)
                .averageRating(average)
                .totalRatings(total)
                .build();

        userAverageRatingRepository.save(userAverageRating);

        return new UserAverageRatingResponseDTO(
                userId,
                average,
                total,
                "User ID " + userId + " average rating is " + average
        );
    }
}

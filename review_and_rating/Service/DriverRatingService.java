package com.gdc.review_and_rating.Service;
import com.gdc.review_and_rating.Repository.DriverRatingRepository;
import com.gdc.review_and_rating.dto.request.CreateDriverRatingRequestDTO;
import com.gdc.review_and_rating.dto.response.DriverRatingResponseDTO;
import com.gdc.review_and_rating.entity.DriverRating;
import com.gdc.review_and_rating.entity.User;
import com.gdc.review_and_rating.entity.Driver;
import com.gdc.review_and_rating.entity.Ride;
import com.gdc.review_and_rating.Repository.UserRepository;
import com.gdc.review_and_rating.Repository.DriverRepository;
import com.gdc.review_and_rating.Repository.RideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverRatingService {

    private final DriverRatingRepository driverRatingRepository;
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private final RideRepository rideRepository;

    public DriverRatingResponseDTO createDriverRating(CreateDriverRatingRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow();
        Driver driver = driverRepository.findById(dto.getDriverId()).orElseThrow();
        Ride ride = rideRepository.findById(dto.getRideId()).orElseThrow();

        DriverRating driverRating = DriverRating.builder()
                .user(user)
                .driver(driver)
                .ride(ride)
                .rating(dto.getRating())
                .build();

        DriverRating saved = driverRatingRepository.save(driverRating);

        DriverRatingResponseDTO response = new DriverRatingResponseDTO();
        response.setId(saved.getId());
        response.setUserId(saved.getUser().getId());
        response.setDriverId(saved.getDriver().getId());
        response.setRideId(saved.getRide().getId());
        response.setRating(saved.getRating());

        return response;
    }

    public DriverRatingResponseDTO getDriverRatingById(UUID id) {
        DriverRating rating = driverRatingRepository.findById(id).orElseThrow();
        DriverRatingResponseDTO response = new DriverRatingResponseDTO();
        response.setId(rating.getId());
        response.setUserId(rating.getUser().getId());
        response.setDriverId(rating.getDriver().getId());
        response.setRideId(rating.getRide().getId());
        response.setRating(rating.getRating());
        return response;
    }
}

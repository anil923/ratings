package com.gdc.review_and_rating.Repository;

import com.gdc.review_and_rating.entity.Driver;
import com.gdc.review_and_rating.entity.UserRatingAndReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRatingAndReviewRepository extends JpaRepository<UserRatingAndReview, UUID> {
    List<UserRatingAndReview> findByDriverId(UUID driverId);

    Object findByDriver(Driver driver);
}

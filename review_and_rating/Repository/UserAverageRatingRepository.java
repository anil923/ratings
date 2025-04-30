package com.gdc.review_and_rating.Repository;

import com.gdc.review_and_rating.entity.UserAverageRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAverageRatingRepository extends JpaRepository<UserAverageRating, UUID> {
}

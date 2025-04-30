package com.gdc.review_and_rating.Repository;
import com.gdc.review_and_rating.entity.DriverAverageRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DriverAverageRatingRepository extends JpaRepository<DriverAverageRating, UUID> {
}

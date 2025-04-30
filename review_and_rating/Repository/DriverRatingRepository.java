package com.gdc.review_and_rating.Repository;

import com.gdc.review_and_rating.entity.DriverRating;
import com.gdc.review_and_rating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
    public interface DriverRatingRepository extends JpaRepository<DriverRating, UUID> {
        List<DriverRating> findByUser_Id(UUID userId);

    List<DriverRating> findByUser(User user);
}



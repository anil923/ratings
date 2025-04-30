package com.gdc.review_and_rating.Repository;
import com.gdc.review_and_rating.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
public interface RideRepository extends JpaRepository<Ride, UUID> {
    Optional<Ride> findById(org.hibernate.validator.constraints.UUID rideId);
}

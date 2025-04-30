package com.gdc.review_and_rating.Repository;

import com.gdc.review_and_rating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    Optional<User> findById(org.hibernate.validator.constraints.UUID userId);
   // UUID userId = UUID.fromString("your-uuid-string-here");
   // Optional<User> user = UserRepository.findById(User);
   // Optional<User> user = UserRepository.findById(UUID); // Pass a UUID

  //  Optional<Object> findById(Long userId);
}

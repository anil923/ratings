package com.gdc.review_and_rating.entity;
import com.gdc.review_and_rating.entity.User;
import com.gdc.review_and_rating.Enum.VehicleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Driver entity representing a user who is registered as a driver.
 * Each driver is associated with a unique user profile.
 */
@Entity
@Table(name = "drivers", schema = "gdc_db")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "fk_driver_user"))
    private User user;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Vehicle type must not be null")
    private VehicleType vehicleType;

    @Column(name = "license_number", nullable = false, unique = true)
    @NotBlank(message = "License number is mandatory")
    @Size(min = 5, max = 20, message = "License number must be between 5 and 20 characters")
    private String licenseNumber;

    @Column(name = "vehicle_number", nullable = false, unique = true)
    @NotBlank(message = "Vehicle number is mandatory")
    @Size(min = 5, max = 15, message = "Vehicle number must be between 5 and 15 characters")
    private String vehicleNumber;

    @NotNull(message = "Vehicle capacity must not be null")
    @Column(name = "vehicle_capacity", nullable = false)
    private Double vehicleCapacity;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}

package com.gdc.review_and_rating.entity;
import com.gdc.review_and_rating.entity.Driver;
import com.gdc.review_and_rating.Enum.RideStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "rides", schema = "gdc_db")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;


    @ManyToOne
    @JoinColumn(
            name = "driver_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_ride_driver_id")
    )
    private Driver driver;


    @Column(name = "departure_location", nullable = false)
    private String departureLocation;


    @Column(name = "destination_location", nullable = false)
    private String destinationLocation;


    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;


    @Column(name = "available_space", nullable = false)
    private Integer availableSpace;


    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RideStatus status;


    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

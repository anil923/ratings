package com.gdc.review_and_rating.Controller;
import com.gdc.review_and_rating.entity.Ride;
import com.gdc.review_and_rating.Service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
public class RideController {
    private final RideService rideService;

    @PostMapping("/create")
    public ResponseEntity<String> createRide(@RequestBody Ride ride) {
        rideService.createRide(ride);
        return ResponseEntity.ok("Ride created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Ride>> getAllRides() {

        return ResponseEntity.ok(rideService.getAllRides());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable UUID id) {
        return ResponseEntity.ok(rideService.getRideById(id));
    }

}

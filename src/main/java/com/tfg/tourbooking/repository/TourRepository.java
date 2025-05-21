package com.tfg.tourbooking.repository;

import com.tfg.tourbooking.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findByPort(String port);
    List<Tour> findByOwnerId(Long ownerId);
}
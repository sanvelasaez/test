package com.tfg.tourbooking.repository;

import com.tfg.tourbooking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByTourId(Long tourId);
    List<Reservation> findByTouristId(Long touristId);
}

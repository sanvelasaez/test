package com.tfg.tourbooking.service;

import com.tfg.tourbooking.dto.ReservationDto;
import com.tfg.tourbooking.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByTour(Long tourId);
    List<Reservation> getReservationsByTourist(Long touristId);
    Reservation createReservation(ReservationDto dto);
}

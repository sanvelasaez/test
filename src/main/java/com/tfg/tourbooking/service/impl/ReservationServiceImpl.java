package com.tfg.tourbooking.service.impl;

import com.tfg.tourbooking.dto.ReservationDto;
import com.tfg.tourbooking.model.Reservation;
import com.tfg.tourbooking.model.Tour;
import com.tfg.tourbooking.model.User;
import com.tfg.tourbooking.repository.ReservationRepository;
import com.tfg.tourbooking.repository.TourRepository;
import com.tfg.tourbooking.repository.UserRepository;
import com.tfg.tourbooking.service.ReservationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final TourRepository tourRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByTour(Long tourId) {
        return reservationRepository.findByTourId(tourId);
    }

    @Override
    public List<Reservation> getReservationsByTourist(Long touristId) {
        return reservationRepository.findByTouristId(touristId);
    }

    @Override
    public Reservation createReservation(ReservationDto dto) {
        User tourist = userRepository.findById(dto.getTouristId())
                .orElseThrow(() -> new IllegalArgumentException("Turista no encontrado"));

        Tour tour = tourRepository.findById(dto.getTourId())
                .orElseThrow(() -> new IllegalArgumentException("Tour no encontrado"));

        Reservation reservation = new Reservation();
        reservation.setTourist(tourist);
        reservation.setTour(tour);
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setDescripcion(dto.getDescripcion());

        return reservationRepository.save(reservation);
    }
}

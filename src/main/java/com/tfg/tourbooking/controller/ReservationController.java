package com.tfg.tourbooking.controller;

import com.tfg.tourbooking.dto.ReservationDto;
import com.tfg.tourbooking.model.Reservation;
import com.tfg.tourbooking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/tour/{tourId}")
    public List<Reservation> getByTour(@PathVariable Long tourId) {
        return reservationService.getReservationsByTour(tourId);
    }

    @GetMapping("/tourist/{touristId}")
    public List<Reservation> getByTourist(@PathVariable Long touristId) {
        return reservationService.getReservationsByTourist(touristId);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.createReservation(reservationDto);
    }
}

package com.tfg.tourbooking.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDto {
    private Long touristId;
    private Long tourId;
    private LocalDate reservationDate;
    private String descripcion;
}

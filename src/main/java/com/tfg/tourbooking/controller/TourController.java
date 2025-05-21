package com.tfg.tourbooking.controller;

import com.tfg.tourbooking.model.Tour;
import com.tfg.tourbooking.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@CrossOrigin(origins = "*")
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

    @GetMapping("/port/{port}")
    public List<Tour> getByPort(@PathVariable String port) {
        return tourService.getToursByPort(port);
    }

    @GetMapping("/owner/{id}")
    public List<Tour> getByOwner(@PathVariable Long id) {
        return tourService.getToursByOwner(id);
    }
}
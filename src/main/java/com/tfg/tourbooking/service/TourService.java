package com.tfg.tourbooking.service;

import com.tfg.tourbooking.model.Tour;
import com.tfg.tourbooking.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public List<Tour> getToursByPort(String port) {
        return tourRepository.findByPort(port);
    }

    public List<Tour> getToursByOwner(Long ownerId) {
        return tourRepository.findByOwnerId(ownerId);
    }
}
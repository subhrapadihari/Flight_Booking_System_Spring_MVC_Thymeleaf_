package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Flight;
import com.nit.exception.FlightNotFoundException;
import com.nit.repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public Flight saveFlight(Flight flight) {
        return repository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Flight getFlightById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                    new FlightNotFoundException("Flight not found"));
    }

    public Flight updateFlight(Long id, Flight flight) {

        Flight existingFlight = repository.findById(id)
                .orElseThrow(() ->
                    new FlightNotFoundException("Flight not found"));

        existingFlight.setFlightNumber(flight.getFlightNumber());
        existingFlight.setAirline(flight.getAirline());
        existingFlight.setSource(flight.getSource());
        existingFlight.setDestination(flight.getDestination());
        existingFlight.setDepartureTime(flight.getDepartureTime());
        existingFlight.setArrivalTime(flight.getArrivalTime());
        existingFlight.setTotalSeats(flight.getTotalSeats());
        existingFlight.setAvailableSeats(flight.getAvailableSeats());
        existingFlight.setPrice(flight.getPrice());

        return repository.save(existingFlight);
    }

    public void deleteFlight(Long id) {

        Flight flight = repository.findById(id)
                .orElseThrow(() ->
                    new FlightNotFoundException("Flight not found"));

        repository.delete(flight);
    }
}
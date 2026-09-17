package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Passenger;
import com.nit.exception.PassengerNotFoundException;
import com.nit.repository.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository repository;

    public Passenger savePassenger(Passenger passenger) {
        return repository.save(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return repository.findAll();
    }

    public Passenger getPassengerById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                    new PassengerNotFoundException("Passenger not found"));
    }

    public Passenger updatePassenger(
            Long id,
            Passenger passenger) {

        Passenger existingPassenger = repository.findById(id)
                .orElseThrow(() ->
                    new PassengerNotFoundException("Passenger not found"));

        existingPassenger.setName(passenger.getName());
        existingPassenger.setEmail(passenger.getEmail());
        existingPassenger.setPhone(passenger.getPhone());
        existingPassenger.setAge(passenger.getAge());
        existingPassenger.setGender(passenger.getGender());

        return repository.save(existingPassenger);
    }

    public void deletePassenger(Long id) {

        Passenger passenger = repository.findById(id)
                .orElseThrow(() ->
                    new PassengerNotFoundException("Passenger not found"));

        repository.delete(passenger);
    }
}
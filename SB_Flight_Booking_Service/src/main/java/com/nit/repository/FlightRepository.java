package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
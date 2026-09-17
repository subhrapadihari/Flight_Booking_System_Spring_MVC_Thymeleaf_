package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Booking;
import com.nit.exception.BookingNotFoundException;
import com.nit.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public Booking saveBooking(Booking booking) {
        return repository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public Booking getBookingById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                    new BookingNotFoundException("Booking not found"));
    }

    public Booking updateBooking(
            Long id,
            Booking booking) {

        Booking existingBooking = repository.findById(id)
                .orElseThrow(() ->
                    new BookingNotFoundException("Booking not found"));

        existingBooking.setBookingNumber(
                booking.getBookingNumber());

        existingBooking.setBookingDate(
                booking.getBookingDate());

        existingBooking.setSeatNumber(
                booking.getSeatNumber());

        existingBooking.setStatus(
                booking.getStatus());

        existingBooking.setTotalAmount(
                booking.getTotalAmount());

        existingBooking.setFlight(
                booking.getFlight());

        existingBooking.setPassenger(
                booking.getPassenger());

        return repository.save(existingBooking);
    }

    public void deleteBooking(Long id) {

        Booking booking = repository.findById(id)
                .orElseThrow(() ->
                    new BookingNotFoundException("Booking not found"));

        repository.delete(booking);
    }
}
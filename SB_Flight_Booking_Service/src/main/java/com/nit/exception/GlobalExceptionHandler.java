package com.nit.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FlightNotFoundException.class)
    public String handleFlightNotFound(
            FlightNotFoundException ex,
            Model model) {

        model.addAttribute("message", ex.getMessage());

        return "error";
    }

    @ExceptionHandler(PassengerNotFoundException.class)
    public String handlePassengerNotFound(
            PassengerNotFoundException ex,
            Model model) {

        model.addAttribute("message", ex.getMessage());

        return "error";
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public String handleBookingNotFound(
            BookingNotFoundException ex,
            Model model) {

        model.addAttribute("message", ex.getMessage());

        return "error";
    }
}
package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nit.entity.Booking;
import com.nit.service.BookingService;
import com.nit.service.FlightService;
import com.nit.service.PassengerService;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @Autowired
    private FlightService flightService;

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public String getAllBookings(Model model) {

        model.addAttribute(
                "bookings",
                service.getAllBookings()
        );

        return "bookings";
    }

    @GetMapping("/add")
    public String showAddBookingForm(Model model) {

        model.addAttribute(
                "booking",
                new Booking()
        );

        model.addAttribute(
                "flights",
                flightService.getAllFlights()
        );

        model.addAttribute(
                "passengers",
                passengerService.getAllPassengers()
        );

        return "add-booking";
    }

    @PostMapping("/save")
    public String saveBooking(
            @ModelAttribute Booking booking) {

        service.saveBooking(booking);

        return "redirect:/bookings";
    }

    @GetMapping("/edit/{id}")
    public String showEditBookingForm(
            @PathVariable Long id,
            Model model) {

        Booking booking =
                service.getBookingById(id);

        model.addAttribute(
                "booking",
                booking
        );

        model.addAttribute(
                "flights",
                flightService.getAllFlights()
        );

        model.addAttribute(
                "passengers",
                passengerService.getAllPassengers()
        );

        return "edit-booking";
    }

    @PostMapping("/update/{id}")
    public String updateBooking(
            @PathVariable Long id,
            @ModelAttribute Booking booking) {

        service.updateBooking(id, booking);

        return "redirect:/bookings";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(
            @PathVariable Long id) {

        service.deleteBooking(id);

        return "redirect:/bookings";
    }
}
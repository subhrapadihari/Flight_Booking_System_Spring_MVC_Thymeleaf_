package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nit.entity.Flight;
import com.nit.service.FlightService;

@Controller
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService service;

    @GetMapping
    public String getAllFlights(Model model) {

        model.addAttribute("flights", service.getAllFlights());

        return "flights";
    }

    @GetMapping("/add")
    public String showAddFlightForm(Model model) {

        model.addAttribute("flight", new Flight());

        return "add-flight";
    }

    @PostMapping("/save")
    public String saveFlight(@ModelAttribute Flight flight) {

        service.saveFlight(flight);

        return "redirect:/flights";
    }

    @GetMapping("/edit/{id}")
    public String showEditFlightForm(
            @PathVariable Long id,
            Model model) {

        Flight flight = service.getFlightById(id);

        model.addAttribute("flight", flight);

        return "edit-flight";
    }

    @PostMapping("/update/{id}")
    public String updateFlight(
            @PathVariable Long id,
            @ModelAttribute Flight flight) {

        service.updateFlight(id, flight);

        return "redirect:/flights";
    }

    @GetMapping("/delete/{id}")
    public String deleteFlight(@PathVariable Long id) {

        service.deleteFlight(id);

        return "redirect:/flights";
    }
}
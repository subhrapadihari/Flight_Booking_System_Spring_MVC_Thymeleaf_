package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nit.entity.Passenger;
import com.nit.service.PassengerService;

@Controller
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService service;

    @GetMapping
    public String getAllPassengers(Model model) {

        model.addAttribute(
                "passengers",
                service.getAllPassengers()
        );

        return "passengers";
    }

    @GetMapping("/add")
    public String showAddPassengerForm(Model model) {

        model.addAttribute(
                "passenger",
                new Passenger()
        );

        return "add-passenger";
    }

    @PostMapping("/save")
    public String savePassenger(
            @ModelAttribute Passenger passenger) {

        service.savePassenger(passenger);

        return "redirect:/passengers";
    }

    @GetMapping("/edit/{id}")
    public String showEditPassengerForm(
            @PathVariable Long id,
            Model model) {

        Passenger passenger =
                service.getPassengerById(id);

        model.addAttribute(
                "passenger",
                passenger
        );

        return "edit-passenger";
    }

    @PostMapping("/update/{id}")
    public String updatePassenger(
            @PathVariable Long id,
            @ModelAttribute Passenger passenger) {

        service.updatePassenger(id, passenger);

        return "redirect:/passengers";
    }

    @GetMapping("/delete/{id}")
    public String deletePassenger(
            @PathVariable Long id) {

        service.deletePassenger(id);

        return "redirect:/passengers";
    }
}
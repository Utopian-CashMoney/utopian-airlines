package com.smoothstack.utopiaairlines.controllers;

import com.smoothstack.utopiaairlines.entities.Flight;
import com.smoothstack.utopiaairlines.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Controllers for employee actions.
 * @author Joshua Podhola
 * @author Chauvin Patel
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private FlightService flightService;

    //Shamelessly copied from AdminController
    @GetMapping("/all")
    public List<Flight> getFlights() {
        List<Flight> flights;
        flights = flightService.findFlights();
        return flights;
    }

    @GetMapping("/searchid")
    public List<Flight> getFlightsByRouteId(@RequestParam("routeid") Integer routeId) {
        List<Flight> flights;
        flights = flightService.findFlightsByRouteId(routeId);
        return flights;
    }

    @GetMapping("/searchplaneid")
    public List<Flight> getFlightsByAirplaneId(@RequestParam ("airplaneid") Integer airplaneId) {
        List<Flight> flights;
        flights = flightService.findFlightsByAirplaneId(airplaneId);
        return flights;
    }

    @GetMapping("/searchdate")
    public List<Flight> getFlightsByDate(@RequestParam("onDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Flight> flights;
        flights = flightService.findFlightsByDate(date);
        return flights;
    }

    @GetMapping("/searchbefore")
    public List<Flight> getFlightsByDateBefore(@RequestParam("beforeDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Flight> flights;
        flights = flightService.findFlightsByDateBefore(date);
        return flights;
    }

    @GetMapping("/searchafter")
    public List<Flight> getFlightsByDateAfter(@RequestParam("afterDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Flight> flights;
        flights = flightService.findFlightsByDateAfter(date);
        return flights;
    }

    @GetMapping("/searchrange")
    public List<Flight> getFlightsByDateBetween(@RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart, @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd) {
        List<Flight> flights;
        flights = flightService.findFlightsByDateBetween(dateStart, dateEnd);
        return flights;
    }

    @PutMapping("/update")
    public String updateFlight(@RequestBody Flight flight) {
        flightService.updateFlight(flight);
        return "Flight Successfully Updated!";
    }

    @PutMapping("/add_seats/{id}")
    public String addSeats(
            @PathVariable int id,
            @RequestParam(value = "firstClass", required = false, defaultValue = "0") int firstClass,
            @RequestParam(value = "businessClass", required = false, defaultValue = "0") int businessClass,
            @RequestParam(value = "economyClass", required = false, defaultValue = "0") int economyClass) {
        try {
            Optional<Flight> flight = flightService.findFlightsById(id);
            if (!flight.isPresent()) {
                return "Couldn't find flight with that id.";
            }
            Flight flightObj = flight.get();
            flightObj.setBusinessSeats(flightObj.getBusinessSeats() + businessClass);
            flightObj.setEconomySeats(flightObj.getEconomySeats() + economyClass);
            flightObj.setFirstClassSeats(flightObj.getFirstClassSeats() + firstClass);

            flightService.updateFlight(flightObj);
            return "Added seats!";
        } catch(Exception e) {
            return "Unable to update flight.";
        }
    }
}

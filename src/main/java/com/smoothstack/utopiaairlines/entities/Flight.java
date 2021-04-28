package com.smoothstack.utopiaairlines.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "flight")
public class Flight implements Serializable {
    private static final long serialVersionUID = -4262878510116123649L;

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;
    
    @ManyToOne
    @JoinColumn(name = "route_id")
    private int route_id;
    
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private int airplane_id;
    
    @Column(name = "departure_time")
    private LocalDateTime departure_time;
    
    @Column(name = "economy_seats")
    private int economy_seats;
    
    @Column(name = "business_seats")
    private int business_seats;
    
    @Column(name = "first_class")
    private int firstclass_seats;

    // Relationships
    @ManyToOne
    private Route route;
    
    @ManyToOne
    private Airplane airplane;
    
    @OneToMany
    private Collection<Ticket> tickets;

    // Methods

    /**
     * @param id Flight ID
     * @param route_id Route ID
     * @param airplane_id Airplane ID
     * @param departure_time DateTime of Departure
     * @param economy_seats # of available economy class seats
     * @param business_seats # of available business class seats
     * @param firstclass_seats # of available first class seats
     */
    public Flight(int id, int route_id, int airplane_id, LocalDateTime departure_time, int economy_seats, int business_seats, int firstclass_seats) {
        this.id = id;
        this.route_id = route_id;
        this.airplane_id = airplane_id;
        this.departure_time = departure_time;
        this.economy_seats = economy_seats;
        this.business_seats = business_seats;
        this.firstclass_seats = firstclass_seats;
    }

    public int getID() {
        return id;
    }

    public int getRouteID() {
        return route_id;
    }

    public void setRouteID(int route_id) {
        this.route_id = route_id;
    }

    public int getAirplaneID() {
        return airplane_id;
    }

    public void setAirplaneID(int airplane_id) {
        this.airplane_id = airplane_id;
    }

    public LocalDateTime getDepartureTime() {
        return departure_time;
    }

    public void setDepartureTime(LocalDateTime departure_time) {
        this.departure_time = departure_time;
    }

    public int getEconomySeats() {
        return economy_seats;
    }

    public void setEconomySeats(int economy_seats) {
        this.economy_seats = economy_seats;
    }

    public int getBusinessSeats() {
        return business_seats;
    }

    public void setBusinessSeats(int business_seats) {
        this.business_seats = business_seats;
    }

    public int getFirstClassSeats() {
        return firstclass_seats;
    }

    public void setFirstClassSeats(int firstclass_seats) {
        this.firstclass_seats = firstclass_seats;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        assert(route == null || route.getID() == this.route_id);
        this.route = route;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        assert(airplane == null || airplane.getID() == this.airplane_id);
        this.airplane = airplane;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}

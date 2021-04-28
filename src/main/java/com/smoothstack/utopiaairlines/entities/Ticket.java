package com.smoothstack.utopiaairlines.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = -8851134397108304037L;

    // Data
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private final int flight_id;
    
    @ManyToOne
    @JoinColumn(name = "traveller_id")
    private final int traveller_id;
    
    @Column(name = "seat_class")
    private String seat_class;
    
    @Column(name = "is_cancelled")
    private boolean is_cancelled;

    // Relationships
    @ManyToOne
    private Flight flight;
    
    @ManyToOne
    private Traveller traveller;

    // Methods

    /**
     * @param flight_id The ID of the flight
     * @param traveller_id The ID of the traveller
     * @param seat_class The class of seat booked
     * @param is_cancelled Was the flight cancelled?
     */
    public Ticket(int flight_id, int traveller_id, String seat_class, boolean is_cancelled) {
        this.flight_id = flight_id;
        this.traveller_id = traveller_id;
        this.seat_class = seat_class;
        this.is_cancelled = is_cancelled;
    }

    public int getFlightID() {
        return flight_id;
    }

    public int getTravellerID() {
        return traveller_id;
    }

    public String getSeatClass() {
        return seat_class;
    }

    public void setSeatClass(String seat_class) {
        this.seat_class = seat_class;
    }

    public boolean isCancelled() {
        return is_cancelled;
    }

    public void setCancelled(boolean is_cancelled) {
        this.is_cancelled = is_cancelled;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        assert(flight == null || flight.getID() == this.flight_id);
        this.flight = flight;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        assert(traveller == null || traveller.getID() == this.traveller_id);
        this.traveller = traveller;
    }
}

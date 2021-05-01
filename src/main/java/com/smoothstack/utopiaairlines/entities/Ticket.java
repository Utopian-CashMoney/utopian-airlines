package com.smoothstack.utopiaairlines.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
@IdClass(TicketPK.class)
public class Ticket implements Serializable {
    private static final long serialVersionUID = -8851134397108304037L;

    // Data
    @Id
    @Column(name = "flight_id", insertable = false, updatable = false)
    private Integer flightID;

    @Id
    @Column(name = "traveller_id", insertable = false, updatable = false)
    private Integer travellerID;

    @Column(name = "seat_class")
    private String seat_class;
    
    @Column(name = "is_cancelled")
    private boolean is_cancelled;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value="flight-tickets")
    @JoinColumn(name="flight_id", referencedColumnName ="id")
    protected Flight flight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value="ticket-traveller")
    @JoinColumn(name="traveller_id", referencedColumnName ="id")
    protected Traveller traveller;

    // Methods
    public String getSeat_class() {
        return seat_class;
    }

    public void setSeat_class(String seat_class) {
        this.seat_class = seat_class;
    }

    public boolean isCancelled() {
        return is_cancelled;
    }

    public void setIs_cancelled(boolean is_cancelled) {
        this.is_cancelled = is_cancelled;
    }

    public Flight getFlight() {
        return flight;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setFlight(Flight flight) {
        if(flight != null) this.flightID = flight.getId();
        else this.flightID = null;
        this.flight = flight;
    }

    public void setTraveller(Traveller traveller) {
        if(traveller != null) this.travellerID = traveller.getId();
        else this.travellerID = null;
        this.traveller = traveller;
    }

    public Integer getFlightID() {
        return flightID;
    }

    public Integer getTravellerID() {
        return travellerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return is_cancelled == ticket.is_cancelled && Objects.equals(seat_class, ticket.seat_class) && Objects.equals(flight, ticket.flight) && Objects.equals(traveller, ticket.traveller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seat_class, is_cancelled, flight, traveller);
    }
}

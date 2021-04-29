package com.smoothstack.utopiaairlines.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@IdClass(TicketPK.class)
public class Ticket implements Serializable {
    private static final long serialVersionUID = -8851134397108304037L;

    // Data
    @Id
    @Column(name = "flight_id")
    private Integer flightID;

    @Id
    @Column(name = "traveller_id")
    private Integer travellerID;

    @Column(name = "seat_class")
    private String seatClass;
    
    @Column(name = "is_cancelled")
    private boolean isCancelled;

    @ManyToOne
    @JsonBackReference(value="flight-tickets")
    @JoinColumn(name="flight_id", referencedColumnName ="id", insertable = false, updatable = false)
    protected Flight flight;

    @ManyToOne
    @JsonBackReference(value="ticket-traveller")
    @JoinColumn(name="traveller_id", referencedColumnName ="id", insertable = false, updatable = false)
    protected Traveller traveller;

    // Methods
    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seat_class) {
        this.seatClass = seat_class;
    }

    public boolean isIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(boolean is_cancelled) {
        this.isCancelled = is_cancelled;
    }

    public Flight getFlight() {
        return flight;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    public Integer getTravellerID() {
        return travellerID;
    }

    public void setTravellerID(Integer travellerID) {
        this.travellerID = travellerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return isCancelled == ticket.isCancelled && Objects.equals(seatClass, ticket.seatClass) && Objects.equals(flight, ticket.flight) && Objects.equals(traveller, ticket.traveller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatClass, isCancelled, flight, traveller);
    }
}

package com.smoothstack.utopiaairlines.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonIgnoreProperties("tickets")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="flight_id", updatable = false, insertable = false)
    protected Flight flight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("flights")
    @JoinColumn(name="traveller_id", updatable = false, insertable = false)
    protected Traveller traveller;

    // Methods
    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seat_class) {
        this.seatClass = seat_class;
    }

    public boolean isCancelled() {
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
        return isCancelled == ticket.isCancelled && Objects.equals(seatClass, ticket.seatClass) && Objects.equals(flight, ticket.flight) && Objects.equals(traveller, ticket.traveller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatClass, isCancelled, flight, traveller);
    }
}

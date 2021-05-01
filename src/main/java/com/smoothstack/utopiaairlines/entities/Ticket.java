package com.smoothstack.utopiaairlines.entities;

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
@IdClass(TicketPK.class)
@Table(name = "ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = -8851134397108304037L;

    // Data
    @Column(name = "seat_class")
    private String seat_class;
    
    @Column(name = "is_cancelled")
    private boolean is_cancelled;

    // Relationships
    @Id
    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    @Id
    @ManyToOne
    @JoinColumn(name = "traveller_id", referencedColumnName = "id")
    private Traveller traveller;

    // Methods
    public String getSeat_class() {
        return seat_class;
    }

    public void setSeat_class(String seat_class) {
        this.seat_class = seat_class;
    }

    public boolean isIs_cancelled() {
        return is_cancelled;
    }

    public void setIs_cancelled(boolean is_cancelled) {
        this.is_cancelled = is_cancelled;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
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

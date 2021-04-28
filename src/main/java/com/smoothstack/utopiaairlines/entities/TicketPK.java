package com.smoothstack.utopiaairlines.entities;


import java.io.Serializable;
import java.util.Objects;

public class TicketPK implements Serializable {
    private static final long serialVersionUID = 5464384774151807355L;
    private Traveller traveller;
    private Flight flight;

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPK ticketPK = (TicketPK) o;
        return Objects.equals(traveller, ticketPK.traveller) && Objects.equals(flight, ticketPK.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traveller, flight);
    }
}

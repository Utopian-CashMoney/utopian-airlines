package com.smoothstack.utopiaairlines.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

public class Route implements Serializable {
    private static final long serialVersionUID = -9190994961314139861L;

    // Data
    private final int id;
    private String origin_iata;
    private String destination_iata;

    // Relationships
    private Airport origin, destination;
    private Collection<Flight> flights;


    // Methods

    /**
     * @param id ID of the route
     * @param origin_iata IATA Identifier of Origin Airport
     * @param destination_iata IATA Identifier of Destination Airport
     */
    public Route(int id, String origin_iata, String destination_iata) {
        this.id = id;
        this.origin_iata = origin_iata;
        this.destination_iata = destination_iata;
    }

    public int getID() {
        return id;
    }

    public String getOriginIATA() {
        return origin_iata;
    }

    public void setOriginIATA(String origin_iata) {
        this.origin_iata = origin_iata;
    }

    public String getDestinationIATA() {
        return destination_iata;
    }

    public void setDestinationIATA(String destination_iata) {
        this.destination_iata = destination_iata;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        assert(origin == null || origin.getIATA().equals(this.origin_iata));
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        assert(destination == null || destination.getIATA().equals(this.destination_iata));
        this.destination = destination;
    }

    public Collection<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

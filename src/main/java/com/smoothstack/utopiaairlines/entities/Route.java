package com.smoothstack.utopiaairlines.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

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
@Table(name = "route")
public class Route implements Serializable {
    private static final long serialVersionUID = -9190994961314139861L;

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;
    
    @Column(name = "origin_id")
    private String origin_iata;
    
    @Column(name = "destination_id")
    private String destination_iata;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Airport origin;
    
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destination;
    
    @OneToMany
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

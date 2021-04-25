package com.smoothstack.utopiaairlines.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

public class Airport implements Serializable {
    private static final long serialVersionUID = 7707393142740096516L;

    // Data (primary key is final)
    private final String iata;
    private String city;

    // Relationships
    private Collection<Route> origin_of, destination_of;

    // Methods
    /**
     * Construct a new Airport
     * @param iata The 3-Character IATA identifier of the airport
     * @param city The city the airport resides in
     */
    public Airport(String iata, String city) {
        this.iata = iata;
        this.city = city;
    }

    public String getIATA() {
        return iata;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<Route> getOriginOf() {
        return origin_of;
    }

    public void setOriginOf(Collection<Route> origin_of) {
        this.origin_of = origin_of;
    }

    public Collection<Route> getDestinationOf() {
        return destination_of;
    }

    public void setDestinationOf(Collection<Route> destination_of) {
        this.destination_of = destination_of;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return iata.equals(airport.iata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iata);
    }
}

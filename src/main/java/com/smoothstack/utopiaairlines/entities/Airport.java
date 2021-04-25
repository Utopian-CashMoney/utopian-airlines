package com.smoothstack.utopiaairlines.entities;

import java.io.Serializable;
import java.util.Objects;

public class Airport implements Serializable {
    private static final long serialVersionUID = 7707393142740096516L;

    // Data (primary key is final)
    private final String iata;
    private String city;

    // Relationships
    // TODO: Relationships

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

    /**
     * @return The 3-Character IATA identifier of the airport
     */
    public String getIATA() {
        return iata;
    }

    /**
     * @return The 3-Character IATA identifier of the airport
     */
    public String getCity() {
        return city;
    }


    /**
     * @param city The new city
     */
    public void setCity(String city) {
        this.city = city;
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

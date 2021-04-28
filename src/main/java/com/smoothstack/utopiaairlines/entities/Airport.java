package com.smoothstack.utopiaairlines.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport implements Serializable {
    private static final long serialVersionUID = 7707393142740096516L;

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String iata_id;
    
    @Column(name = "city")
    private String city;

    // Relationships
    @OneToMany(mappedBy = "origin")
    private Collection<Route> origin_of;

    @OneToMany(mappedBy = "destination")
    private Collection<Route> destination_of;

    // Methods
    public String getIata_id() {
        return iata_id;
    }

    public void setIata_id(String iata) {
        this.iata_id = iata;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<Route> getOrigin_of() {
        return origin_of;
    }

    public void setOrigin_of(Collection<Route> origin_of) {
        this.origin_of = origin_of;
    }

    public Collection<Route> getDestination_of() {
        return destination_of;
    }

    public void setDestination_of(Collection<Route> destination_of) {
        this.destination_of = destination_of;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(iata_id, airport.iata_id) && Objects.equals(city, airport.city) && Objects.equals(origin_of, airport.origin_of) && Objects.equals(destination_of, airport.destination_of);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iata_id, city, origin_of, destination_of);
    }
}

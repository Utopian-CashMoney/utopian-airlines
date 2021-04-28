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
@Table(name = "airplane")
public class Airplane implements Serializable {
    private static final long serialVersionUID = 759683393616486352L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;
    
    @Column(name = "capacity")
    private int capacity;

    // Relationships
    @OneToMany
    private Collection<Flight> flights;

    // Methods


    /**
     * @param id Airplane ID
     * @param capacity Airplane capacity
     */
    public Airplane(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getID() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
        Airplane airplane = (Airplane) o;
        return id == airplane.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

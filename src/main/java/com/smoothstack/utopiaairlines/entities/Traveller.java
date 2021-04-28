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
@Table(name = "traveller")
public class Traveller implements Serializable {
    private static final long serialVersionUID = 1315988496086304814L;

    // Data  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "given_name")
    private String given_name;
    
    @Column(name = "family_name")
    private String family_name;
    
    @Column(name = "membership_number")
    private String memebership_number;

    // Relationships
    @OneToMany(mappedBy = "traveller")
    private Collection<Ticket> tickets;

    // Methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGivenName() {
        return given_name;
    }

    public void setGivenName(String given_name) {
        this.given_name = given_name;
    }

    public String getFamilyName() {
        return family_name;
    }

    public void setFamilyName(String family_name) {
        this.family_name = family_name;
    }

    public String getMemebershipNumber() {
        return memebership_number;
    }

    public void setMemebershipNumber(String memebership_number) {
        this.memebership_number = memebership_number;
    }

    public Collection<Ticket> getFlights() {
        return tickets;
    }

    public void setFlights(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traveller traveller = (Traveller) o;
        return Objects.equals(id, traveller.id) && Objects.equals(given_name, traveller.given_name) && Objects.equals(family_name, traveller.family_name) && Objects.equals(memebership_number, traveller.memebership_number) && Objects.equals(tickets, traveller.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, given_name, family_name, memebership_number, tickets);
    }
}

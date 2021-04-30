package com.smoothstack.utopiaairlines.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "flight")
public class Flight implements Serializable {
    private static final long serialVersionUID = -4262878510116123649L;

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "departure_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime departure_time;
    
    @Column(name = "economy_seats")
    private int economy_seats;
    
    @Column(name = "business_seats")
    private int business_seats;
    
    @Column(name = "firstclass_seats")
    private int firstclass_seats;

    // Relationships
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;
    
    @ManyToOne
    @JsonBackReference(value = "airplane-flights")
    @JoinColumn(name = "airplane_id", referencedColumnName = "id")
    private Airplane airplane;

    @JsonManagedReference(value = "flight-tickets")
    @OneToMany(mappedBy = "flight")
    private Collection<Ticket> tickets;

    // Methods

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalDateTime departure_time) {
        this.departure_time = departure_time;
    }

    public int getEconomy_seats() {
        return economy_seats;
    }

    public void setEconomy_seats(int economy_seats) {
        this.economy_seats = economy_seats;
    }

    public int getBusiness_seats() {
        return business_seats;
    }

    public void setBusiness_seats(int business_seats) {
        this.business_seats = business_seats;
    }

    public int getFirstclass_seats() {
        return firstclass_seats;
    }

    public void setFirstclass_seats(int firstclass_seats) {
        this.firstclass_seats = firstclass_seats;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return economy_seats == flight.economy_seats && business_seats == flight.business_seats && firstclass_seats == flight.firstclass_seats && Objects.equals(id, flight.id) && Objects.equals(departure_time, flight.departure_time) && Objects.equals(route, flight.route) && Objects.equals(airplane, flight.airplane) && Objects.equals(tickets, flight.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departure_time, economy_seats, business_seats, firstclass_seats, route, airplane, tickets);
    }
}

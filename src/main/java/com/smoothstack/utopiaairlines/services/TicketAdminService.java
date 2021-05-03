package com.smoothstack.utopiaairlines.services;

import com.smoothstack.utopiaairlines.dao.TicketDao;
import com.smoothstack.utopiaairlines.entities.Ticket;
import com.smoothstack.utopiaairlines.entities.TicketPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Admin service for Ticket-related CRUD operations
 * @author Joshua Podhola
 */
@Service
@Transactional
public class TicketAdminService {
    @Autowired
    private TicketDao ticketDao;

    public List<Ticket> getAll() {
        return ticketDao.findAll();
    }

    public List<Ticket> searchByMembershipNumber(String membershipNumber) {
        return ticketDao.findByTraveller_MembershipNumberLike(membershipNumber);
    }

    public List<Ticket> searchByDepartureTimeAfter(LocalDateTime flight_departureTime) {
        return ticketDao.findByFlight_DepartureTimeAfter(flight_departureTime);
    }

    public List<Ticket> searchByDepartureTimeBefore(LocalDateTime flightDepartureTime) {
        return ticketDao.findByFlight_DepartureTimeBefore(flightDepartureTime);
    }

    public List<Ticket> searchByDepartureTimeRange(LocalDateTime flightDepartureTime, LocalDateTime flightDepartureTime2) {
        return ticketDao.findByFlight_DepartureTimeBetween(flightDepartureTime, flightDepartureTime2);
    }

    public List<Ticket> searchByOriginCity(String flightRouteOriginCity) {
        return ticketDao.findByFlight_Route_Origin_CityLike(flightRouteOriginCity);
    }

    public List<Ticket> searchByDestinationCity(String flightRouteDestinationCity) {
        return ticketDao.findByFlight_Route_Destination_CityLike(flightRouteDestinationCity);
    }

    /**
     * Insert into the database if the ID doesn't already exist.
     * @param ticket Ticket to add.
     * @return The created ticket, or null if it already exists (and thus no changes made)
     */
    public Ticket insert(Ticket ticket) {
        TicketPK ticketPK = new TicketPK(ticket.getFlightID(), ticket.getTravellerID());
        if(!ticketDao.existsById(ticketPK)) return ticketDao.save(ticket);
        return null;
    }

    /**
     * Update the ticket if it already exists.
     * @param ticket Ticket to update.
     * @return The ticket that was updated, or null if it does not exist (and thus no changes made)
     */
    public Ticket update(Ticket ticket) {
        TicketPK ticketPK = new TicketPK(ticket.getFlightID(), ticket.getTravellerID());
        if(ticketDao.existsById(ticketPK)) return ticketDao.save(ticket);
        return null;
    }

    /**
     * Delete by primary key (traveller and flight id)
     * @param ticketPK Ticket primary key
     * @return True if it was deleted, false if not found.
     */
    public Boolean delete(TicketPK ticketPK) {
        if(ticketDao.existsById(ticketPK)) {
            ticketDao.deleteById(ticketPK);
            return true;
        }
        return false;
    }
}

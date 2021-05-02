package com.smoothstack.utopiaairlines.services;

import com.smoothstack.utopiaairlines.dao.TicketDao;
import com.smoothstack.utopiaairlines.entities.Ticket;
import com.smoothstack.utopiaairlines.entities.TicketPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TicketAdminService {
    @Autowired
    private TicketDao ticketDao;

    List<Ticket> searchByMembershipNumber(String membershipNumber) {
        return ticketDao.findByTraveller_MembershipNumberLike(membershipNumber);
    }

    List<Ticket> searchByDepartureTimeAfter(LocalDateTime flight_departureTime) {
        return ticketDao.findByFlight_DepartureTimeAfter(flight_departureTime);
    }

    List<Ticket> searchByDepartureTimeBefore(LocalDateTime flight_departureTime) {
        return ticketDao.findByFlight_DepartureTimeBefore(flight_departureTime);
    }

    List<Ticket> searchByDepartureTimeRange(LocalDateTime flight_departureTime, LocalDateTime flight_departureTime2) {
        return ticketDao.findByFlight_DepartureTimeBetween(flight_departureTime, flight_departureTime2);
    }

    List<Ticket> searchByOriginCity(String flight_route_origin_city) {
        return ticketDao.findByFlight_Route_Origin_CityLike(flight_route_origin_city);
    }

    List<Ticket> searchByDestinationCity(String flight_route_destination_city) {
        return ticketDao.findByFlight_Route_Destination_CityLike(flight_route_destination_city);
    }

    /**
     * Insert into the database if the ID doesn't already exist.
     * @param ticket Ticket to add.
     * @return The created ticket, or null if it already exists (and thus no changes made)
     */
    Ticket insert(Ticket ticket) {
        TicketPK ticketPK = new TicketPK(ticket.getFlightID(), ticket.getTravellerID());
        if(!ticketDao.existsById(ticketPK)) return ticketDao.save(ticket);
        return null;
    }

    /**
     * Update the ticket if it already exists.
     * @param ticket Ticket to update.
     * @return The ticket that was updated, or null if it does not exist (and thus no changes made)
     */
    Ticket update(Ticket ticket) {
        TicketPK ticketPK = new TicketPK(ticket.getFlightID(), ticket.getTravellerID());
        if(ticketDao.existsById(ticketPK)) return ticketDao.save(ticket);
        return null;
    }

    /**
     * Delete by primary key (traveller and flight id)
     * @param ticketPK Ticket primary key
     * @return True if it was deleted, false if not found.
     */
    Boolean delete(TicketPK ticketPK) {
        if(ticketDao.existsById(ticketPK)) {
            ticketDao.deleteById(ticketPK);
            return true;
        }
        return false;
    }
}

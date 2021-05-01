package com.smoothstack.utopiaairlines.dao;

import com.smoothstack.utopiaairlines.entities.Ticket;
import com.smoothstack.utopiaairlines.entities.TicketPK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Ticket DAO
 * @author Joshua Podhola
 */
@SpringBootTest
@Transactional
class TicketDaoTest {
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private FlightDao flightDao;
    @Autowired
    private TravellerDao travellerDao;
    Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        //ticket.setTravellerID(1);
        //ticket.setFlightID(1);
        ticket.setFlight(flightDao.getOne(1));
        ticket.setTraveller(travellerDao.getOne(1));
        ticket.setIsCancelled(false);
        ticket.setSeatClass("ECONOMY");
        ticketDao.saveAndFlush(ticket);
        ticket = ticketDao.getOne(new TicketPK(ticket.getFlightID(), ticket.getTravellerID()));
    }

    @Test
    void findAllTest() {
        assertNotNull(ticketDao.findAll());
    }

    @Test
    void findByTraveller_MembershipNumberTest() {
        assertTrue(ticketDao.findByTraveller_MembershipNumber(ticket.getTraveller().getMembershipNumber()).contains(ticket));
    }

    @Test
    void findByFlight_DepartureTimeAfterTest() {
    }

    @Test
    void findByFlight_DepartureTimeBeforeTest() {
    }

    @Test
    void findByFlight_DepartureTimeBetweenTest() {
    }

    @Test
    void findByFlight_Route_Origin_CityLikeTest() {
    }

    @Test
    void findByFlight_Route_Destination_CityLikeTest() {
    }
}
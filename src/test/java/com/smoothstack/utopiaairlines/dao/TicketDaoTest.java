package com.smoothstack.utopiaairlines.dao;

import com.smoothstack.utopiaairlines.entities.Flight;
import com.smoothstack.utopiaairlines.entities.Ticket;
import com.smoothstack.utopiaairlines.entities.Traveller;
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
    Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setTravellerID(1);
        ticket.setFlightID(1);
        ticket.setIsCancelled(false);
        ticket.setSeatClass("ECONOMY");
        ticketDao.saveAndFlush(ticket);
        ticketDao.findAll().forEach(System.out::println);
    }

    @Test
    void findAllTest() {
        assertNotNull(ticketDao.findAll());
    }
}
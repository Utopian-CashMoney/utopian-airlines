package com.smoothstack.utopiaairlines.dao;

import com.smoothstack.utopiaairlines.entities.*;
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
    //This is just default JPA functions; is there really a need to test this?
}
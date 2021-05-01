package com.smoothstack.utopiaairlines.dao;

import com.smoothstack.utopiaairlines.entities.Traveller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Traveller DAO
 * @author Joshua Podhola
 */
@SpringBootTest
@Transactional
class TravellerDaoTest {
    @Autowired
    private TravellerDao travellerDao;
    Traveller traveller;

    @BeforeEach
    void setUp() {
        traveller = new Traveller();
        traveller.setFamilyName("TestFamily");
        traveller.setGivenName("TestGiven");
        traveller.setMembershipNumber("TESTMEMNUM1");
        travellerDao.saveAndFlush(traveller);
        travellerDao.findAll().forEach(System.out::println);
    }

    @AfterEach
    void tearDown() {
        //travellerDao.delete(traveller);
    }


    @Test
    void findByGivenNameLikeTest() {
        assertEquals(1, travellerDao.findByGivenNameLike("TestGi%").size());
    }

    @Test
    void findByFamilyNameLikeTest() {
        assertEquals(1, travellerDao.findByFamilyNameLike("TestFa%").size());
    }

    @Test
    void findByMembershipNumberLikeTest() {
        assertEquals(1, travellerDao.findByMembershipNumberLike("TESTME%").size());
    }
}
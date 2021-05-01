package com.smoothstack.utopiaairlines.services;

import com.smoothstack.utopiaairlines.dao.TravellerDao;
import com.smoothstack.utopiaairlines.entities.Traveller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for TravellerAdminService
 * @author Joshua Podhola
 */
@SpringBootTest
class TravellerAdminServiceTest {
    @Autowired
     TravellerAdminService travellerAdminService;

    @MockBean
     TravellerDao travellerDaoMock;

    @BeforeEach
    void beforeEach() {
        ArrayList<Traveller> mockData = new ArrayList<>();
        Traveller t1 = new Traveller();
        t1.setGivenName("given1");
        t1.setId(1);
        t1.setFamilyName("family1");
        t1.setMembershipNumber("mem1");
        mockData.add(t1);
        Traveller t2 = new Traveller();
        t2.setGivenName("given2");
        t2.setId(2);
        t2.setFamilyName("family2");
        t2.setMembershipNumber("mem2");
        mockData.add(t2);

        // Mocks
        Mockito.when(travellerDaoMock.findAll()).thenReturn(mockData);
        Mockito.when(travellerDaoMock.findByGivenNameLike("%given%")).thenReturn(mockData);
        Mockito.when(travellerDaoMock.findByGivenNameLike("%given1%")).thenReturn(
                mockData.stream().filter(traveller -> traveller.getGivenName().equals("given1"))
                        .collect(Collectors.toList())
        );

        Mockito.when(travellerDaoMock.findByFamilyNameLike("%family%")).thenReturn(mockData);
        Mockito.when(travellerDaoMock.findByFamilyNameLike("%family1%")).thenReturn(
                mockData.stream().filter(traveller -> traveller.getFamilyName().equals("family1"))
                        .collect(Collectors.toList())
        );

        Mockito.when(travellerDaoMock.findByMembershipNumberLike("%mem%")).thenReturn(mockData);
        Mockito.when(travellerDaoMock.findByMembershipNumberLike("%mem1%")).thenReturn(
                mockData.stream().filter(traveller -> traveller.getMembershipNumber().equals("mem1"))
                        .collect(Collectors.toList())
        );
    }

    @Test
    void allTest() {
        assertEquals(2, travellerAdminService.all().size());
    }

    @Test
    void searchByGivenNameTest() {
        assertEquals(2, travellerAdminService.searchByGivenName("given").size());
        assertEquals(1, travellerAdminService.searchByGivenName("given1").size());
    }

    @Test
    void searchByFamilyNameTest() {
        assertEquals(2, travellerAdminService.searchByFamilyName("family").size());
        assertEquals(1, travellerAdminService.searchByFamilyName("family1").size());
    }

    @Test
    void searchByMembershipNumberTest() {
        assertEquals(2, travellerAdminService.searchByMembershipNumber("mem").size());
        assertEquals(1, travellerAdminService.searchByMembershipNumber("mem1").size());
    }

    @Test
    void updateGivenNameByMembershipNumberTest() {
        assertTrue(travellerAdminService.updateGivenNameByMembershipNumber("mem1", ""));
        assertFalse(travellerAdminService.updateGivenNameByMembershipNumber("mem3", ""));
        assertNull(travellerAdminService.updateGivenNameByMembershipNumber("mem", ""));
    }

    @Test
    void updateFamilyNameByMembershipNumberTest() {
        assertTrue(travellerAdminService.updateFamilyNameByMembershipNumber("mem1", ""));
        assertFalse(travellerAdminService.updateFamilyNameByMembershipNumber("mem3", ""));
        assertNull(travellerAdminService.updateFamilyNameByMembershipNumber("mem", ""));
    }

    @Test
    void deleteByFamilyNameTest() {
        assertEquals(2, travellerAdminService.deleteByFamilyName("family"));
        assertEquals(1, travellerAdminService.deleteByFamilyName("family1"));
    }

    @Test
    void deleteByMembershipNumberTest() {
        assertEquals(2, travellerAdminService.deleteByMembershipNumber("mem"));
        assertEquals(1, travellerAdminService.deleteByMembershipNumber("mem1"));
    }
}
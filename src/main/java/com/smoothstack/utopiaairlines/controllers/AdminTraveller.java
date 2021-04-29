package com.smoothstack.utopiaairlines.controllers;

import com.smoothstack.utopiaairlines.entities.Traveller;
import com.smoothstack.utopiaairlines.services.TravellerAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/traveller")
public class AdminTraveller {
    @Autowired
    private TravellerAdminService travellerAdminService;

    @GetMapping("/all")
    public List<Traveller> getAll() {
        try {
            return travellerAdminService.all();
        } catch (Exception e) {
            // TODO: What exceptions would really be thrown here?
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/given_name/{given_name}")
    public List<Traveller> searchByGivenName(@PathVariable("given_name") String givenName) {
        try {
            return travellerAdminService.searchByGivenName(givenName);
        } catch (Exception e) {
            // TODO: What exceptions would really be thrown here?
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/family_name/{family_name}")
    public List<Traveller> searchByFamilyName(@PathVariable("family_name") String familyName) {
        try {
            return travellerAdminService.searchByFamilyName(familyName);
        } catch (Exception e) {
            // TODO: What exceptions would really be thrown here?
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/membership_number/{membership_number}")
    public List<Traveller> searchByMembershipNumber(@PathVariable("membership_number") String membershipNumber) {
        try {
            return travellerAdminService.searchByMembershipNumber(membershipNumber);
        } catch (Exception e) {
            // TODO: What exceptions would really be thrown here?
            e.printStackTrace();
            return null;
        }
    }

    // TODO: Map the rest of the services to controllers
}

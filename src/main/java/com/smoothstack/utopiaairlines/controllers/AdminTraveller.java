package com.smoothstack.utopiaairlines.controllers;

import com.smoothstack.utopiaairlines.entities.Traveller;
import com.smoothstack.utopiaairlines.services.TravellerAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Objects;

/**
 * Controllers for administrative Traveller-related CRUD operations.
 * @author Joshua Podhola
 */
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

    @PostMapping("/create")
    public String create(@RequestBody Traveller traveller) {
        try {
            traveller = travellerAdminService.create(traveller);
            return(String.format("Traveller created with ID %d", traveller.getId()));
        } catch (DataIntegrityViolationException e) {
            return Objects.requireNonNull(e.getRootCause()).getLocalizedMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return("Creation failed.");
        }
    }

    @DeleteMapping("/delete_number/{membership_number}")
    public String deleteNumber(@PathVariable("membership_number") String membershipNumber) {
        try {
            Integer result = travellerAdminService.deleteByMembershipNumber(membershipNumber);
            return String.format("Deleted %d traveller(s).", result);
        } catch (Exception e) {
            e.printStackTrace();
            return("Deletion failed.");
        }
    }

    @DeleteMapping("/delete_name/{family_name}")
    public String deleteName(@PathVariable("family_name") String familyName) {
        try {
            Integer result = travellerAdminService.deleteByFamilyName(familyName);
            return String.format("Deleted %d traveller(s).", result);
        } catch (Exception e) {
            e.printStackTrace();
            return("Deletion failed.");
        }
    }

    @PutMapping("/update/{membership_number}")
    public String update(@PathVariable("membership_number") String membershipNumber,
                         @RequestParam(required = false) String familyName,
                         @RequestParam(required = false) String givenName) {
        try {
            if(familyName == null && givenName == null) {
                return("No new values given.");
            }
            if(familyName != null) {
                Boolean res = travellerAdminService.updateFamilyNameByMembershipNumber(membershipNumber, familyName);
                if(res == null) {
                    return("Multiple traveller found with that membership ID. Not updated.");
                }
                if(res && givenName == null) {
                    return("Family name updated.");
                }
                if(!res) {
                    return ("No traveller found with that membership ID.");
                }
            }
            Boolean res = travellerAdminService.updateGivenNameByMembershipNumber(membershipNumber, givenName);
            if(res == null) {
                return("Multiple traveller found with that membership ID. Not updated.");
            }
            if(res && familyName == null) {
                return("Given name updated.");
            }
            if(!res) {
                return ("No traveller found with that membership ID.");
            }
            return("Given and family name updated.");
        } catch (DataIntegrityViolationException e) {
            return Objects.requireNonNull(e.getRootCause()).getLocalizedMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return("Update failed.");
        }
    }
}

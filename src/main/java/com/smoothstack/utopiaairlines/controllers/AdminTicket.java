package com.smoothstack.utopiaairlines.controllers;

import com.smoothstack.utopiaairlines.entities.Ticket;
import com.smoothstack.utopiaairlines.entities.TicketPK;
import com.smoothstack.utopiaairlines.services.TicketAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Controllers for administrative Ticket-related CRUD operations.
 * @author Joshua Podhola
 */
@RestController
@RequestMapping("/admin/ticket")
public class AdminTicket {
    @Autowired
    private TicketAdminService ticketAdminService;

    @GetMapping("/all")
    public List<Ticket> getAll() {
        try {
            return ticketAdminService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/create")
    public String create(@RequestBody Ticket ticket) {
        try {
            Ticket ticket1 = ticketAdminService.insert(ticket);
            if (ticket1 != null) {
                return "Ticket created.";
            }
            return "Ticket already exists.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating ticket.";
        }
    }

    @GetMapping("/search/membership_id")
    public List<Ticket> searchByMembershipNumber(@RequestParam String id) {
        try {
            return ticketAdminService.searchByMembershipNumber(id);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/search/departure_after")
    public List<Ticket> searchByDepartureTimeAfter(@RequestParam LocalDateTime time) {
        try {
            return ticketAdminService.searchByDepartureTimeAfter(time);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/search/departure_before")
    public List<Ticket> searchByDepartureTimeBefore(@RequestParam LocalDateTime time) {
        try {
            return ticketAdminService.searchByDepartureTimeBefore(time);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/search/departure_between")
    public List<Ticket> searchByDepartureTimeRange(@RequestParam LocalDateTime lower, @RequestParam LocalDateTime upper) {
        try {
            return ticketAdminService.searchByDepartureTimeRange(lower, upper);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/search/origin_city")
    public List<Ticket> searchByOriginCity(@RequestParam String origin) {
        try {
            return ticketAdminService.searchByOriginCity(origin);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/search/destination_city")
    public List<Ticket> searchByDestinationCity(@RequestParam String destination) {
        try {
            return ticketAdminService.searchByDestinationCity(destination);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Ticket ticket) {
        try {
            Ticket ticket1 = ticketAdminService.update(ticket);
            if (ticket1 != null) {
                return "Ticket updated";
            }
            return "Ticket does not yet exist.";
        } catch (DataIntegrityViolationException e) {
            return Objects.requireNonNull(e.getRootCause()).getLocalizedMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating ticket.";
        }
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam int travellerID, @RequestParam int flightID) {
        try {
            TicketPK ticketPK = new TicketPK(flightID, travellerID);
            Boolean status = ticketAdminService.delete(ticketPK);
            if (status) {
                return "Ticket deleted.";
            }
            return "Ticket not found.";
        } catch (DataIntegrityViolationException e) {
            return Objects.requireNonNull(e.getRootCause()).getLocalizedMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting ticket.";
        }
    }
}

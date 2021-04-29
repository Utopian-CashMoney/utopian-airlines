package com.smoothstack.utopiaairlines.dao;

import com.smoothstack.utopiaairlines.entities.TicketPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.utopiaairlines.entities.Ticket;


@Repository
public interface TicketDao extends JpaRepository<Ticket, TicketPK> {

}

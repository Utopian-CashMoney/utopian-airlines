package com.smoothstack.utopiaairlines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.utopiaairlines.entities.Ticket;


@Repository
public interface TicketDao extends JpaRepository<Ticket, Integer> {

}

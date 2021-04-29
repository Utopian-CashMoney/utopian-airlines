package com.smoothstack.utopiaairlines.services;

import com.smoothstack.utopiaairlines.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketAdminService {
    @Autowired
    private TicketDao ticketDao;
}

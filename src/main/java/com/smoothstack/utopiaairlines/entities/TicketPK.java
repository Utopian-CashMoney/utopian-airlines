package com.smoothstack.utopiaairlines.entities;


import java.io.Serializable;
import java.util.Objects;

public class TicketPK implements Serializable {
    private static final long serialVersionUID = 5464384774151807355L;
    private Traveller traveller;
    private Flight flight;
}

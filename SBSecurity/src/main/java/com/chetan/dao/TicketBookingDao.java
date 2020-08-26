package com.chetan.dao;

import org.springframework.data.repository.CrudRepository;

import com.chetan.model.Ticket;

public interface TicketBookingDao extends CrudRepository<Ticket, Long>
{

}

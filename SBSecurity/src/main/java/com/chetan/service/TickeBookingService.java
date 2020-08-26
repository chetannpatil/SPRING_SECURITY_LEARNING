package com.chetan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.chetan.dao.TicketBookingDao;
import com.chetan.model.Ticket;

public class TickeBookingService 
{

	@Autowired
	TicketBookingDao ticketBookingDao;

	/*
	 * public void addTicket(Ticket t) { ticketBookingDao.save(t); }
	 */

	public Ticket createTicket(Ticket t)
	{

		return ticketBookingDao.save(t);
	}

	public Ticket getTicketByid(long tickeId) 
	{
		// Optional<Ticket> ticket = ticketBookingDao.findById(tickeId);
		 
		// Ticket t = (Ticket) ticket;
		 
		 Iterable<Ticket> all = ticketBookingDao.findAll();
		 
		 for(Ticket t:all)
		 {
			 if(t.getTicketId() == tickeId)
				 return t;
		 }
		 return null;
	}


}

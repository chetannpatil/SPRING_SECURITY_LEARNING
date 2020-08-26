package com.chetan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.model.Ticket;
import com.chetan.service.TickeBookingService;

@RestController
@RequestMapping(value = "/api")
public class TicketBookingController
{

	@Autowired
	private TickeBookingService tickeBookingService;
	
	@PostMapping(value = "admin/createTicket")
	public Ticket createTicket(@RequestBody Ticket t)
	{
		System.out.println("RestController createTicket");
		//t = new Ticket();
		return tickeBookingService.createTicket(t);
		//System.out.println("tikt = "+t);
		
	}
	
	  @GetMapping("tickets/ticketId/{tickeId}")
	  public Ticket findByID(@PathVariable("tickeId") long tickeId)
	  {
		  
	    return tickeBookingService.getTicketByid(tickeId);
	  }
	 
	
}

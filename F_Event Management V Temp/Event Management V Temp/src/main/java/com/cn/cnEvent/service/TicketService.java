package com.cn.cnEvent.service;
import com.cn.cnEvent.dal.TicketDAL;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketService {
	@Autowired
	TicketDAL ticketDAL;
	
	@Transactional
	public Ticket getTicketById(Long id) {
		Ticket ticket = ticketDAL.getById(id);
		if (ticket == null) {
			throw new NotFoundException("No ticket found with id:  " + id);
		}
		return ticket;
	}
	
	@Transactional
	public List<Ticket> getAllTickets() {
		List<Ticket> ticket = ticketDAL.getAllTickets();
		if (ticket == null) {
			throw new NotFoundException("No ticket found.");
		}
		return ticket;
	}
	
	@Transactional
	public List<Ticket> getTicketByAge(Long age) {
		List<Ticket> ticketList = ticketDAL.getTicketByAge(age);
		if (ticketList == null)
			throw new NotFoundException("No tickets found");
		return ticketList;
	}
}
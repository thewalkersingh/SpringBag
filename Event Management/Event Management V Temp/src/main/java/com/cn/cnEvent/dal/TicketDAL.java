package com.cn.cnEvent.dal;
import com.cn.cnEvent.entity.Ticket;

import java.util.List;

public interface TicketDAL {
	Ticket getById(Long id);
	
	List<Ticket> getTicketByAge(Long age);
	
	List<Ticket> getAllTickets();
}
package com.cn.cnEvent.dal;
import com.cn.cnEvent.entity.Ticket;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TicketDALImpl implements TicketDAL {
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Ticket getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Ticket.class, id);
	}
	
	@Override
	public List<Ticket> getAllTickets() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("FROM Ticket", Ticket.class).getResultList();
	}
	
	@Override
	public List<Ticket> getTicketByAge(Long age) {
		List<Ticket> allTickets = getAllTickets();
		List<Ticket> ticketsByAge = new ArrayList<>();
		for (Ticket ticket : allTickets) {
			if (ticket.getPerson() != null && ticket.getPerson().getAge() < age)
				ticketsByAge.add(ticket);
		}
		return ticketsByAge;
	}
}
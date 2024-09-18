package com.cn.cnEvent.dal;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDALImpl implements EventDAL {
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Event getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Event.class, id);
	}
	
	@Override
	public List<Event> getAllEvents() {
		Session session = entityManager.unwrap(Session.class);
		List<Event> allEvents = session.createQuery("from Event", Event.class).getResultList();
		return allEvents;
	}
	
	@Override
	public String save(Event event) {
		Session session = entityManager.unwrap(Session.class);
		session.save(event);
		return "The event was saved successfully.";
	}
	
	@Override
	public String delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		session.delete(event);
		return "The event was deleted successfully";
	}
	
	@Override
	public String update(Event updateEvent) {
		Session session = entityManager.unwrap(Session.class);
		Event currentEvent = session.get(Event.class, updateEvent.getId());
		currentEvent.setName(updateEvent.getName());
		currentEvent.setDescription(updateEvent.getDescription());
		session.update(currentEvent);
		return "Event is updated successfully";
	}
	
	@Override
	public List<Ticket> getAllTicketsByEventId(Long id) {
		List<Event> eventList = getAllEvents();
		List<Ticket> ticketList = new ArrayList<>();
		for (Event event : eventList) {
			if (event.getId().equals(id)) {
				ticketList.addAll(event.getTickets());
			}
		}
		return ticketList;
	}
	
	@Override
	public List<Ticket> getTicketsByPrice(Long price) {
		List<Event> eventList = getAllEvents();
		List<Ticket> ticketList = new ArrayList<>();
		for (Event event : eventList) {
			for (Ticket ticket : event.getTickets()) {
				if (ticket.getPrice() > 0 && ticket.getPrice() >= price) {
					ticketList.add(ticket);
				}
			}
		}
		return ticketList;
	}
	
	@Override
	public EventScheduleDetail getEventScheduleDetailByEventId(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		return event.getEventScheduleDetail();
	}
}
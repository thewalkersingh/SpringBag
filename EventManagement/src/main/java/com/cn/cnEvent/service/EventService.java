package com.cn.cnEvent.service;
import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class EventService {
	@Autowired
	EventDAL eventDAL;
	@Autowired
	EventScheduleDetailDAL scheduleDetailDAL;
	
	@Transactional
	public Event getEventById(Long id) {
		Event event = eventDAL.getById(id);
		if (event == null) {
			throw new NotFoundException("No event found with id:  " + id);
		}
		return event;
	}
	
	@Transactional
	public List<Event> getAllEvents() {
		List<Event> events = eventDAL.getAllEvents();
		if (events == null) {
			throw new NotFoundException("No events found.");
		}
		return events;
	}
	
	@Transactional
	public String saveEvent(Event newEvent) {
		List<Event> allEvents = getAllEvents();
		for (Event event : allEvents) {
			if (Objects.equals(event.getId(), newEvent.getId())) {
				throw new ElementAlreadyExistException("This event already exist.");
			}
		}
		try {
			return eventDAL.save(newEvent);
		} catch (Exception e) {
			throw new InvalidInputException("The input entity for event is invalid.");
		}
	}
	
	@Transactional
	public String delete(Long id) {
		List<Event> allEvents = getAllEvents();
		boolean isEntityPresent = false;
		for (Event event : allEvents) {
			if (Objects.equals(event.getId(), id)) {
				isEntityPresent = true;
			}
		}
		if (!isEntityPresent) {
			throw new InvalidInputException("This event doesn't exist.");
		}
		try {
			return eventDAL.delete(id);
		} catch (Exception e) {
			throw new InvalidInputException("Error in deleting event.");
		}
	}
	
	@Transactional
	public String update(Event updateEvent) {
		try {
			return eventDAL.update(updateEvent);
		} catch (Exception e) {
			throw new InvalidInputException("Error in updating eventScheduleDetail from event.");
		}
	}
	
	@Transactional
	public EventScheduleDetail getEventScheduleById(Long id) {
		EventScheduleDetail eventScheduleDetail = eventDAL.getEventScheduleDetailByEventId(id);
		if (eventScheduleDetail == null) {
			throw new NotFoundException("Event schedule detail not found for event with id: " + id);
		}
		return eventScheduleDetail;
	}
	
	@Transactional
	public void deleteEventSchedule(long id) {
		List<EventScheduleDetail> allSchedule = scheduleDetailDAL.getAllEventDetails();
		boolean isEntityPresent = false;
		for (EventScheduleDetail detail : allSchedule) {
			if (Objects.equals(detail.getId(), id)) {
				isEntityPresent = true;
			}
		}
		if (!isEntityPresent) {
			throw new InvalidInputException("This EventScheduleDetail doesn't exist.");
		}
		try {
			scheduleDetailDAL.delete(id);
		} catch (Exception e) {
			throw new InvalidInputException("Error in deleting EventScheduleDetail.");
		}
	}
	
	@Transactional
	public List<Event> getEventLocation(String location) {
		return scheduleDetailDAL.getEventLocation(location);
	}
	
	@Transactional
	public List<Ticket> getAllTicketsByEventId(Long id) {
		List<Ticket> tickets = eventDAL.getAllTicketsByEventId(id);
		if (tickets == null)
			throw new NotFoundException("No tickets found");
		return tickets;
	}
	
	@Transactional
	public List<Ticket> getTicketsByPrice(Long price) {
		List<Ticket> tickets = eventDAL.getTicketsByPrice(price);
		if (tickets == null)
			throw new NotFoundException("No tickets found");
		return tickets;
	}
}
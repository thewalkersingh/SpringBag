package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	EventService eventService;

	@GetMapping("/{id}")
	public Event getEventById(@PathVariable Long id) {
		return eventService.getEventById(id);
	}

	@GetMapping("/all")
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();
	}

	@PostMapping("/save")
	public String saveEvent(@RequestBody Event event) {
		return eventService.saveEvent(event);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable Long id) {
		return eventService.delete(id);
	}

	@PutMapping("/update")
	public String updateEvent(@RequestBody Event updateEvent) {
		return eventService.update(updateEvent);
	}

	@GetMapping("/eventScheduleDetail/{id}")
	public EventScheduleDetail getEventScheduleById(@PathVariable Long id) {
		return eventService.getEventScheduleById(id);
	}

	@DeleteMapping("/delete/eventScheduleDetail/{id}")
	public String deleteEventScheduleDetails(@PathVariable Long id) {
		eventService.deleteEventSchedule(id);
		return "The eventSchedule was deleted successfully";
	}

	@GetMapping("/location/{location}")
	public List<Event> getEventLocation(@PathVariable String location) {
		return eventService.getEventLocation(location);
	}

	@GetMapping("/allTickets/{id}")
	public List<Ticket> getAllTicketsByEventId(@PathVariable Long id) {
		return eventService.getAllTicketsByEventId(id);
	}

	@GetMapping("/tickets/PriceGreaterThan/{price}")
	public List<Ticket> getTicketsByPrice(@PathVariable Long price) {
		return eventService.getTicketsByPrice(price);
	}
}
package com.cn.cnEvent.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "eventschedulesetail_id")
	@JsonManagedReference
	private EventScheduleDetail eventScheduleDetail;
	@OneToMany(mappedBy = "events", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Ticket> tickets;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "event_speaker", joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "speaker_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = {"event_id", "speaker_id"})})
	private List<Speaker> speakers = new ArrayList<>();
	
	public Event() {
	}
	
	public Event(
			String name, String description, EventScheduleDetail eventScheduleDetail, List<Ticket> tickets,
			List<Speaker> speakers) {
		this.name = name;
		this.description = description;
		this.eventScheduleDetail = eventScheduleDetail;
		this.tickets = tickets;
		this.speakers = speakers;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public EventScheduleDetail getEventScheduleDetail() {
		return eventScheduleDetail;
	}
	
	public void setEventScheduleDetail(EventScheduleDetail eventScheduleDetail) {
		this.eventScheduleDetail = eventScheduleDetail;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public List<Speaker> getSpeakers() {
		return speakers;
	}
	
	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
}
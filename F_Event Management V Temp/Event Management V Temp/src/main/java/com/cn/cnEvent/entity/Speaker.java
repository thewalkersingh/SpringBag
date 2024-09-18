package com.cn.cnEvent.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "speaker")
public class Speaker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private Long experience;
	@ManyToMany(mappedBy = "speakers")
	private List<Event> events;
	
	public Speaker() {
	}
	
	public Speaker(Long id, String name, Long experience, List<Event> events) {
		this.id = id;
		this.name = name;
		this.experience = experience;
		this.events = events;
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
	
	public Long getExperience() {
		return experience;
	}
	
	public void setExperience(Long experience) {
		this.experience = experience;
	}
	
	public List<Event> getEvents() {
		return events;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
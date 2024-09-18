package com.cn.cnEvent.dal;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class EventScheduleDetailDALImpl implements EventScheduleDetailDAL {
	@Autowired
	EntityManager entityManager;
	@Autowired
	EventDAL eventDAL;
	
	@Override
	public EventScheduleDetail getDetailsById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		EventScheduleDetail detail = session.get(EventScheduleDetail.class, id);
		return detail;
	}
	
	@Override
	public List<EventScheduleDetail> getAllEventDetails() {
		Session session = entityManager.unwrap(Session.class);
		List<EventScheduleDetail> detailList = session
				.createQuery("from EventScheduleDetail ", EventScheduleDetail.class).getResultList();
		return detailList;
	}
	
	@Override
	public String save(EventScheduleDetail event) {
		Session session = entityManager.unwrap(Session.class);
		session.save(event);
		return "Saved successfully";
	}
	
	@Override
	public void delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		EventScheduleDetail eventScheduleDetail = session.get(EventScheduleDetail.class, id);
		session.delete(eventScheduleDetail);
	}
	
	@Override
	public List<Event> getEventLocation(String location) {
		List<Event> events = eventDAL.getAllEvents();
		List<Event> eventByLocation = new ArrayList<>();
		for (Event event : events) {
			if (event.getEventScheduleDetail() != null
			    && event.getEventScheduleDetail().getLocation().equalsIgnoreCase(location)) {
				eventByLocation.add(event);
			}
		}
		return eventByLocation;
	}
}
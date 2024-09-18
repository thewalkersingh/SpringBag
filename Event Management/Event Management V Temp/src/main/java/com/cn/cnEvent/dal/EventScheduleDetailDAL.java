package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;

import java.util.List;

public interface EventScheduleDetailDAL {
	EventScheduleDetail getDetailsById(Long id);

	List<EventScheduleDetail> getAllEventDetails();

	String save(EventScheduleDetail event);

	void delete(Long id);

	List<Event> getEventLocation(String location);
}
package com.cn.cnEvent.service;
import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class EventScheduleDetailService {
	@Autowired
	EventScheduleDetailDAL detailDAL;
	
	@Transactional
	public EventScheduleDetail getEventDetailsById(long id) {
		EventScheduleDetail detail = detailDAL.getDetailsById(id);
		if (detail == null)
			throw new NotFoundException("There is no Details of this event");
		return detail;
	}
	
	@Transactional
	public List<EventScheduleDetail> getAllEventsDetails() {
		List<EventScheduleDetail> detailList = detailDAL.getAllEventDetails();
		if (detailList.isEmpty())
			throw new NotFoundException("There is no Details of this event");
		return detailList;
	}
	
	@Transactional
	public String save(EventScheduleDetail newDetail) {
		List<EventScheduleDetail> allEventDetails = getAllEventsDetails();
		for (EventScheduleDetail eve : allEventDetails) {
			if (Objects.equals(eve.getId(), newDetail.getId()))
				throw new ElementAlreadyExistException("Event details already exists");
		}
		return detailDAL.save(newDetail);
	}
}
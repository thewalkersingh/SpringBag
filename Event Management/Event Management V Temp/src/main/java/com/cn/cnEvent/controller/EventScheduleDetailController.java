package com.cn.cnEvent.controller;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventScheduleDetail")
public class EventScheduleDetailController {
	@Autowired
	EventScheduleDetailService eventScheduleDetailService;
	
	@GetMapping("/{id}")
	public EventScheduleDetail getDetailsById(@PathVariable Long id) {
		return eventScheduleDetailService.getEventDetailsById(id);
	}
	
	@GetMapping("/all")
	public List<EventScheduleDetail> getAllEventDetails() {
		return eventScheduleDetailService.getAllEventsDetails();
	}
	
	@PostMapping("/save")
	public String save(@RequestBody EventScheduleDetail event) {
		return eventScheduleDetailService.save(event);
	}
}
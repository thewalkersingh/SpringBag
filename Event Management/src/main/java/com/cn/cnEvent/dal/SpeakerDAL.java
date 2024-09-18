package com.cn.cnEvent.dal;
import com.cn.cnEvent.entity.Speaker;

import java.util.List;

public interface SpeakerDAL {
	Speaker getSpeakerById(Long id);
	
	String saveSpeaker(Speaker speaker);
	
	List<Speaker> getAllSpeakers();
	
	List<Speaker> getSpeakerByEventAndExperience(Long eventCount, Long experience);
	
	void addSpeakerToEvent(Long eventId, Long speakerId);
}
package com.cn.cnEvent.service;
import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpeakerService {
	@Autowired
	SpeakerDAL speakerDAL;
	@Autowired
	EventDAL eventDAL;
	
	@Transactional
	public Speaker getSpeakerById(Long id) {
		Speaker speaker = speakerDAL.getSpeakerById(id);
		if (speaker == null) throw new NotFoundException("No speaker found with this id");
		return speaker;
	}
	
	@Transactional
	public void saveSpeakerEvent(Long eventId, Long speakerId) {
		try {
			speakerDAL.addSpeakerToEvent(eventId, speakerId);
		} catch (Exception e) {
			throw new ElementAlreadyExistException("Speaker and Event are either already linked, " +
			                                       "or one of the entities doesn't exist");
		}
	}
	
	@Transactional
	public String saveSpeaker(Speaker newSpeaker) {
		List<Speaker> allSpeakers = getAllSpeaker();
		for (Speaker speaker : allSpeakers) {
			if (speaker.getId().equals(newSpeaker.getId())) {
				throw new ElementAlreadyExistException("This speaker already exist.");
			}
		}
		try {
			return speakerDAL.saveSpeaker(newSpeaker);
		} catch (Exception e) {
			throw new InvalidInputException("The input entity for speaker is invalid.");
		}
	}
	
	@Transactional
	public List<Speaker> getAllSpeaker() {
		List<Speaker> speakersList = speakerDAL.getAllSpeakers();
		if (speakersList.isEmpty()) throw new NotFoundException("No List of speakers found");
		return speakersList;
	}
	
	@Transactional
	public List<Speaker> getSpeakerByEventAndExperience(Long eventCount, Long experience) {
		List<Speaker> speakers = speakerDAL.getSpeakerByEventAndExperience(eventCount, experience);
		if (speakers == null) {
			throw new NotFoundException("No speakers found.");
		}
		return speakers;
	}
}
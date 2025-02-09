package com.codingninjas.EVotingSystem.services;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {
	@Autowired
	private ElectionRepository electionRepository;
	
	public void addElection(Election election) {
		electionRepository.save(election);
	}
	
	public List<Election> getAllElections() {
		return electionRepository.findAll();
	}
	
	public Election findElectionByName(String electionName) {
		return electionRepository.findByName(electionName).orElse(null);
	}
}
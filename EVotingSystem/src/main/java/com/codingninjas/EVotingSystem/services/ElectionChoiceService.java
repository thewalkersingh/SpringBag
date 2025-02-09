package com.codingninjas.EVotingSystem.services;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionChoiceService {
	@Autowired
	private ElectionChoiceRepository electionChoiceRepository;
	
	public void addElectionChoice(ElectionChoice electionChoice) {
		electionChoiceRepository.save(electionChoice);
	}
	
	public List<ElectionChoice> getAllElectionChoices() {
		return electionChoiceRepository.findAll();
	}
	
	public Long getTotalNumberOfChoicesByElection(Election election) {
		return electionChoiceRepository.countByElection(election);
	}
	
	public ElectionChoice findElectionChoiceByNameAndElection(String choice, Election election) {
		return electionChoiceRepository.findByNameAndElection(choice, election).orElseThrow();
	}
	
	public ElectionChoice findElectionChoiceWithMaxVotes(Election election) {
		return electionChoiceRepository.findElectionChoiceWithMaxVotes(election.getId());
	}
}
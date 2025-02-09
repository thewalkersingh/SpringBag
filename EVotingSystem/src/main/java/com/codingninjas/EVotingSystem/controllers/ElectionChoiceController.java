package com.codingninjas.EVotingSystem.controllers;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.services.ElectionChoiceService;
import com.codingninjas.EVotingSystem.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ElectionChoiceController {
	@Autowired
	private ElectionChoiceService electionChoiceService;
	@Autowired
	private ElectionService electionService;
	
	@PostMapping("/add/electionChoice")
	public void addElectionChoice(@RequestBody ElectionChoice electionChoice) {
		ElectionChoice updateElectionChoice = new ElectionChoice();
		Election election = electionService.findElectionByName(electionChoice.getElection().getName());
		updateElectionChoice.setName(electionChoice.getName());
		updateElectionChoice.setElection(election);
		electionChoiceService.addElectionChoice(updateElectionChoice);
	}
	
	@GetMapping("/get/electionChoices")
	public List<ElectionChoice> getAllElectionChoices() {
		return electionChoiceService.getAllElectionChoices();
	}
	
	@PostMapping("/count/election/choices")
	public Long getTotalNumberOfChoicesByElection(@RequestBody Election election) {
		Election updatedElection = electionService.findElectionByName(election.getName());
		return electionChoiceService.getTotalNumberOfChoicesByElection(updatedElection);
	}
	@PostMapping("/winner/election")
	public ElectionChoice getWinnerByElection(@RequestBody Election election) {
		Election updatedWinner = electionService.findElectionByName(election.getName());
		return electionChoiceService.findElectionChoiceWithMaxVotes(updatedWinner);
	}
}
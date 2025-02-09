package com.codingninjas.EVotingSystem.controllers;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.services.ElectionChoiceService;
import com.codingninjas.EVotingSystem.services.ElectionService;
import com.codingninjas.EVotingSystem.services.UserService;
import com.codingninjas.EVotingSystem.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class VoteController {
	@Autowired
	private VoteService voteService;
	@Autowired
	private UserService userService;
	@Autowired
	private ElectionService electionService;
	@Autowired
	private ElectionChoiceService electionChoiceService;
	
	@GetMapping("/get/votes")
	public List<Vote> getAllVotes() {
		return voteService.getAllVotes();
	}
	
	@PostMapping("/add/vote")
	public void addVote(@RequestBody Vote vote) {
		Vote updatedVote = new Vote();
		User user = userService.findUserByName(vote.getUser().getName());
		Election election = electionService.findElectionByName(vote.getElection().getName());
		ElectionChoice electionChoice = electionChoiceService
				.findElectionChoiceByNameAndElection(vote.getElectionChoice().getName(), election);
		updatedVote.setElection(election);
		updatedVote.setElectionChoice(electionChoice);
		updatedVote.setUser(user);
		voteService.addVote(updatedVote);
	}
	
	@GetMapping("/count/votes")
	public Long getTotalVotesByElection() {
		return voteService.countTotalVotes();
	}
	
	@PostMapping("/count/election/votes")
	public Long getTotalNumberOfVotesByElection(@RequestBody Election election) {
		Election updatedElection = electionService.findElectionByName(election.getName());
		return voteService.countVotesByElection(updatedElection);
	}
	
	
}
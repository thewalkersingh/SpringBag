package com.codingninjas.EVotingSystem.services;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
	@Autowired
	private VoteRepository voteRepository;
	
	public void addVote(Vote vote) {
		voteRepository.save(vote);
	}
	
	public List<Vote> getAllVotes() {
		return voteRepository.findAll();
	}
	
	public Long countTotalVotes() {
		return voteRepository.countTotalVotes();
	}
	
	public Long countVotesByElection(Election updatedElection) {
		return voteRepository.countVotesByElection(updatedElection);
	}
}
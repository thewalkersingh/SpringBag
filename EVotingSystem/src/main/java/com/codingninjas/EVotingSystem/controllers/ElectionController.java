package com.codingninjas.EVotingSystem.controllers;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ElectionController {
	@Autowired
	private ElectionService electionService;
	
	@PostMapping("/add/election")
	public void addElection(@RequestBody Election election) {
		electionService.addElection(election);
	}
	
	@GetMapping("/get/elections")
	public List<Election> getAllElections() {
		return electionService.getAllElections();
	}
}
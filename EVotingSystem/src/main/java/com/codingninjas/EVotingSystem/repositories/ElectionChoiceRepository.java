package com.codingninjas.EVotingSystem.repositories;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice, Long> {
	@Query("Select count(ec) From ElectionChoice ec where ec.election = :election")
	Long countByElection(@Param("election") Election election);
	
	Optional<ElectionChoice> findByNameAndElection(String electionChoiceName, Election election);
	
	@Query(value = "SELECT ec.* FROM election_choice ec JOIN vote v ON ec.id = v.election_choice_id WHERE " +
	               "ec.election_id = :electionId group by ec.id order by count(v.id) desc limit 1", nativeQuery =
			true)
	ElectionChoice findElectionChoiceWithMaxVotes(Long electionId);
}
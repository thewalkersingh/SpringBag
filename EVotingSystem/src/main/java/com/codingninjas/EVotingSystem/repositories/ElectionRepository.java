package com.codingninjas.EVotingSystem.repositories;
import com.codingninjas.EVotingSystem.entities.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElectionRepository extends JpaRepository<Election, Long> {
	Optional<Election> findByName(String electionName);
}
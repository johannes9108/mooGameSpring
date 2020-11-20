package jh.mooGameRest.mooGameRest.integration;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jh.mooGameRest.mooGameRest.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	Optional<Player> findByName(String name);
	
	
	
}

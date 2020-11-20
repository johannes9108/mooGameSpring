package jh.mooGameRest.mooGameRest.integration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jh.mooGameRest.mooGameRest.model.MooResult;
import jh.mooGameRest.mooGameRest.model.Player;
import jh.mooGameRest.mooGameRest.model.PlayerAverage;

public interface MooResultRepository extends JpaRepository<MooResult, Integer> {
	@Query("SELECT"
			+ " new jh.mooGameRest.mooGameRest.model.PlayerAverage(p.name,AVG(r.result) as Average) "
			+ "FROM "
			+ " MooResult r, Player p "
			+ "JOIN "
			+ "	p.mooResults r "
			+ "GROUP BY "
			+ "	p.name "
			+ "ORDER BY "
			+ " Average ASC")
	List<PlayerAverage> test();
	
//	 @Query("SELECT " +
//	           "    new jh.mooGameRest.mooGameRest.model.PlayerAverage(p.name, COUNT(r.result)) " +
//	           "FROM " +
//	           "    Players v " +
//	           " join fetch" +
//	           "GROUP BY " +
//	           "    v.answer")
//	    List<PlayerAverage> findSurveyCount();
	
}

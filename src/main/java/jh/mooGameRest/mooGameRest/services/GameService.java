package jh.mooGameRest.mooGameRest.services;

import java.util.List;
import java.util.Optional;

import jh.mooGameRest.mooGameRest.model.GameModelObject;
import jh.mooGameRest.mooGameRest.model.Player;
import jh.mooGameRest.mooGameRest.model.PlayerAverage;
import jh.mooGameRest.mooGameRest.model.ServiceResult;

public interface GameService{

	ServiceResult generateProgress(String guess);
	public Optional<Player> getPlayerByName(String name);
	void addNewResultToDB(GameModelObject model);
	List<PlayerAverage> getTopTen();
}

package jh.mooGameRest.mooGameRest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import jh.mooGameRest.mooGameRest.integration.MooResultRepository;
import jh.mooGameRest.mooGameRest.integration.PlayerRepository;
import jh.mooGameRest.mooGameRest.model.GameModelObject;
import jh.mooGameRest.mooGameRest.model.MooResult;
import jh.mooGameRest.mooGameRest.model.Player;
import jh.mooGameRest.mooGameRest.model.PlayerAverage;
import jh.mooGameRest.mooGameRest.model.ServiceResult;
import jh.mooGameRest.mooGameRest.utility.ResponseObject;

@Component
@SessionScope
public class GameServiceImpl implements GameService {

	@Autowired
	private MooGame game;
	
	
	private Player player = null;
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private MooResultRepository mooResultRepository;
	
	List<ResponseObject> listOfResponses;
	
	@PostConstruct
	void init() {
		game.generateAnswer();
	}
	
	public Optional<Player> getPlayerByName(String name){
		
		Optional<Player> p  = playerRepository.findByName(name);
		if(p.isPresent()) {
			player = p.get();
			return p;
		}
		return Optional.empty();
	}


	@Override
	public ServiceResult generateProgress(String guess) {
		System.out.println("Correct answer:" + game.getGoal());
		boolean winFlag = false;
//		Optional<PlayerAverage> topTenList = Optional.empty();
		int guesses = game.getGuesses();
		if(game.validate(guess)) {
			
			if(guesses==0) {
				listOfResponses = new ArrayList<ResponseObject>();
			}
			String progress = game.generateProgress(guess);
			game.setGuesses(++guesses);
			listOfResponses.add(new ResponseObject(guess, progress,game.getGuesses()));
			if(progress.equals(game.getWinCondition())) {
				System.out.println("I win");
				game.generateAnswer();
				guesses = game.getGuesses();
				game.setGuesses(0);
				winFlag = true;
			}
			return new ServiceResult(Optional.of(listOfResponses), winFlag,guesses);
		}
		else 
			return new ServiceResult(Optional.empty(), winFlag,guesses);
	
	}

	@Override
	public void addNewResultToDB(GameModelObject model) {
		System.out.println("AddNewResultTODB:");
		System.out.println(model);
		MooResult newResult = new MooResult();
		newResult.setResult(model.getNoOfGuesses());
		System.out.println("NR: " + newResult.getResult());
		player.addNewResult(newResult);
		System.out.println(player);
		playerRepository.save(player);
	}

	@Override
	public List<PlayerAverage> getTopTen() {
		List<PlayerAverage> c = mooResultRepository.test();
		System.out.println(c);
		
		return c;
	}

	

}

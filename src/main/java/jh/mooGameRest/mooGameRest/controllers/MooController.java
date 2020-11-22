package jh.mooGameRest.mooGameRest.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jh.mooGameRest.mooGameRest.model.GameModelObject;
import jh.mooGameRest.mooGameRest.model.Player;
import jh.mooGameRest.mooGameRest.model.PlayerAverage;
import jh.mooGameRest.mooGameRest.model.ServiceResult;
import jh.mooGameRest.mooGameRest.services.GameService;

@Controller
@RequestMapping("/moo")
//@SessionAttributes("model")
public class MooController {

	@Autowired
	GameService gameSerivce;
	
	@GetMapping("play")
	public String homeScreen(Model model) {
		GameModelObject gameModelObject = new GameModelObject();
		model.addAttribute("model", gameModelObject);
		return "homeScreen";
	}
	
	@PostMapping("play")
	public String startGame(@Valid @ModelAttribute GameModelObject gameModelObject, BindingResult bindingResult, Model model) {
		System.out.println(gameModelObject.getName());
		System.out.println(bindingResult);
		
		model.addAttribute("model", gameModelObject);
		
		if(bindingResult.hasErrors()) {
			System.out.println("Error found");
			model.addAttribute("errorMessage", "Validation Error");
			return "homeScreen";
		}
		else {
			// Check against player DB
			Optional<Player> player = gameSerivce.getPlayerByName(gameModelObject.getName());
			if(player.isPresent()) {
				System.out.println("Player found");
				return "playingScreen";
			}
			else {
				System.out.println("No player found");
				model.addAttribute("errorMessage", "Player Not Found Error");
				return "homeScreen";
			}
			
			
		}
	}
	@PostMapping("playing")
	public String playing(@ModelAttribute GameModelObject gameModelObject,BindingResult bindingResult, Model model) {
		ServiceResult serviceResult = gameSerivce.generateProgress(gameModelObject.getGuess());
		
		gameModelObject.setNoOfGuesses(serviceResult.getGuesses());
		if(serviceResult.getResponseList().isPresent()) {
			gameModelObject.setResponseHistory(serviceResult.getResponseList().get());
		}
		else {
			model.addAttribute("errorMessage","Malformed Format! Use XXXX");
		}
		
		model.addAttribute("model", gameModelObject);
		
		if(serviceResult.isWinFlag()) {
			gameSerivce.addNewResultToDB(gameModelObject);
			List<PlayerAverage> topTenList = gameSerivce.getTopTen();
			//Display to user
			//New Game yes or no?
			model.addAttribute("topTenList",topTenList);
			return "gameFinished";
		}
		else {
			return "playingScreen";
		}
	}
	
	
}

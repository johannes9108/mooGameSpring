package jh.mooGameRest.mooGameRest.restController;

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
	public ModelAndView homeScreen() {
		
		GameModelObject model = new GameModelObject();
		
		return new ModelAndView("homeScreen","model",model);
	}
	
	@PostMapping("play")
	public ModelAndView startGame(@Valid @ModelAttribute GameModelObject model, BindingResult bindingResult) {
		System.out.println(model.getName());
		System.out.println(bindingResult);
		
		
		if(bindingResult.hasErrors()) {
			System.out.println("Error found");
			return new ModelAndView("homeScreen","model",model);
		}
		else {
			// Check against player DB
			Optional<Player> player = gameSerivce.getPlayerByName(model.getName());
			if(player.isPresent()) {
				System.out.println("Player found");
				return new ModelAndView("playingScreen", "model",model);
			}
			else {
				System.out.println("No player found");
				return new ModelAndView("homeScreen","model",model);
			}
			
			
		}
	}
	@PostMapping("playing")
	public ModelAndView playing(@ModelAttribute GameModelObject model,BindingResult bindingResult) {
		ServiceResult serviceResult = gameSerivce.generateProgress(model.getGuess());
		
		model.setNoOfGuesses(serviceResult.getGuesses());
		if(serviceResult.getResponseList().isPresent()) {
			model.setMessage(null);
			model.setResponseHistory(serviceResult.getResponseList().get());
		}
		else {
			model.setMessage("Malformed Format! Use XXXX");
		}
		if(serviceResult.isWinFlag()) {
			gameSerivce.addNewResultToDB(model);
			List<PlayerAverage> topTenList = gameSerivce.getTopTen();
			//Display to user
			//New Game yes or no?
			System.out.println("Game finished");
			return new ModelAndView("gameFinished","model",topTenList);
		}
		else {
			
			return new ModelAndView("playingScreen","model",model);
		}
	}
	
//	@GetMapping("play")
//	public List<ResponseObject> home(@RequestParam(value = "guess",defaultValue = "") String guess) {
//		
//			Optional<List<ResponseObject>> serviceResult = gameSerivce.generateProgress(guess);
//			if(!serviceResult.isPresent()) {
//				List<ResponseObject> errorList = new ArrayList<ResponseObject>();
//				errorList.add(new ResponseObject("Malformed guess use format XXXX!", "----",-1));
//				return errorList ;
//			}
//			return serviceResult.get();
//	}
//	
//	@PostMapping("playMoo/{guess}")
//	public List<ResponseObject> postHome(@PathVariable(value = "guess") String guess) {
//		
//		Optional<List<ResponseObject>> serviceResult = gameSerivce.generateProgress(guess);
//		if(!serviceResult.isPresent()) {
//			List<ResponseObject> errorList = new ArrayList<ResponseObject>();
//			errorList.add(new ResponseObject("Malformed guess use format XXXX!", "----",-1));
//			return errorList ;
//		}
//		return serviceResult.get();
//}
	
}

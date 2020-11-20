package jh.mooGameRest.mooGameRest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jh.mooGameRest.mooGameRest.model.UserModel;

@Controller
@RequestMapping("/thymeleafMoo")
public class ThymeleafController {

	@GetMapping("/")
	public ModelAndView home() {
		
		String username = "johannes";
		
		List<String> model = new ArrayList<>();
		model.add("Hejsan");
		model.add("Johannes");
		
		Map<String,Object> model2 = new HashMap<String, Object>();
		model2.put("username", "Johannes Hedman");
		model2.put("age", 15);
		
		
		
		return new ModelAndView("index","guess",0);
		
	}
	
	@PostMapping("/")
	public ModelAndView pickAName(int guess, Model model) {
		System.out.println("Guess:" + guess);
		
		
		
		return new ModelAndView("playingScreen");
		
	}
	
	
}

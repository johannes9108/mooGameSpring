package jh.mooGameRest.mooGameRest.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class MooGame extends AbstractGame{
	
	{
		this.winCondition = "BBBB,";
	}
	
	@Override
	public void generateAnswer(){
		String goal = "";
		for (int i = 0; i < 4; i++){
			int random = (int) (Math.random() * 10);
			String randomDigit = "" + random;
			while (goal.contains(randomDigit)){
				random = (int) (Math.random() * 10);
				randomDigit = "" + random;
			}
			goal = goal + randomDigit;
		}
		this.goal = goal;
	}
	
	@Override
	public String generateProgress(String guess) {
		System.out.println("generateProgress(String guess):" + goal);
		int cows = 0, bulls = 0;
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++ ) {
				if (getGoal().charAt(i) == guess.charAt(j)){
					if (i == j) {
						bulls++;
					} else {
						cows++;
					}
				}
			}
		}
		String result = "";
		for (int i = 0; i < bulls; i++){
			result = result + "B";
		}
		result = result + ",";
		for (int i = 0; i < cows; i++){
			result = result + "C";
		}
		System.out.println("Result:"+result);
		return result;
	
	}

	@Override
	public boolean validate(String guess) {
		boolean ok = guess.matches("[0-9]{4}");
		return ok;
	}

	

}

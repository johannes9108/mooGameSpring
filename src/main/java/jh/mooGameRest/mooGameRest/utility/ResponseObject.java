package jh.mooGameRest.mooGameRest.utility;

public class ResponseObject {

	String guess;
	String answer;
	int guesses;
	public int getGuesses() {
		return guesses;
	}
	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}
	public String getGuess() {
		return guess;
	}
	public void setGuess(String guess) {
		this.guess = guess;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public ResponseObject(String guess, String answer, int guesses) {
		super();
		this.guess = guess;
		this.answer = answer;
		this.guesses = guesses;
	}
	@Override
	public String toString() {
		return "Guess " + guesses + ": guess=" + guess + ", answer=" + answer;
	}
	
	

	
	
}

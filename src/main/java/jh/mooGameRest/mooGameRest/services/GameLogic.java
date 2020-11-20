package jh.mooGameRest.mooGameRest.services;

public interface GameLogic {
	
	public abstract void generateAnswer();
	public abstract String generateProgress(String guess);
	public abstract boolean validate(String guess);

}
package jh.mooGameRest.mooGameRest.model;

import java.util.List;
import java.util.Optional;

import jh.mooGameRest.mooGameRest.utility.ResponseObject;

public class ServiceResult {
	
	private Optional<List<ResponseObject>> responseList;
	
	private boolean winFlag;
	
	private int guesses;

	public int getGuesses() {
		return guesses;
	}

	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}

	public Optional<List<ResponseObject>> getResponseList() {
		return responseList;
	}

	public boolean isWinFlag() {
		return winFlag;
	}

	public ServiceResult(Optional<List<ResponseObject>> responseList, boolean winFlag, int guesses) {
		super();
		this.responseList = responseList;
		this.winFlag = winFlag;
		this.guesses = guesses;
	}

	
	

}

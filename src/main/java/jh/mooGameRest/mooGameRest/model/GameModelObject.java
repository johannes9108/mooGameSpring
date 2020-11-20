package jh.mooGameRest.mooGameRest.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import jh.mooGameRest.mooGameRest.utility.ResponseObject;

public class GameModelObject {
	
	@NotEmpty
	private String name;
	
	private String guess;
	
	private String message;
	
	private List<ResponseObject> responseHistory = new ArrayList<ResponseObject>();
	
	private int noOfGuesses;
	
	
	public int getNoOfGuesses() {
		return noOfGuesses;
	}
	public void setNoOfGuesses(int noOfGuesses) {
		this.noOfGuesses = noOfGuesses;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGuess() {
		return guess;
	}
	public void setGuess(String guess) {
		this.guess = guess;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ResponseObject> getResponseHistory() {
		return responseHistory;
	}
	public void setResponseHistory(List<ResponseObject> responseHistory) {
		this.responseHistory = responseHistory;
	}
	@Override
	public String toString() {
		return "GameModelObject [name=" + name + ", guess=" + guess + ", message=" + message + ", noOfGuesses="
				+ noOfGuesses + "]";
	}

//	private StringBuilder builder = new StringBuilder();
	
//	public void addResponse(ResponseObject newResponse) {
//		responseHistory.add(newResponse);
//	}
//	public String getResponseHistoryString() {
//		for(ResponseObject response: responseHistory)
//			builder.append(response.toString()+"\n");
//		return builder.toString();
//	}
//	public void cleanReponseHistory() {
//		builder = new StringBuilder();
//		responseHistory.clear();
//	}
	
	
	

}

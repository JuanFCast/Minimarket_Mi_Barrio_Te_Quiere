package model;

import java.time.LocalDate;
import java.util.ArrayList;
import exceptions.NoPicoCedulaException;
import exceptions.NoWithTIException;


public class Mini_Market {
	private ArrayList<User> userRegistered;
	private int attemps;

	public Mini_Market() {
		userRegistered=new ArrayList<User>();
		attemps=0;
	}

	public ArrayList<User> getPeopleRegistered() {
		return userRegistered;
	}

	public void setUserRegistered(ArrayList<User> userRegistered) {
		this.userRegistered = userRegistered;
	}

	public int getAttemps() {
		return attemps;
	}

	public void setAttemps(int attemps) {
		this.attemps = attemps;
	}
		
	
	public void register(Type type, String numID) throws NoWithTIException, NoPicoCedulaException{
		attemps++;
		if(type==Type.TI) {
			throw new NoWithTIException();
		}
		switch(type) {
		case CC:
			break;
		case PP:
			break;
		case CE:
			break;
		default:
			break;
		}
		
		int secondLastNumb=Character.getNumericValue(numID.charAt(numID.length()-2));
		int day= LocalDate.now().getDayOfMonth(); 
		
		if((secondLastNumb%2==0 && day%2==0) || (secondLastNumb%2!=0 && day%2!=0)) {
			throw new NoPicoCedulaException();
		}
		
		addUser(type, numID);
	}
	
	public void addUser(Type type, String numID) {
		User user=new User(type, numID);
		userRegistered.add(user);
	}
}

package input;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Team{
	
	private final SimpleStringProperty teamName;
	private final SimpleIntegerProperty matchNumber;
	
	//Default Values
	public Team(){
		matchNumber = new SimpleIntegerProperty(0);
		teamName = new SimpleStringProperty("");
	}
	
	public Team(int matchNumber, String teamName){
		this.teamName = new SimpleStringProperty(teamName);
		this.matchNumber = new SimpleIntegerProperty(matchNumber);
	}
	
	public int getMatchNumber(){
		return matchNumber.get();
	}
	
	public String getTeamName(){
		return teamName.get();
	}
	
	public void setMatchNumber(int matchNumber){
		this.matchNumber.set(matchNumber);
	}
	
	public void setTeams(String teamName){
		this.teamName.set(teamName);
	}
}

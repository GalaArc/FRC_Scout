package input;

public class InputTeams {
	
	String teams;
	
	public InputTeams(){
		this.teams = "";
		
	}
	
	public InputTeams(String teams){
		this.teams = teams;
		
	}
	
	public String getTeams(){
		return teams;
	}
	
	public void setTeams(String teams){
		this.teams = teams;
	}
}

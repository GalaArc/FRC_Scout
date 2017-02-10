package input;

public class InputMatches {
	
	int matchNumber;
	
	
	public InputMatches(){
		matchNumber = 0;
		
	}
	
	public InputMatches(int matchNumber){
		this.matchNumber = matchNumber;
	}
	
	public double getMatch(){
		return matchNumber;
	}
	
	public void setMatch(int matchNumber){
		this.matchNumber = matchNumber;
	}
}

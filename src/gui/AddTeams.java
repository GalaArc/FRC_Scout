package gui;

import input.Team;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddTeams {
	
	public static void addTeams(){
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
	    
	    TextField team = new TextField();
	    team.setPromptText("Enter Team");
	    
	    TextField match = new TextField();
	    match.setPromptText("Enter match number");
	    
	    Label label = new Label("");
	    
	    Button ok = new Button("OK");
	    ok.setOnAction(event -> {
	    	try{
	    		Layout.teams.add(new Team(Integer.parseInt(match.getText()), team.getText()));
	    		stage.close();
	    	}catch(NumberFormatException e){
	    		label.setText("Invalid Number");
	    	}
	    });
	    Button cancel = new Button("Cancel");
	    cancel.setOnAction(event -> stage.close());
	    
	    HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(8);
		hbox.getChildren().addAll(ok, cancel);
	    
	    vbox.getChildren().addAll(team, match, hbox, label);
	    
	    Scene scene = new Scene(vbox, 200, 200);
	    
	    stage.setScene(scene);
	    stage.setTitle("Add Team");
	    stage.show();
	}

}

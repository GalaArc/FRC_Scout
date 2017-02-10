package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Layout extends Application{
	
	public Stage window;
	public Scene start, menu;
	public static final int layWidth = 1366;
	public static final int layHeight = 768;
	
	public static void main(String[]args){
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		window = arg0;
		window.setTitle("FRC Scouting Login");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setVgap(15);
		grid.setHgap(30);
		
		Label username = new Label("Username");
		GridPane.setConstraints(username, 0, 0);
		
		TextField inputUsername = new TextField("Robolancers");
		GridPane.setConstraints(inputUsername, 1, 0);
		
		Label password = new Label("Password");
		GridPane.setConstraints(password, 0, 1);
		
		TextField inputPassword = new TextField("321Lancers!");
		GridPane.setConstraints(inputPassword, 1, 1);
		
		Button login = new Button("Log in");
		GridPane.setConstraints(login, 1, 2);
		
		grid.getChildren().addAll(username, inputUsername, password, inputPassword, login);
		
		start = new Scene(grid, layWidth, layHeight);
		window.setScene(start);
		window.show();
		
		login.setOnAction(e -> window.setScene(menu));

	}
	
	
}
package gui;

import input.InputMatches;
import input.InputTeams;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Layout extends Application{
	
	public Stage window;
	public Scene start, menu;
	public TableView<InputMatches> table1, table2;
	public static final int layWidth = 1366;
	public static final int layHeight = 768;
	
	public static void main(String[]args){
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		window = arg0;
		
		TableColumn<InputMatches, Integer> firstColumn = new TableColumn<>("Match Number");
		firstColumn.setMinWidth(200);
		firstColumn.setCellValueFactory(new PropertyValueFactory<>("match number"));
	
		TableColumn<InputMatches, String> secondColumn = new TableColumn<>("Team Name");
		secondColumn.setMinWidth(200);
		secondColumn.setCellValueFactory(new PropertyValueFactory<>("team name"));
		
		VBox box = new VBox();
		box.getChildren().addAll();
		
		GridPane grid = new GridPane();
		GridPane grid2 = new GridPane();
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setVgap(15);
		grid.setHgap(30);
		
		Label username = new Label("Username");
		GridPane.setConstraints(username, 0, 0);
		
		TextField inputUsername = new TextField("Input Username");
		GridPane.setConstraints(inputUsername, 1, 0);
		
		Label password = new Label("Password");
		GridPane.setConstraints(password, 0, 1);
		
		TextField inputPassword = new TextField("Input Password");
		GridPane.setConstraints(inputPassword, 1, 1);
		
		Button login = new Button("Log in");
		GridPane.setConstraints(login, 1, 2);
		login.setOnAction(e -> window.setScene(menu));
		
		start = new Scene(grid, layWidth, layHeight);
		grid.getChildren().addAll(username, inputUsername, password, inputPassword, login);
		
		Button goBack = new Button("Go Back");
		GridPane.setConstraints(goBack, 0, 0);
		goBack.setOnAction(e -> window.setScene(start));
		
		table1 = new TableView<>();
		table1.setItems(getMatches());
		table1.getColumns().addAll(firstColumn);
		
//		table2 = new TableView<>();
//		table2.setItems(getTeams());
//		table2.getColumns().addAll(secondColumn);
		
		menu = new Scene(grid2, layWidth, layHeight);
		grid2.getChildren().addAll(goBack, table1, table2);
		
		window.setScene(start);
		window.setTitle("FRC Scouting Login");
		window.show();
	
	}
	
	public ObservableList<InputMatches> getMatches(){
		ObservableList<InputMatches> matches = FXCollections.observableArrayList();
		matches.add(new InputMatches(67));
		matches.add(new InputMatches(63));
		matches.add(new InputMatches(62));
		matches.add(new InputMatches(61));
		return matches;
	}
	
	public ObservableList<InputTeams> getTeams(){
		ObservableList<InputTeams> teams = FXCollections.observableArrayList();
		teams.add(new InputTeams("AA"));
		teams.add(new InputTeams("BB"));
		teams.add(new InputTeams("CC"));
		teams.add(new InputTeams("DD"));
		return teams;
	}
	
}
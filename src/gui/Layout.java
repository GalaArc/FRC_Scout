package gui;

import input.Team;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Layout extends Application{
	
	Stage window;
	Scene login, mainMenu, teamScene;
	TableView<Team> teamTable;
	static final int layWidth = 1366;
	static final int layHeight = 768;
	static ObservableList<Team> teams = FXCollections.observableArrayList();
	
	public static void main(String[]args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		
		GridPane tableGrid = new GridPane();
		GridPane loginGrid = new GridPane();
		GridPane mainMenuGrid = new GridPane();
		
		loginGrid.setPadding(new Insets(5, 5, 5, 5));
		loginGrid.setVgap(15);
		loginGrid.setHgap(30);
		
		mainMenuGrid.setPadding(new Insets(5, 5, 5, 5));
		mainMenuGrid.setVgap(15);
		mainMenuGrid.setHgap(30);
		
		teamScreen(tableGrid);
		loginScreen(loginGrid);
		mainMenu(mainMenuGrid);
		
		login = new Scene(loginGrid, layWidth, layHeight);
		
		window.setScene(login);
		window.setTitle("FRC Scouting Login");
		window.show();
	}
	
	private void loginScreen(GridPane grid){
		Label username = new Label("Username");
		GridPane.setConstraints(username, 0, 0);
		
		TextField inputUsername = new TextField();
		inputUsername.setPromptText("Input Username");
		GridPane.setConstraints(inputUsername, 1, 0);
		
		Label password = new Label("Password");
		GridPane.setConstraints(password, 0, 1);
		
		TextField inputPassword = new TextField();
		inputPassword.setPromptText("Input Password");
		GridPane.setConstraints(inputPassword, 1, 1);
		
		Button login = new Button("Log in");
		GridPane.setConstraints(login, 1, 2);
		
		login.setOnAction(event -> window.setScene(mainMenu));
//		{
//			if (inputUsername.getText().equals("robolancers") && inputPassword.getText().equals("321lancers")) {
//	            window.setScene(mainMenu);
//	        } else {
//	            
//	        }
//		});
//		
		grid.getChildren().addAll(username, inputUsername, password, inputPassword, login);
	}
	
	private void teamScreen(GridPane grid){
		TableColumn<Team, Integer> firstColumn = new TableColumn<>("Match Number");
		firstColumn.setMinWidth(200);
		firstColumn.setCellValueFactory(new PropertyValueFactory<>("matchNumber"));
		
		TableColumn<Team, String> secondColumn = new TableColumn<>("Team Name");
		secondColumn.setMinWidth(200);
		secondColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
		
		teamTable = new TableView<>();
		teamTable.setEditable(true);
		teamTable.setItems(teams);
		teamTable.getColumns().addAll(firstColumn, secondColumn);
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(8);
		
		Button addTeamButton = new Button("Add Team");
		addTeamButton.setOnAction(event -> AddTeams.addTeams());
		
		Button deleteTeamButton = new Button("Delete Team");
		deleteTeamButton.setOnAction(event -> handleDeleteButton());
		
		hbox.getChildren().addAll(addTeamButton, deleteTeamButton);
		grid.add(hbox, 0, 1);
		
		teamScene = new Scene(grid, layWidth, layHeight);
		grid.add(teamTable, 0, 0);
	}
	
	private void mainMenu(GridPane grid){
		Button toTeamScreen = new Button("Team Screen");
		toTeamScreen.setOnAction(event -> window.setScene(teamScene));
		
		mainMenu = new Scene(grid, layWidth, layHeight);
		grid.add(toTeamScreen, 0, 0);
	}
	
	private void handleDeleteButton(){
		int selectedIndex = teamTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        teamTable.getItems().remove(selectedIndex);
	    } else {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(window);
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");
	        alert.showAndWait();
	    }
	}
}
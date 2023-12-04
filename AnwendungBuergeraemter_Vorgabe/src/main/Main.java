package main;

import guiBuergeraemter.BuergeraemterAnwendersystem;
import guiBuergeraemter.BuergeraemterControl;
import guiStaedtischeEinrichtungen.StaedtischeEinrichtungenControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemterControl(primaryStage);
		new StaedtischeEinrichtungenControl(new Stage());
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}

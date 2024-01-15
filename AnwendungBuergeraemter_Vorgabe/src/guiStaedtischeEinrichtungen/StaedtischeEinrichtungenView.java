package guiStaedtischeEinrichtungen;
   
import java.io.IOException;

import businessBuergeramt.BuergeraemterModel;
import businessBuergeramt.Buergeramt;
import businessSporthalle.Sporthalle;
import businessSporthalle.SporthalleModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {
	
	BuergeraemterModel bam;
	StaedtischeEinrichtungenControl sec;
	SporthalleModel shm;
	
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new Pane();
    	private Label lblAnzeigeBuergeraemter     
 		= new Label("Anzeige Bürgerämter");
    	private TextArea txtAnzeigeBuergeraemter  = new TextArea();
    	private Button btnAnzeigeBuergeraemter = new Button("Anzeige");
    	
    	private Label lblAnzeigeSporthallen     
 		= new Label("Anzeige Sporthallen");
    	private TextArea txtAnzeigeSporthallen  = new TextArea();
    	private Button btnAnzeigeSporthallen = new Button("csv-import und Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl sec ,Stage primaryStage, BuergeraemterModel bam, SporthalleModel shm){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen " 
 			+ "Einrichtungen");
    		primaryStage.show();
    		this.bam = bam;
    		this.sec = sec;
    		this.shm = shm;
    		


		this.initKomponentenBuergeramt();
		this.initListenerBuergeramt();
		
		this.initKomponentenSporthalle();
		this.initListenerSporthalle();
    	}
    	
    	private void initKomponentenSporthalle(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeSporthallen.setLayoutX(20);
    		lblAnzeigeSporthallen.setLayoutY(40);
    		lblAnzeigeSporthallen.setFont(font);
    		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeSporthallen);    
        	
// Textbereich	
        	txtAnzeigeSporthallen.setEditable(false);
        	txtAnzeigeSporthallen.setLayoutX(20);
        	txtAnzeigeSporthallen.setLayoutY(90);
        	txtAnzeigeSporthallen.setPrefWidth(220);
        	txtAnzeigeSporthallen.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeSporthallen);        	
        	// Button
          	btnAnzeigeSporthallen.setLayoutX(20);
        	btnAnzeigeSporthallen.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeSporthallen); 
   }
   
   private void initListenerSporthalle() {
	    btnAnzeigeSporthallen.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeSporthallenAn();
	        	} 
   	    });
    }
   
	private void initKomponentenBuergeramt(){
		// Label
		Font font = new Font("Arial", 20);
   	lblAnzeigeBuergeraemter.setLayoutX(310);
		lblAnzeigeBuergeraemter.setLayoutY(40);
		lblAnzeigeBuergeraemter.setFont(font);
		lblAnzeigeBuergeraemter.setStyle("-fx-font-weight: bold;"); 
   	pane.getChildren().add(lblAnzeigeBuergeraemter);    
    	
//Textbereich	
    	txtAnzeigeBuergeraemter.setEditable(false);
 		txtAnzeigeBuergeraemter.setLayoutX(310);
		txtAnzeigeBuergeraemter.setLayoutY(90);
 		txtAnzeigeBuergeraemter.setPrefWidth(220);
		txtAnzeigeBuergeraemter.setPrefHeight(185);
   	pane.getChildren().add(txtAnzeigeBuergeraemter);        	
    	// Button
      	btnAnzeigeBuergeraemter.setLayoutX(310);
    	btnAnzeigeBuergeraemter.setLayoutY(290);
    	pane.getChildren().add(btnAnzeigeBuergeraemter); 
}

private void initListenerBuergeramt() {
    btnAnzeigeBuergeraemter.setOnAction(
			new EventHandler<ActionEvent>() {
    		@Override
        	public void handle(ActionEvent e) {
            	zeigeBuergeraemterAn();
        	} 
	    });
}
   
    void zeigeBuergeraemterAn(){
    		if(bam.getBuergeramt() != null){
    			String text = "";
    			for(Buergeramt b : bam.getBuergeramt())
    				text += b.gibBuergeramtZurueck(';');
    			txtAnzeigeBuergeraemter.setText(text);
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Bürgeramt aufgenommen!");
    		}
    }	
    
    void zeigeSporthallenAn(){
    	System.out.println("ZeigeSporthallenAn aufgerufen");
    	try {
			shm.leseSporthallenAusCsvDatei();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(shm.getSporthalle() != null){
			String text = "";
			for(Sporthalle b : shm.getSporthalle())
				text += b.gibSporthalleZurueck(';');
			txtAnzeigeSporthallen.setText(text);
		}
		else{
			zeigeInformationsfensterAn(
				"Bisher wurde keine Sporthalle aufgenommen!");
		}
}	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}


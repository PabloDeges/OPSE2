package guiBuergeraemter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import businessBuergeramt.BuergeraemterModel;
import businessBuergeramt.Buergeramt;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class BuergeraemterView {
	
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblGeoeffnetVon   		= new Label("Ge�ffnet von:");
    private Label lblGeoeffnetBis  	 		= new Label("Ge�ffnet bis:");
    private Label lblStrasseHNr   			= new Label("Stra�e und Hausnummer:");
    private Label lblDienstleistungen  		= new Label("Dienstleistungen:");
    private TextField txtName 	 			= new TextField();
    private TextField txtGeoeffnetVon		= new TextField();
    private TextField txtGeoeffnetBis		= new TextField();
    private TextField txtStrasseHNr			= new TextField();
    private TextField txtDienstleistungen	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");
    private MenuItem mnItmTxtExport 		= new MenuItem("txt-Export");
    private BuergeraemterControl baControl;
    private BuergeraemterModel baModel;
	
    
    
	public BuergeraemterView(BuergeraemterControl baControl, Stage st, BuergeraemterModel baModel) {
		this.baControl = baControl;
		this.baModel = baModel;
		
		Scene scene = new Scene(this.pane, 700, 340);
    	st.setScene(scene);
    	st.setTitle("Verwaltung von B�rger�mtern");
    	st.show();
		
		initKomponenten();
		initListener();
	}
	
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblGeoeffnetVon.setLayoutX(20);
    	lblGeoeffnetVon.setLayoutY(130);
    	lblGeoeffnetBis.setLayoutX(20);
    	lblGeoeffnetBis.setLayoutY(170);
    	lblStrasseHNr.setLayoutX(20);
    	lblStrasseHNr.setLayoutY(210);
    	lblDienstleistungen.setLayoutX(20);
    	lblDienstleistungen.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblGeoeffnetVon, lblGeoeffnetBis,
       		lblStrasseHNr, lblDienstleistungen);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtGeoeffnetVon.setLayoutX(170);
    	txtGeoeffnetVon.setLayoutY(130);
    	txtGeoeffnetVon.setPrefWidth(200);
    	txtGeoeffnetBis.setLayoutX(170);
    	txtGeoeffnetBis.setLayoutY(170);
    	txtGeoeffnetBis.setPrefWidth(200);
      	txtStrasseHNr.setLayoutX(170);
    	txtStrasseHNr.setLayoutY(210);
    	txtStrasseHNr.setPrefWidth(200);
    	txtDienstleistungen.setLayoutX(170);
    	txtDienstleistungen.setLayoutY(250);
    	txtDienstleistungen.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtGeoeffnetVon, txtGeoeffnetBis,
     		txtStrasseHNr, txtDienstleistungen);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
   	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvExport);
  	    this.mnDatei.getItems().add(mnItmTxtExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    baControl.nehmeBuergeramtAuf(txtName.getText(), txtGeoeffnetVon.getText(),
           	            txtGeoeffnetBis.getText(),
            		    txtStrasseHNr.getText(),
            		    txtDienstleistungen.getText().split(";"));
        	    baModel.notifyObservers();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeBuergeraemterAn();
	        } 
   	    });  
	    
	    mnItmCsvExport.setOnAction(
            (e)-> {baControl.schreibeBuergeraemterInDatei("csv");});
	    
	    mnItmTxtExport.setOnAction((e)-> {baControl.schreibeBuergeraemterInDatei("txt");});
    }
   void zeigeBuergeraemterAn(){
   	if(baModel.getBuergeramt() != null){
   		String text = "";
   		for(Buergeramt b : baModel.getBuergeramt())
				text += b.gibBuergeramtZurueck(' ');
   		txtAnzeige.setText(text);
   				
   	}
   	else{
   		zeigeInformationsfensterAn("Bisher wurde kein B�rgeramt aufgenommen!");
   	}
   }	

   public void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
   		"Information", meldung).zeigeMeldungsfensterAn();
   }	
   
   public void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,
       	"Fehler", meldung).zeigeMeldungsfensterAn();
   }
    
}

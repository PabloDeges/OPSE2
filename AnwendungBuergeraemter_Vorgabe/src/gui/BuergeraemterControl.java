package gui;

import java.io.IOException;

import business.BuergeraemterModel;
import business.Buergeramt;
import javafx.stage.Stage;

public class BuergeraemterControl {
	
	private BuergeraemterView baView;
	private BuergeraemterModel baModel;
	
	public BuergeraemterControl(Stage stage) {
		baModel = new BuergeraemterModel();
		baView = new BuergeraemterView(this, stage, baModel);
	}
	
	
	public void nehmeBuergeramtAuf(String name, String offenAb, String offenBis, String adresse, String[] dienstleistungen){
    	try{
    		baModel.setBuergeramt(new Buergeramt(
    			name,
   	            Float.parseFloat(offenAb),
   	            Float.parseFloat(offenBis),
    		    adresse,
    		    dienstleistungen));
    		baView.zeigeInformationsfensterAn("Das Bürgeramt wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		baView.zeigeFehlermeldungsfensterAn("Kann nicht aufgenommen werden");
     	}
    }
	
	public void schreibeBuergeraemterInDatei(String typ) {
		
		try {
			if("csv".equals(typ)) {
				baModel.schreibeBuergeraemterInCsvDatei();
				
			}
			else {
				baView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
			baView.zeigeInformationsfensterAn("Das Bürgeramt wurde gespeichert");
			
		} catch (IOException ioe) {
			baView.zeigeFehlermeldungsfensterAn("IOExeption :(");
		}
		catch (Exception e) {
			baView.zeigeFehlermeldungsfensterAn(e.getMessage());
		}
		
	}
	
	
}

package guiBuergeraemter;

import java.io.IOException;

import businessBuergeramt.BuergeraemterModel;
import businessBuergeramt.Buergeramt;
import javafx.stage.Stage;

import ownUtil.Observer;

public class BuergeraemterControl implements Observer{
	
	private BuergeraemterView baView;
	private BuergeraemterModel baModel;
	
	public BuergeraemterControl(Stage stage) {
		baModel = BuergeraemterModel.getInstance();
		baView = new BuergeraemterView(this, stage, baModel);
		baModel.addObserver(this);
	}
	
	
	public void nehmeBuergeramtAuf(String name, String offenAb, String offenBis, String adresse, String[] dienstleistungen){
    	try{
    		baModel.setBuergeramt(new Buergeramt(
    			name,
   	            Float.parseFloat(offenAb),
   	            Float.parseFloat(offenBis),
    		    adresse,
    		    dienstleistungen));
    		//baView.zeigeInformationsfensterAn("Das Bürgeramt wurde aufgenommen!");
    		
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
			else if("txt".equals(typ)) {
				baModel.schreibeBuergeraemterInTxtDatei();
				
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
	
	public void update() {
		baView.zeigeBuergeraemterAn();
		
	}
	
	
}

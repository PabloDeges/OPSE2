package businessBuergeramt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import fabrik.*;
import ownUtil.Observable;
import ownUtil.Observer;

public class BuergeraemterModel implements Observable{
	
	ArrayList<Observer> observers = new ArrayList<Observer>();

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		
		for(Observer o : observers) {
			o.update();
		}
		
	}
	
	private ArrayList<Buergeramt> buergeramt = new ArrayList<Buergeramt>();
	
	private static BuergeraemterModel theInstance = null;
	
	public static BuergeraemterModel getInstance() {
		
		if (theInstance == null)
			theInstance = new BuergeraemterModel();
		return theInstance;
		
	}
	
	
	private BuergeraemterModel() {
	}

	
	 public  ArrayList<Buergeramt> getBuergeramt() {
		return buergeramt;
	}


	public void setBuergeramt( Buergeramt buergeramt) {
		this.buergeramt.add(buergeramt);
		
	}


	
	
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
		
		ExportCreator creator = new ConcreteCsvExportCreator();
		ExportProduct product = creator.factoryMethod();
		product.fuegeInDateiHinzu(this.buergeramt);
		product.schliesseDatei();
		
		
		
	}
	
public void schreibeBuergeraemterInTxtDatei() throws IOException {
		
		ExportCreator creator = new ConcreteTxtExportCreator();
		ExportProduct product = creator.factoryMethod();
		product.fuegeInDateiHinzu(this.buergeramt);
		product.schliesseDatei();
		
		
		
	}

}

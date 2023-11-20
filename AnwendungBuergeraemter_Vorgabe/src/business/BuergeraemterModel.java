package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fabrik.*;

public class BuergeraemterModel {
	
	public BuergeraemterModel() {
	}

	
	 public Buergeramt getBuergeramt() {
		return buergeramt;
	}


	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
	}


	private Buergeramt buergeramt;
	
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

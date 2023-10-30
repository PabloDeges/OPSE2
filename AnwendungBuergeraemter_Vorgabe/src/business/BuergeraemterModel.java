package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("test.csv", true));
		bw.write(this.getBuergeramt().gibBuergeramtZurueck(';'));
		bw.close();
		
	}
}

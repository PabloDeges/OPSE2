package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.Buergeramt;

public class ConcreteCsvExportProduct extends ExportProduct {
	
	BufferedWriter bw = null;
	
	public ConcreteCsvExportProduct() throws IOException{
		bw = new BufferedWriter(new FileWriter("export.csv", true));
	}

	public void fuegeInDateiHinzu(ArrayList<Buergeramt> ba) throws IOException {
		
//		bw.write("Name: "  +  ba.getName());
//		bw.write("Geoeffnet von: "  +  ba.getGeoeffnetVon());
//		bw.write("Geoeffnet bis: "  +  ba.getGeoeffnetBis());
//		bw.write("Strasse und Hausnummer: "  +  ba.getStrasseHNr());
//		bw.write("Dienstleistungen: " + ba.getDienstleistungenAlsString(';'));
		
		for(Buergeramt b : ba) {
			bw.write(b.gibBuergeramtZurueck(';'));
		}
		
		
		
	}
	

	@Override
	public void schliesseDatei() throws IOException {
		bw.close();
		
	}

}

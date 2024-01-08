package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.Buergeramt;

public class ConcreteTxtExportProduct extends ExportProduct{

	BufferedWriter bw = null;
	public ConcreteTxtExportProduct() throws IOException{
		bw = new BufferedWriter(new FileWriter("export.txt"));
	}

	public void fuegeInDateiHinzu(ArrayList<Buergeramt> ba) throws IOException {
		
		for(Buergeramt b : ba) {
			bw.write("Daten des Bürgeramts\n");
			bw.write("Name des Bürgeramts: "  +  b.getName() + "\n");
			bw.write("Öffnungszeiten: "  +  b.getGeoeffnetVon() + " - " + b.getGeoeffnetBis()+ "\n");
			bw.write("Strasse und Hausnummer des Bürgeramts: "  +  b.getStrasseHNr()+ "\n");
			bw.write("Dienstleistungen des Bürgeramts: " + b.getDienstleistungenAlsString('-')+ "\n");
		}
		

		
		
	}
	

	@Override
	public void schliesseDatei() throws IOException {
		bw.close();
		
	}

}

package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteTxtExportProduct extends ExportProduct{

	BufferedWriter bw = null;
	public ConcreteTxtExportProduct() throws IOException{
		bw = new BufferedWriter(new FileWriter("export.txt"));
	}

	public void fuegeInDateiHinzu(Buergeramt ba) throws IOException {
		bw.write("Daten des Bürgeramts\n");
		bw.write("Name des Bürgeramts: "  +  ba.getName() + "\n");
		bw.write("Öffnungszeiten: "  +  ba.getGeoeffnetVon() + " - " + ba.getGeoeffnetBis()+ "\n");
		bw.write("Strasse und Hausnummer des Bürgeramts: "  +  ba.getStrasseHNr()+ "\n");
		bw.write("Dienstleistungen des Bürgeramts: " + ba.getDienstleistungenAlsString('-')+ "\n");
		

		
		
	}
	

	@Override
	public void schliesseDatei() throws IOException {
		bw.close();
		
	}

}

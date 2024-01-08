package fabrik;

import java.io.IOException;
import java.util.ArrayList;

import business.Buergeramt;

public abstract class ExportProduct {
	
	
	
	
	public abstract void schliesseDatei() throws IOException;

	public abstract void fuegeInDateiHinzu(ArrayList<Buergeramt> buergeramt) throws IOException;

	
	
}

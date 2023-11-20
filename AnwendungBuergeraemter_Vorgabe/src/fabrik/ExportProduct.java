package fabrik;

import java.io.IOException;

import business.Buergeramt;

public abstract class ExportProduct {
	
	
	
	
	public abstract void schliesseDatei() throws IOException;

	public abstract void fuegeInDateiHinzu(Buergeramt ba) throws IOException;

	
	
}

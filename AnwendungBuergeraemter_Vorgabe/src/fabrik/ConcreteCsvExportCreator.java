package fabrik;

import java.io.IOException;

public class ConcreteCsvExportCreator extends ExportCreator {

	@Override
	public ExportProduct factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteCsvExportProduct();
	}

}

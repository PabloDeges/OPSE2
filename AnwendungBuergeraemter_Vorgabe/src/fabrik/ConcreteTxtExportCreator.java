package fabrik;

import java.io.IOException;

public class ConcreteTxtExportCreator extends ExportCreator{

	@Override
	public ExportProduct factoryMethod() throws IOException {

		return new ConcreteTxtExportProduct();
	}

}

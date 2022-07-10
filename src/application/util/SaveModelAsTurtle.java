package application.util;

import java.io.OutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.*;

public class SaveModelAsTurtle implements ISaveModelAs {
	@Override
	public void saveModel(Model model, OutputStream outStream) {
		RDFDataMgr.write(outStream, model, RDFFormat.TURTLE);
	}
}

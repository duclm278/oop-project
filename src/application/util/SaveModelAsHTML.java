package application.util;

import java.io.OutputStream;
import org.apache.jena.rdf.model.Model;

public class SaveModelAsHTML implements ISaveModelAs {
	@Override
	public void saveModel(Model model, OutputStream outStream) {
		// Demo extensibility!
	}
}

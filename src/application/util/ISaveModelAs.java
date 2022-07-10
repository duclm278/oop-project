package application.util;

import java.io.OutputStream;

import org.apache.jena.rdf.model.Model;

public interface ISaveModelAs {
	public void saveModel(Model model, OutputStream outStream);
}

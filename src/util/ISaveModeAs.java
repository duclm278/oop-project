package util;

import java.io.OutputStream;
import org.apache.jena.rdf.model.Model;

public interface ISaveModeAs {
    public void saveModel(Model model, OutputStream outStream);
}

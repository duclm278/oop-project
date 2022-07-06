package util;

import java.io.OutputStream;
import org.apache.jena.rdf.model.Model;

public class SaveModelAsHTML implements ISaveModeAs {
    @Override
    public void saveModel(Model model, OutputStream outStream) {
        // Demo extensibility!
    }
}

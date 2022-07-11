package application.util;

import java.io.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.*;
import org.apache.jena.sparql.exec.http.QueryExecutionHTTP;

// Not official yet!
// Need catching errors!
public class Processing {
	public static Model readModel(String filename) {
		return RDFDataMgr.loadModel(filename);
	}

	public static Model executeQuery(String queryStr) throws NullPointerException, QueryParseException {
		Model outModel = null;
		queryStr = AutoPrefix.addPrefixes(queryStr);
		Query query = null;
		query = QueryFactory.create(queryStr);
		QueryExecution qExec = QueryExecutionHTTP.create().endpoint("http://dbpedia.org/sparql").query(query)
			.param("timeout", "30000") // Default on the web
			.param("signal_void", "on") // Default on the web
			.param("signal_unconnected", "on") // Default on the web
			.build();
		outModel = qExec.execConstruct();

		return outModel;
	}

	public static void deleteFile(String fileName) {
		// fileName must be a absolute path
		File file = new File(fileName);
		if (file.delete()) {
			System.out.println("Delete successfully!");
		} else {
			System.out.println("Cannot find your file!");
		}
	}

	public static void writeModel(String filename, Model model, ISaveModelAs writer) throws IOException {
		OutputStream outStream = new FileOutputStream(filename, false);
		writer.saveModel(model, outStream);
	}
}

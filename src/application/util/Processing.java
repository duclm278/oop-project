package application.util;

import java.io.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.*;
import org.apache.jena.sparql.exec.http.QueryExecutionHTTP;

public class Processing {
	public static Model readModel(String filename) {
		return RDFDataMgr.loadModel(filename);
	}

	public static Model executeQuery(String queryStr) {
		Model outModel = null;
		queryStr = AutoPrefix.addPrefixes(queryStr);
		Query query = null;
		try {
			query = QueryFactory.create(queryStr);
		} catch (QueryParseException e) {
			e.printStackTrace();
		}
		try (QueryExecution qExec = QueryExecutionHTTP.create().endpoint("http://dbpedia.org/sparql").query(query)
				.param("timeout", "30000")         // Default on the web
				.param("signal_void", "on")        // Default on the web
				.param("signal_unconnected", "on") // Default on the web
				.build()) {

			outModel = qExec.execConstruct();
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.exit(1);
		}

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

	public static void writeModel(String filename, Model model, ISaveModelAs writer) {
		try {
			OutputStream outStream = new FileOutputStream(filename, false);
			writer.saveModel(model, outStream);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}

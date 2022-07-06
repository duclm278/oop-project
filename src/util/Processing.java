package util;

import java.io.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.*;
import org.apache.jena.sparql.exec.http.QueryExecutionHTTP;

// Not official yet!
// Need catching errors!
public class Processing {
    public static Model readModel(String filename) {
        return RDFDataMgr.loadModel(filename) ;
    }

    public static Model executeQuery(String queryStr) {
        Model outModel = null;
        queryStr = AutoPrefix.addPrefix(queryStr);
        Query query = QueryFactory.create(queryStr);
        try (QueryExecution qExec = QueryExecutionHTTP.create()
                .endpoint("http://dbpedia.org/sparql")
                .query(query)
                .param("timeout", "300000") // 5 minutes
                .build()) {

            outModel =  qExec.execConstruct();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return outModel;
    }

    public static Model executeQuery(String queryStr, Model inModel) {
        Model outModel = null;
        queryStr = AutoPrefix.addPrefix(queryStr);
        Query query = QueryFactory.create(queryStr);
        try (QueryExecution qExec = QueryExecutionFactory.create(query, inModel)) {
            outModel = qExec.execConstruct();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return outModel;
    }

    public static void deleteFile(String fileName) {
        // TODO: Code it!
    }

    public static void writeModel(String filename, Model model, ISaveModeAs writer) {
        try {
            OutputStream outStream = new FileOutputStream(filename, false);
            writer.saveModel(model, outStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

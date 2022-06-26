package test;

import java.io.*;
import java.util.Scanner;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.*;

public class OfflineTest {
    public static void main(String[] args) {
        // Save model in TURTLE format
        String queryStr = getString("Test.rq");
        Query query = QueryFactory.create(queryStr) ;

        Model inModel = RDFDataMgr.loadModel("RawData.ttl") ;
        try(QueryExecution qExec = QueryExecutionFactory.create(query, inModel)) {
            Model outModel = qExec.execConstruct();
            OutputStream outStream = new FileOutputStream("FinalData.ttl", false);
            RDFDataMgr.write(outStream, outModel, RDFFormat.TURTLE);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String getString(String name) {
        StringBuilder sb = new StringBuilder();
        InputStream inStream = OfflineTest.class.getResourceAsStream(name);
        try (Scanner sc = new Scanner(inStream)) {
            while (sc.hasNextLine())
                sb.append(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return sb.toString();
    }
}

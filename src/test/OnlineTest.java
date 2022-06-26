package test;

import java.io.*;
import java.util.Scanner;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.*;
import org.apache.jena.sparql.exec.http.QueryExecutionHTTP;

public class OnlineTest {
    public static void main(String[] args) {
        // Save model in TURTLE format
        String queryStr = getString("GetRaw.rq");
        Query query = QueryFactory.create(queryStr) ;

        try (QueryExecution qExec = QueryExecutionHTTP.create()
                .endpoint("http://dbpedia.org/sparql")
                .query(query)
                .param("timeout", "300000") // 5 minutes
                .build()) {

            Model model = qExec.execConstruct();
            OutputStream outStream = new FileOutputStream("RawData.ttl", false);
            RDFDataMgr.write(outStream, model, RDFFormat.TURTLE);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String getString(String name) {
        StringBuilder sb = new StringBuilder();
        InputStream inStream = OnlineTest.class.getResourceAsStream(name);
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

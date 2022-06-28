import java.io.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.*;
import org.apache.jena.sparql.exec.http.QueryExecutionHTTP;

import query.QueryByLake;
import util.AutoPrefix;

public class App {
    public static void main(String[] args) {
        QueryByLake queryObj = new QueryByLake();
        String outName = queryObj.getOutName();

        /*
         * Online request to get raw data
         */
        String onlineQueryStr = queryObj.getOnlineQueryStr();
        onlineQueryStr = AutoPrefix.addPrefix(onlineQueryStr);
        System.out.println(onlineQueryStr);

        Query onlineQuery = QueryFactory.create(onlineQueryStr);
        try (QueryExecution qExec = QueryExecutionHTTP.create()
                .endpoint("http://dbpedia.org/sparql")
                .query(onlineQuery)
                .param("timeout", "300000") // 5 minutes
                .build()) {

            Model model = qExec.execConstruct();
            OutputStream outStream = new FileOutputStream(outName + "_tmp.ttl", false);
            RDFDataMgr.write(outStream, model, RDFFormat.TURTLE);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");

        /*
         * Offline request to get actual data
         */
        String offlineQueryStr = queryObj.getOfflineQueryStr();
        offlineQueryStr = AutoPrefix.addPrefix(offlineQueryStr);
        System.out.println(offlineQueryStr);

        Query offlineQuery= QueryFactory.create(offlineQueryStr);
        Model inModel = RDFDataMgr.loadModel(outName + "_tmp.ttl") ;
        try(QueryExecution qExec = QueryExecutionFactory.create(offlineQuery, inModel)) {
            Model outModel = qExec.execConstruct();
            OutputStream outStream = new FileOutputStream(outName + ".ttl", false);
            RDFDataMgr.write(outStream, outModel, RDFFormat.TURTLE);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

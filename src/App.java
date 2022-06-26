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
        String queryInitStr = queryObj.getRawStr();
        queryInitStr = AutoPrefix.addPrefix(queryInitStr);
        System.out.println(queryInitStr);

        Query queryInit = QueryFactory.create(queryInitStr);
        try (QueryExecution qExec = QueryExecutionHTTP.create()
                .endpoint("http://dbpedia.org/sparql")
                .query(queryInit)
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

        // /*
        //  * Offline request to get actual data
        //  */
        String queryStr = queryObj.getQueryStr();
        queryStr = AutoPrefix.addPrefix(queryStr);
        System.out.println(queryStr);

        Query query= QueryFactory.create(queryStr);
        Model inModel = RDFDataMgr.loadModel(outName + "_tmp.ttl") ;
        try(QueryExecution qExec = QueryExecutionFactory.create(query, inModel)) {
            Model outModel = qExec.execConstruct();
            OutputStream outStream = new FileOutputStream(outName + ".ttl", false);
            RDFDataMgr.write(outStream, outModel, RDFFormat.TURTLE);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

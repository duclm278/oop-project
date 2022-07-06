package query;

import java.util.ArrayList;
import org.apache.jena.rdf.model.*;

import util.AutoPrefix;
import util.ISaveModelAs;
import util.Processing;

public abstract class QueryDBpedia implements ICrawler {
    private ArrayList<String> infoList;

    public QueryDBpedia() {
        infoList = new ArrayList<>();
        QuerySets.addCoreInfo2List(infoList);
    }

    public abstract String getOutName();

    public abstract String getPagesByTopic();

    public String getOfflineQueryStr() {
        String QueryStr = "CONSTRUCT {" + "\n" +
                          makeQueryBlock(infoList) + "\n" +
                          "} WHERE {" + " \n" +
                          makeOptQueryBlock(infoList) + "\n" +
                          "}";
        return QueryStr;
    }

    public String getOnlineQueryStr() {
        String QueryStr = "CONSTRUCT {" + "\n" +
                          "?s ?p ?o." + "\n" +
                          "} WHERE {" + " \n" +
                          getPagesByTopic() + "\n" +
                          "?s ?p ?o." + "\n" +
                          "FILTER (!isLITERAL(?o) || LANG(?o) = '' || langMATCHES(lang(?o), 'en') || langMATCHES(lang(?o), 'vn'))" + "\n" +
                          "FILTER (STR(?o) != '')" + "\n" +
                          "FILTER (!CONTAINS(LCASE(STR(?p)), 'wiki'))" + "\n" +
                          "FILTER (!CONTAINS(LCASE(STR(?s)), 'list_of'))" + "\n" +
                          "}";
        return QueryStr;
    }

    public String makeQueryBlock(ArrayList<String> queryList) {
        String queryBlock = String.join("\n", queryList);
        return queryBlock;
    }

    public String makeOptQueryBlock(ArrayList<String> queryList) {
        ArrayList<String> optQueryList = new ArrayList<>();

        // Add OPTIONAL command to each item
        for (String queryItem : queryList) {
            optQueryList.add("OPTIONAL {" + queryItem + "}");
        }

        String optQueryBlock = String.join("\n", optQueryList);
        return optQueryBlock;
    }

    @Override
    public void extractData(ISaveModelAs writer) {
        String outName = this.getOutName();

        // Online request to get raw data
        String onlineQueryStr = this.getOnlineQueryStr();
        onlineQueryStr = AutoPrefix.addPrefix(onlineQueryStr);
        System.out.println(onlineQueryStr);
        Model onlineModel = Processing.executeQuery(onlineQueryStr);
        Processing.writeModel(outName + "_tmp.ttl", onlineModel, writer);
        System.out.println();

        // Offline request to get actual data
        String offlineQueryStr = this.getOfflineQueryStr();
        offlineQueryStr = AutoPrefix.addPrefix(offlineQueryStr);
        System.out.println(offlineQueryStr);
        Model inModel = Processing.readModel(outName + "_tmp.ttl");
        Model offlineModel = Processing.executeQuery(offlineQueryStr, inModel);
        Processing.writeModel(outName + ".ttl", offlineModel, writer);

        // Delete stuff
        Processing.deleteFile(outName + "_tmp.ttl");
    }

    public ArrayList<String> getInfoList() {
        return infoList;
    }
}

package query;

import java.util.ArrayList;

public abstract class QueryBy {
    private ArrayList<String> infoList;

    public QueryBy() {
        infoList = new ArrayList<>();
        infoList.add("?s rdf:type ?type.");
        infoList.add("?s dct:subject ?subject.");
        infoList.add("?s rdfs:label ?label.");
        infoList.add("?s dbo:abstract ?abstract.");
        infoList.add("?s rdfs:comment ?comment.");
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
                          "?s ?p ?o" + "\n" +
                          "} WHERE {" + " \n" +
                          getPagesByTopic() + "\n" +
                          "?s ?p ?o" + "\n" +
                          "FILTER (!isLITERAL(?o) || LANG(?o) = '' || langMATCHES(lang(?o), 'en') || langMATCHES(lang(?o), 'vn'))" + "\n" +
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

    public ArrayList<String> getInfoList() {
        return infoList;
    }
}

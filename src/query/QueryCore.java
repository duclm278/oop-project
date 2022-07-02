package query;

import java.util.ArrayList;

public interface QueryCore {
    public default void addCoreInfo2List(ArrayList<String> inputList) {
        inputList.add("?s rdf:type ?type.");
        inputList.add("?s dct:subject ?subject.");
        inputList.add("?s rdfs:label ?label.");
        inputList.add("?s dbo:abstract ?abstract.");
        inputList.add("?s rdfs:comment ?comment.");
    }
}

package query;

import java.util.ArrayList;

public class QuerySets {
    public static void addCoreInfo2List(ArrayList<String> inputList) {
        inputList.add("?s rdf:type ?type.");
        inputList.add("?s dct:subject ?subject.");
        inputList.add("?s rdfs:label ?label.");
        inputList.add("?s dbo:abstract ?abstract.");
        inputList.add("?s rdfs:comment ?comment.");
    }

    public static void addDateInfo2List(ArrayList<String> inputList) {
        inputList.add("...");
        inputList.add("...");
        inputList.add("...");
        inputList.add("...");
        inputList.add("...");
    }

    public static void addGeoInfo2List(ArrayList<String> inputList) {
        inputList.add("?s geo:lat ?geoLat.");
        inputList.add("?s geo:long ?geoLong.");
        inputList.add("?s georss:point ?geoPoint.");
        inputList.add("?s dbp:location ?location.");
        inputList.add("?s dbp:locationCity ?locationCity.");
        inputList.add("?s dbp:locationCountry ?locationCountry.");
    }
}

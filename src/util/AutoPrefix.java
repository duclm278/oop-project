package util;

public class AutoPrefix {
    public static String addPrefix(String query) {
        String prefixes = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                          "PREFIX dct: <http://purl.org/dc/terms/>\n" +
                          "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                          "PREFIX dbo: <http://dbpedia.org/ontology/>" +
                          "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n" +
                          "PREFIX dbc: <http://dbpedia.org/resource/Category:>\n" +
                          "PREFIX dbp: <http://dbpedia.org/property/>\n" +
                          "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>\n" +
                          "PREFIX georss: <http://www.georss.org/georss/>\n" +
                          "";

        return prefixes + "\n" + query;
    }
}

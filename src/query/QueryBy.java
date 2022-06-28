package query;

public abstract class QueryBy {
    private String type;
    private String subjectOf;
    private String label;
    private String abstractInfo;
    private String comment;

    public QueryBy() {
        type         = "?s rdf:type ?type.";
        subjectOf    = "?s dct:subject ?subject.";
        label        = "?s rdfs:label ?label.";
        abstractInfo = "?s dbo:abstract ?abstract.";
        comment      = "?s rdfs:comment ?comment.";
    }

    public abstract String getOutName();

    public abstract String getPagesByTopic();

    public abstract String getOfflineQueryStr();

    public String getOnlineQueryStr() {
        String QuerySet = "CONSTRUCT {" + "\n" +
                          "?s ?p ?o" + "\n" +
                          "} WHERE {" + " \n" +
                          getPagesByTopic() + "\n" +
                          "?s ?p ?o" + "\n" +
                          "FILTER (!isLITERAL(?o) || LANG(?o) = '' || langMATCHES(lang(?o), 'en') || langMATCHES(lang(?o), 'vn'))" + "\n" +
                          "FILTER (!CONTAINS(LCASE(STR(?s)), 'list_of'))" + "\n" +
                          "}";
        return QuerySet;
    }

    public String getType() {
        return type;
    }

    public String getSubjectOf() {
        return subjectOf;
    }

    public String getLabel() {
        return label;
    }

    public String getAbstractInfo() {
        return abstractInfo;
    }

    public String getComment() {
        return comment;
    }
}

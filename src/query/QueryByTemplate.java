package query;

public class QueryByTemplate extends QueryBy {
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    public QueryByTemplate() {
        super();
        field1 = "...";
        field2 = "...";
        field3 = "...";
        field4 = "...";
        field5 = "...";
    }

    @Override
    public String getOutName() {
        return "[...]_of_Vietnam";
    }

    @Override
    public String getPagesByTopic() {
        // return "?s dct:subject dbc:[...]_of_Vietnam.";
        return "?s dct:subject/skos:broader* dbc:[...]_of_Vietnam.";
    }

    @Override
    public String getQueryStr() {
        String QueryStr = "CONSTRUCT {" + "\n" +
                          getType() + "\n" +
                          getSubjectOf() + "\n" +
                          getLabel() + "\n" +
                          getAbstractInfo() + "\n" +
                          getComment() + "\n" +
                          
                          // Custom fields
                          getField1() + "\n" +
                          getField2() + "\n" +
                          getField3() + "\n" +
                          getField4() + "\n" +
                          getField5() + "\n" +
                          "} WHERE {" + " \n" +
                          getPagesByTopic() + "\n" +

                          "OPTIONAL {" + getType() + "}\n" +
                          "OPTIONAL {" + getSubjectOf() + "}\n" +
                          "OPTIONAL {" + getLabel() + "}\n" +
                          "OPTIONAL {" + getAbstractInfo() + "}\n" +
                          "OPTIONAL {" + getComment() + "}\n" +

                          // Custom fields
                          "OPTIONAL {" + getField1() + "}\n" +
                          "OPTIONAL {" + getField2() + "}\n" +
                          "OPTIONAL {" + getField3() + "}\n" +
                          "OPTIONAL {" + getField4() + "}\n" +
                          "OPTIONAL {" + getField5() + "}\n" +
                          "}";
        return QueryStr;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public String getField4() {
        return field4;
    }

    public String getField5() {
        return field5;
    }
}

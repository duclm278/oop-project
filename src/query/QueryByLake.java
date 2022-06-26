package query;

import java.util.ArrayList;

public class QueryByLake extends QueryBy implements QueryGeo {
    private String name;
    private String length;
    private String shoreLength;
    private String basinCountries;
    private String areaTotal;
    private String inflow;
    private String outflow;
    private String lakeType;
    private ArrayList<String> geoList;

    public QueryByLake() {
        super();
        name           = "?s dbp:name ?name.";
        length         = "?s dbo:Length ?Length.";
        shoreLength    = "?s dbo:shoreLength ?shoreLength.";
        basinCountries = "?s dbp:basinCountries ?basinCountries.";
        areaTotal      = "?s dbo:areaTotal ?areaTotal.";
        inflow         = "?s dbp:inflow ?inflow.";
        outflow        = "?s dbp:outflow ?outflow.";
        lakeType       = "?s dbp:lakeType ?lakeType.";
        geoList        = new ArrayList<>();
        geoList.add("?s geo:lat ?geoLat.");
        geoList.add("?s geo:long ?geoLong.");
        geoList.add("?s georss:point ?geoPoint.");
    }

    @Override
    public String getOutName() {
        return "Lakes_of_Vietnam";
    }

    @Override
    public String getPagesByTopic() {
        return "?s dct:subject/skos:broader* dbc:Lakes_of_Vietnam.";
    }

    @Override
    public String getQueryStr() {
        String QueryStr = "CONSTRUCT {" + "\n" +
                          getType() + "\n" +
                          getSubjectOf() + "\n" +
                          getLabel() + "\n" +
                          getAbstractInfo() + "\n" +
                          getComment() + "\n" +

                          getName() + "\n" +
                          getLength() + "\n" +
                          getShoreLength() + "\n" +
                          getBasinCountries() + "\n" +
                          getAreaTotal() + "\n" +
                          getInflow() + "\n" +
                          getOutflow() + "\n" +
                          getLakeType() + "\n" +

                          // Get geo block
                          getGeoBlock() + "\n" +

                          "} WHERE {" + " \n" +
                          getPagesByTopic() + "\n" +

                          "OPTIONAL {" + getType() + "}\n" +
                          "OPTIONAL {" + getSubjectOf() + "}\n" +
                          "OPTIONAL {" + getLabel() + "}\n" +
                          "OPTIONAL {" + getAbstractInfo() + "}\n" +
                          "OPTIONAL {" + getComment() + "}\n" +

                          "OPTIONAL {" + getName() + "}\n" +
                          "OPTIONAL {" + getLength() + "}\n" +
                          "OPTIONAL {" + getShoreLength() + "}\n" +
                          "OPTIONAL {" + getBasinCountries() + "}\n" +
                          "OPTIONAL {" + getAreaTotal() + "}\n" +
                          "OPTIONAL {" + getInflow() + "}\n" +
                          "OPTIONAL {" + getOutflow() + "}\n" +
                          "OPTIONAL {" + getLakeType() + "}\n" +

                          // Get optional geo block
                          getOptGeoBlock() + "\n" +
                          "}";
        return QueryStr;
    }

    @Override
    public String getGeoBlock() {
        String geoInfo = String.join("\n", geoList);
        return geoInfo;
    }

    @Override
    public String getOptGeoBlock() {
        ArrayList<String> optGeoList = new ArrayList<>();

        // Add OPTIONAL command to each item
        for (String geoItem : geoList) {
            optGeoList.add("OPTIONAL {" + geoItem + "}");
        }

        String optGeoInfo = String.join("\n", optGeoList);
        return optGeoInfo;
    }

    public String getName() {
        return name;
    }

    public String getLength() {
        return length;
    }

    public String getShoreLength() {
        return shoreLength;
    }

    public String getBasinCountries() {
        return basinCountries;
    }

    public String getAreaTotal() {
        return areaTotal;
    }

    public String getInflow() {
        return inflow;
    }

    public String getOutflow() {
        return outflow;
    }

    public String getLakeType() {
        return lakeType;
    }
}

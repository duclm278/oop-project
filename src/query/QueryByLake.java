package query;

import java.util.ArrayList;

public class QueryByLake extends QueryBy implements QueryGeo {
    public QueryByLake() {
        super();
        ArrayList<String> infoList = getInfoList();
        infoList.add("?s dbp:name ?name.");
        infoList.add("?s dbo:Length ?Length.");
        infoList.add("?s dbo:shoreLength ?shoreLength.");
        infoList.add("?s dbp:basinCountries ?basinCountries.");
        infoList.add("?s dbo:areaTotal ?areaTotal.");
        infoList.add("?s dbp:inflow ?inflow.");
        infoList.add("?s dbp:outflow ?outflow.");
        infoList.add("?s dbp:lakeType ?lakeType.");

        // Add geoInfo to infoList
        addGeoInfo2List(infoList);
    }

    @Override
    public String getOutName() {
        return "Lakes_of_Vietnam";
    }

    @Override
    public String getPagesByTopic() {
        return "?s dct:subject/skos:broader* dbc:Lakes_of_Vietnam.";
    }
}

package query;

import java.util.ArrayList;

public class QueryByLake extends QueryByPlace {
    public QueryByLake() {
        super();
        ArrayList<String> infoList = getInfoList();
        infoList.add("?s dbp:name ?name.");
        infoList.add("?s dbo:length ?length.");
        infoList.add("?s dbo:shoreLength ?shoreLength.");
        infoList.add("?s dbp:basinCountries ?basinCountries.");
        infoList.add("?s dbo:areaTotal ?areaTotal.");
        infoList.add("?s dbp:inflow ?inflow.");
        infoList.add("?s dbp:outflow ?outflow.");
        infoList.add("?s dbp:lakeType ?lakeType.");
    }

    @Override
    public String getOutName() {
        return "Lakes_of_Vietnam";
    }

    @Override
    public String getPagesByTopic() {
        // return "?s dct:subject dbc:Lakes_of_Vietnam.";
        return "?s dct:subject/skos:broader* dbc:Lakes_of_Vietnam.";
    }
}

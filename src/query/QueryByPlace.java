package query;

import java.util.ArrayList;

public abstract class QueryByPlace extends QueryBy implements QueryGeo {
    private ArrayList<String> geoList;

    public QueryByPlace() {
        super();
        geoList = new ArrayList<>();
        geoList.add("?s geo:lat ?geoLat.");
        geoList.add("?s geo:long ?geoLong.");
        geoList.add("?s georss:point ?geoPoint.");
        geoList.add("?s dbp:location ?location.");
        geoList.add("?s dbp:locationCity ?locationCity.");
        geoList.add("?s dbp:locationCountry ?locationCountry.");
    }

    @Override
    public ArrayList<String> getGeoList() {
        return geoList;
    }
}

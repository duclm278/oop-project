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
    }

    @Override
    public ArrayList<String> getGeoList() {
        return geoList;
    }
}

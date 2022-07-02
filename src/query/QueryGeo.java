package query;

import java.util.ArrayList;

public interface QueryGeo {
    public default void addGeoInfo2List(ArrayList<String> inputList) {
        inputList.add("?s geo:lat ?geoLat.");
        inputList.add("?s geo:long ?geoLong.");
        inputList.add("?s georss:point ?geoPoint.");
        inputList.add("?s dbp:location ?location.");
        inputList.add("?s dbp:locationCity ?locationCity.");
        inputList.add("?s dbp:locationCountry ?locationCountry.");
    }
}

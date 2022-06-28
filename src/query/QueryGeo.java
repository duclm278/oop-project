package query;

import java.util.ArrayList;

public interface QueryGeo {
    public ArrayList<String> getGeoList();

    public default String joinGeoBlock(ArrayList<String> geoList) {
        String geoInfo = String.join("\n", geoList);
        return geoInfo;
    }

    public default String joinOptGeoBlock(ArrayList<String> geoList) {
        ArrayList<String> optGeoList = new ArrayList<>();

        // Add OPTIONAL command to each item
        for (String geoItem : geoList) {
            optGeoList.add("OPTIONAL {" + geoItem + "}");
        }

        String optGeoInfo = String.join("\n", optGeoList);
        return optGeoInfo;
    }
}

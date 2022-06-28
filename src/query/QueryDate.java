package query;

import java.util.ArrayList;

public interface QueryDate {
    public ArrayList<String> getDateList();

    public default String joinDateBlock(ArrayList<String> dateList) {
        String dateInfo = String.join("\n", dateList);
        return dateInfo;
    }

    public default String joinOptDateBlock(ArrayList<String> dateList) {
        ArrayList<String> optDateList = new ArrayList<>();

        // Add OPTIONAL command to each item
        for (String dateItem : dateList) {
            optDateList.add("OPTIONAL {" + dateItem + "}");
        }

        String optDateInfo = String.join("\n", optDateList);
        return optDateInfo;
    }
}

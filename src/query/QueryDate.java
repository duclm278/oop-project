package query;

import java.util.ArrayList;

public interface QueryDate {
    public default void addDateInfo2List(ArrayList<String> inputList) {
        inputList.add("...");
        inputList.add("...");
        inputList.add("...");
        inputList.add("...");
        inputList.add("...");
    }
}

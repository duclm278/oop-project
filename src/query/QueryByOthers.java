package query;

public class QueryByOthers extends QueryDBpedia {
    @Override
    public String getOutName() {
        return "Tourist_attractions_in_Vietnam";
    }

    @Override
    public String getPagesByTopic() {
        return "?s dct:subject dbc:Tourist_attractions_in_Vietnam.";
    }
}

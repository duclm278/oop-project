package query;

public abstract class QueryByPlace extends QueryDBpedia {
    public QueryByPlace() {
        super();
        QuerySets.addGeoInfo2List(getInfoList());
    }
}

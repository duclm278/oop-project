package query;

public abstract class QueryByPlace extends QueryBy implements QueryGeo {
    public QueryByPlace() {
        super();
        addGeoInfo2List(getInfoList());
    }
}

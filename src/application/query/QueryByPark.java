package application.query;

public class QueryByPark extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Parks_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Parks_in_Vietnam.";
	}
}

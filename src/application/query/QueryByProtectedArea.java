package application.query;

public class QueryByProtectedArea extends QueryDBpedia {
	@Override
	public String getDefaultOutName() {
		return "Protected_areas_of_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Protected_areas_of_Vietnam.";
	}
}

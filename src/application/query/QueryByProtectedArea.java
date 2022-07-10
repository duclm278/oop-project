package application.query;

public class QueryByProtectedArea extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Protected_areas_of_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Protected_areas_of_Vietnam.";
	}
}

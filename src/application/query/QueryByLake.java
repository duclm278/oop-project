package application.query;

public class QueryByLake extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Lakes_of_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		// return "?s dct:subject dbc:Lakes_of_Vietnam.";
		return "?s dct:subject/skos:broader* dbc:Lakes_of_Vietnam.";
	}
}

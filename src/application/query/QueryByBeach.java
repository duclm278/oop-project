package application.query;

public class QueryByBeach extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Beaches_of_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Beaches_of_Vietnam.";
	}
}

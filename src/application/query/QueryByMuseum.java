package application.query;

public class QueryByMuseum extends QueryDBpedia {
	@Override
	public String getDefaultOutName() {
		return "Museums_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Museums_in_Vietnam.";
	}
}

package application.query;

public class QueryByCave extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Show_caves_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Show_caves_in_Vietnam.";
	}
}

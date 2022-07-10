package application.query;

public class QueryByGarden extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Gardens_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Gardens_in_Vietnam.";
	}
}

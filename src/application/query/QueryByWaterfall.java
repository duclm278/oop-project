package application.query;

public class QueryByWaterfall extends QueryDBpedia {
	@Override
	public String getDefaultOutName() {
		return "Waterfalls_of_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Waterfalls_of_Vietnam.";
	}
}

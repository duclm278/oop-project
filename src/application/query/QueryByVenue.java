package application.query;

public class QueryByVenue extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Entertainment_venues_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		// return "?s dct:subject dbc:Lakes_of_Vietnam.";
		return "?s dct:subject/skos:broader* dbc:Entertainment_venues_in_Vietnam.";
	}
}

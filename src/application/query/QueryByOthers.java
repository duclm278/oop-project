package application.query;

public class QueryByOthers extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Others";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject dbc:Tourist_attractions_in_Vietnam.";
	}
}

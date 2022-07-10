package application.query;

public class QueryByFestival extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Festivals_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject dbc:Festivals_in_Vietnam.";
	}
}

package application.query;

public class QueryBySquare extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Squares_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Squares_in_Vietnam.";
	}
}

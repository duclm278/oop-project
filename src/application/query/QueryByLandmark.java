package application.query;

public class QueryByLandmark extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Landmarks_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Landmarks_in_Vietnam.";
	}
}

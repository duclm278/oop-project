package application.query;

public class QueryByReligiousBuilding extends QueryDBpedia {
	@Override
	public String getOutName() {
		return "Religious_buildings_and_structures_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Religious_buildings_and_structures_in_Vietnam.";
	}
}

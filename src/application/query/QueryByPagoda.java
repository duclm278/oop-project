package application.query;

public class QueryByPagoda extends QueryDBpedia {
	@Override
	public String getDefaultOutName() {
		return "Pagodas_in_Vietnam";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Pagodas_in_Vietnam.";
	}
}

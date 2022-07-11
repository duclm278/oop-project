package application.query;

public class QueryByProvince extends QueryDBpedia {
	private String queryInput;

	public QueryByProvince(String provinceInput) {
		this.queryInput = provinceInput.replace(" ", "_");
		setOutName(getDefaultOutName());
	}

	@Override
	public String getDefaultOutName() {
		return "Tourist_attractions_in_" + queryInput;
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject/skos:broader* dbc:Tourist_attractions_in_" + queryInput + ".";
	}
}

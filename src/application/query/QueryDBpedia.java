package application.query;

import org.apache.jena.rdf.model.Model;

import application.util.AutoPrefix;
import application.util.ISaveModelAs;
import application.util.Processing;

public abstract class QueryDBpedia implements ICrawler {
	public abstract String getOutName();

	public abstract String getPagesByTopic();

	public String getOnlineQueryStr() {
		String QueryStr = "CONSTRUCT {" + "\n" + "?s ?p ?o." + "\n" + "} WHERE {" + " \n"
				+ getPagesByTopic() + "\n" + "?s ?p ?o." + "\n"
				+ "FILTER (!isLITERAL(?o) || LANG(?o) = '' || langMATCHES(lang(?o), 'en') || langMATCHES(lang(?o), 'vn'))"
				+ "\n"
				+ "FILTER (STR(?o) != '')" + "\n"
				+ "FILTER (!CONTAINS(LCASE(STR(?p)), 'wiki'))" + "\n"
				+ "FILTER (!CONTAINS(LCASE(STR(?s)), 'list_of'))" + "\n" + "}";
		return QueryStr;
	}

	@Override
	public void extractData(ISaveModelAs writer, String folderPath) {
		String outName = this.getOutName();

		// Online request to get raw data
		String onlineQueryStr = this.getOnlineQueryStr();
		onlineQueryStr = AutoPrefix.addPrefixes(onlineQueryStr);
		System.out.println(onlineQueryStr);
		System.out.println();
		Model onlineModel = Processing.executeQuery(onlineQueryStr);
		String filePath = folderPath + "/" + outName + ".ttl";
		Processing.writeModel(filePath, onlineModel, writer);
	}
}

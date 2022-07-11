package application.query;

import java.io.IOException;

import org.apache.jena.query.QueryParseException;
import org.apache.jena.rdf.model.Model;

import application.util.AutoPrefix;
import application.util.ISaveModelAs;
import application.util.Processing;

public abstract class QueryDBpedia implements ICrawler {
	private String outName;
	
	public QueryDBpedia() {
		setOutName(getDefaultOutName());
	}
	
	public abstract String getDefaultOutName();

	public abstract String getPagesByTopic();

	public String getOnlineQueryStr() {
		String QueryStr = "CONSTRUCT {" + "\n" + "?s ?p ?o." + "\n" + "} WHERE {" + " \n" + getPagesByTopic() + "\n"
				+ "?s ?p ?o." + "\n"
				+ "FILTER (!isLITERAL(?o) || LANG(?o) = '' || langMATCHES(lang(?o), 'en') || langMATCHES(lang(?o), 'vn'))"
				+ "\n" + "FILTER (STR(?o) != '')" + "\n" + "FILTER (!CONTAINS(LCASE(STR(?p)), 'wiki'))" + "\n"
				+ "FILTER (!CONTAINS(LCASE(STR(?s)), 'list_of'))" + "\n" + "}";
		return QueryStr;
	}

	@Override
	public void extractData(ISaveModelAs writer, String folderPath) throws IOException, NullPointerException, QueryParseException {
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
	
	public String getOutName() {
		return outName;
	}
	
	public void setOutName(String outName) {
		this.outName = outName;
	}
}

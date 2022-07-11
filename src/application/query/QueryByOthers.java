package application.query;

import java.io.IOException;

import application.util.ISaveModelAs;

public class QueryByOthers extends QueryDBpedia {
	@Override
	public String getDefaultOutName() {
		return "Others";
	}

	@Override
	public String getPagesByTopic() {
		return "?s dct:subject dbc:Tourist_attractions_in_Vietnam.";
	}
	
	@Override
	public void extractData(ISaveModelAs writer, String folderPath) throws IOException {
		throw new IOException();
	}
}

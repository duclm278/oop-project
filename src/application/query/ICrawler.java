package application.query;

import application.util.ISaveModelAs;

public interface ICrawler {
	public void extractData(ISaveModelAs writer, String folderPath);
}

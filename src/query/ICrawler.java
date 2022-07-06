package query;

import util.ISaveModelAs;

public interface ICrawler {
    public void extractData(ISaveModelAs writer);
}

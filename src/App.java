import query.ICrawler;
import query.QueryByLake;
import query.QueryByProvince;
import util.ISaveModelAs;
import util.SaveModelAsTurtle;

public class App {
    public static void main(String[] args) {
        // Set writer for Turtle format
        ISaveModelAs writer = new SaveModelAsTurtle();

        // lakeCrawler
        ICrawler lakeCrawler = new QueryByLake();
        lakeCrawler.extractData(writer);

        // provinceCrawler needs provinceInput!
        ICrawler provinceCrawler = new QueryByProvince("An Giang province");
        provinceCrawler.extractData(writer);
    }
}

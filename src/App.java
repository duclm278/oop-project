import query.ICrawler;
import query.QueryByLake;
import query.QueryByProvince;
import util.SaveModelAsTurtle;

public class App {
    public static void main(String[] args) {
        // ICrawler lakeCrawler = new QueryByLake();
        // lakeCrawler.extractData(new SaveModelAsTurtle());

        // This object's constructor needs provinceInput!
        ICrawler provinceCrawler = new QueryByProvince("An Giang province");
        provinceCrawler.extractData(new SaveModelAsTurtle());
    }
}

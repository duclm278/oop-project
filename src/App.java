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
        ICrawler provinceCrawler = null;
        String[] provinceList = new String[] {
            "An Giang province",
            "Cần Thơ",
            "Cao Bằng province",
            "Da Nang",
            "Đồng Nai province",
            "Đồng Tháp province",
            "Ho Chi Minh City",
            "Lào Cai province",
            "Nghệ An province",
            "Ninh Bình province",
            "Ninh Thuận province",
            "Quảng Bình province",
            "Quảng Trị province",
            "Tây Ninh province",
            "Thái Nguyên province",
            "Vĩnh Phúc province"
        };
        for (String province : provinceList) {
            provinceCrawler = new QueryByProvince(province);
            provinceCrawler.extractData(writer);
        }
    }
}

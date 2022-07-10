package application.query;

import java.util.HashMap;

public class QueryByCity extends QueryDBpedia {

	private String cityName;
	// Vì phần đuôi của mỗi city k có quy luật nên cần tạo 1 map để lưu trữ
	private HashMap<String, String> cityList = new HashMap<String, String>();

	public QueryByCity(String cityName) {
		this.cityList.put("hanoi", "Hanoi");
		this.cityList.put("hue", "Huế");
		this.cityList.put("danang", "Da_Nang");
		this.cityList.put("hochiminh", "Ho_Chi_Minh_City");
		this.cityName = cityName.replace(" ", "").toLowerCase();
		if (cityList.containsKey(this.cityName)) {
			this.cityName = cityList.get(this.cityName);
		}
	}

	@Override
	public String getOutName() {
		return "Tourist_attractions_in_" + this.cityName;
	}

	@Override
	public String getPagesByTopic() {

		return "?s dct:subject/skos:broader* dbc:Tourist_attractions_in_" + this.cityName + ".";
	}
}

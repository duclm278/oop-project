package application.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AutoPrefix {
	private static HashMap<String, String> prefixes;

	public static String addPrefixes(String query) {
		prefixes = prefixes();
		StringBuffer prefix = new StringBuffer();
		String temp;
		prefixes.put("dbp:", "<http://dbpedia.org/property/>");
		for (String key : prefixes.keySet()) {
			if (query.contains(key)) {
				temp = "PREFIX " + key + " " + prefixes.get(key) + "\n";
				prefix.append(temp);
			}
		}
		prefix.append(query);
		// System.out.println(prefix.toString());
		return prefix.toString();
	}

	public static HashMap<String, String> prefixes() {
		HashMap<String, String> prefixesName = new HashMap<>();
		String name = "src/application/util/Prefixes.rq";
		try {
			File file = new File(name);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] list = line.split("\\s+");
				prefixesName.put(list[1], list[2]);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prefixesName;
	}
}

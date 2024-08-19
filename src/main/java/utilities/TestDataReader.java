package utilities;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDataReader {
    private JSONObject jsonObject;

    // Constructor that allows multiple JSON files to be loaded and merged
    public TestDataReader(String... fileNames) {
        jsonObject = new JSONObject();
        for (String fileName : fileNames) {
            try {
                Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
                String content = new String(Files.readAllBytes(path));
                JSONObject tempObject = new JSONObject(content);

                // Merge the content of this file into the main jsonObject
                for (String key : tempObject.keySet()) {
                    jsonObject.put(key, tempObject.get(key));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    public String getValue(String key) {
//        return jsonObject.getString(key);
//    }

    public String getValue(String parentKey, String childKey) {
        return jsonObject.getJSONObject(parentKey).getString(childKey);
    }
}

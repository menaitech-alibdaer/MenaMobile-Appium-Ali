package apiBackend;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static String jsonDataGetter(String jsonFile, String key){
        // Initialize ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse the JSON file and extract specific sections
        String selectedRequestBody = null;
        try {
            // Read the JSON file
            JsonNode rootNode = objectMapper.readTree(new File(jsonFile));

            // Choose "test123" or "login" based on your needs
            JsonNode selectedNode = rootNode.get(key); // Change to "login" for login data
            if (selectedNode != null) {
                // Convert the selected node to a JSON string
                selectedRequestBody = objectMapper.writeValueAsString(selectedNode);
            } else {
                throw new RuntimeException("Selected key not found in JSON file");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading or parsing JSON file: " + e.getMessage(), e);
        }

        // Check if the request body was extracted successfully
        if (selectedRequestBody == null) {
            throw new RuntimeException("Failed to extract the request body from JSON file");
        }
        return selectedRequestBody;
    }

}

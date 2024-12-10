package utilities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PDFReader {

    private static final String filePath = "pdfFiles/Salary Slip.pdf";

//    public static String getPdfFile(String filePath){
//        // Load the PDF document
//        try (PDDocument document = PDDocument.load(new File(filePath))) {
//            // Extract text from the PDF
//            PDFTextStripper pdfStripper = null;
//            try {
//                pdfStripper = new PDFTextStripper();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                return pdfStripper.getText(document);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static String getDataFromPdf(String pdfText, String key) {
//        String[] lines = pdfText.split("\\r?\\n");
//        HashMap<String, String> dataMap = new HashMap<>();
//
//        for (String line : lines) {
//            if (line.contains(":")) {
//                String[] parts = line.split(":", 2);
//                if (parts.length == 2) {
//                    dataMap.put(parts[0].trim(), parts[1].trim());
//                }
//            }
//        }
//
//        return dataMap.getOrDefault(key, "Not Found");
//    }

    public static String getPdfFile(String filePath) {
        // Load the PDF document
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            // Extract text from the PDF
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            throw new RuntimeException("Error reading PDF file: " + filePath, e);
        }
    }

    public static String getDataFromPdf(String pdfText, String key) {
        String[] lines = pdfText.split("\\r?\\n");

        for (String line : lines) {
            // Check if the line contains the key
            if (line.contains(key)) {
                // Remove the key and surrounding colon/whitespace
                String value = line.replace(key, "").trim();

                // Remove leading colons or unwanted characters
                if (value.startsWith(":")) {
                    value = value.substring(1).trim();
                }

                // Further clean up and split values
                String[] parts = value.split("\\s+");

                // Extract the first numeric value or return cleaned text
                for (String part : parts) {
                    if (part.matches("\\d+(\\.\\d+)?")) { // Match numeric values
                        return part; // Return the first valid number
                    }
                }

                return value; // Fallback: return the cleaned-up text
            }
        }

        return "Not Found";
    }

    //////////////////////////// Static Path ////////////////////////////////

    public static String getPdfFile() {
        // Load the PDF document
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            // Extract text from the PDF
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            throw new RuntimeException("Error reading PDF file: " + filePath, e);
        }
    }

    public static String getDataFromPdf(String key) {
        String[] lines = getPdfFile().split("\\r?\\n");

        for (String line : lines) {
            // Check if the line contains the key
            if (line.contains(key)) {
                // Remove the key and surrounding colon/whitespace
                String value = line.replace(key, "").trim();

                // Remove leading colons or unwanted characters
                if (value.startsWith(":")) {
                    value = value.substring(1).trim();
                }

                // Further clean up and split values
                String[] parts = value.split("\\s+");

                // Extract the first numeric value or return cleaned text
                for (String part : parts) {
                    if (part.matches("\\d+(\\.\\d+)?")) { // Match numeric values
                        return part; // Return the first valid number
                    }
                }

                return value; // Fallback: return the cleaned-up text
            }
        }

        return "Not Found";
    }

}

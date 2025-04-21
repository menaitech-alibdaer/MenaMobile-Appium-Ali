package utilities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFReader {

    private static final String filePath = "pdfFiles/Salary Slip.pdf";

//    public static String pdfFileReader(String filePath){
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
//    public static String getDataFromSalarySlipPdf(String pdfText, String key) {
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

    public static String pdfFileReader(String filePath) {
        // Load the PDF document
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            // Extract text from the PDF
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            throw new RuntimeException("Error reading PDF file: " + filePath, e);
        }
    }

    public static String getDataFromSalarySlipPdf(String employeeCode, String key) {
        String[] lines = pdfFileReader("pdfFiles/"+employeeCode+".pdf").split("\\r?\\n");

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

    public static String getDataFromSalarySlipPdf_NEW(String employeeCode, String key) {
        String content = pdfFileReader("pdfFiles/" + employeeCode + ".pdf");
        String[] lines = content.split("\\r?\\n");

        for (String line : lines) {
            line = line.trim();

            // Special case for "Total Income" (formatted with **)
            if (key.equals("Total Income") && line.startsWith("**Total Income**")) {
                return line.replace("**Total Income**", "").trim().split(" ")[0];
            }

            // Check for exact key matches (with space or colon after)
            if (line.startsWith(key + " ") || line.startsWith(key + ":") ||
                    line.contains(" " + key + " ") || line.contains("| " + key + " |")) {

                // Extract value by removing key and cleaning
                String value = line.replace(key, "").trim();

                // Remove any |, :, or ** characters
                value = value.replaceAll("[|:*]", "").trim();

                // Split by whitespace and take first numeric part
                String[] parts = value.split("\\s+");
                for (String part : parts) {
                    if (part.matches("\\d+\\.?\\d*")) {
                        return part;
                    }
                }
            }
        }
        return "Not Found";
    }

    //////////////////////////// Static Path ////////////////////////////////

    public static String pdfFileReader() {
        // Load the PDF document
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            // Extract text from the PDF
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            throw new RuntimeException("Error reading PDF file: " + filePath, e);
        }
    }

    public static String getDataFromSalarySlipPdf(String key) {
        String[] lines = pdfFileReader().split("\\r?\\n");

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

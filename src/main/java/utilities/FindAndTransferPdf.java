package utilities;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

import static bases.BaseTest.getAppiumDriver;

public class FindAndTransferPdf {

//    public static void getPDF(){
//
//        // File name to search
//        String fileName = "Salary Slip.pdf";
//
//        // Search for the file using ADB shell command
//        String filePath = "/sdcard/17PDF/Salary Slip.pdf";
//
//        System.out.println("File found at: " + filePath);
//
//        AndroidDriver andr = (AndroidDriver) getAppiumDriver();
//
//        // Pull the PDF file from the mobile device
//        String base64EncodedFile = Arrays.toString(andr.pullFile(filePath));
//        byte[] fileData = Base64.getDecoder().decode(base64EncodedFile);
//
//        // Get the project root path
//        String projectPath = System.getProperty("user.dir");
//
//        // Define the folder name
//        String folderName = "pdfFiles";
//
//        // Construct the folder path
//        String folderPath = projectPath + File.separator + folderName;
//
//        // Path to save the PDF file in the project
//        File pdfFile = new File(folderPath);
//
//        // Write the file to the project folder
//        try (FileOutputStream fileOutputStream = new FileOutputStream(pdfFile)) {
//            fileOutputStream.write(fileData);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("PDF file transferred successfully to: " + folderPath);
//
//    }

    public static void getPDF(String pathDirectory, String fileName) {

        // Search for the file using ADB shell command
        // Path Directory example: "/sdcard/Download/"
        String filePath = pathDirectory+fileName;

        System.out.println("File found at: " + filePath);

        // Get the AndroidDriver instance
        AndroidDriver andr = (AndroidDriver) getAppiumDriver();

        try {
            // Pull the PDF file from the mobile device
            byte[] fileData = andr.pullFile(filePath);

            // Get the project root path
            String projectPath = System.getProperty("user.dir");

            // Define the folder name
            String folderName = "pdfFiles";

            // Construct the folder path
            String folderPath = projectPath + File.separator + folderName;

            // Create the folder if it doesn't exist
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Path to save the PDF file in the project
            File pdfFile = new File(folderPath + File.separator + fileName);

            // Write the file to the project folder
            try (FileOutputStream fileOutputStream = new FileOutputStream(pdfFile)) {
                fileOutputStream.write(fileData);
            }

            System.out.println("PDF file transferred successfully to: " + pdfFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error while transferring PDF file: " + e.getMessage());
            e.printStackTrace();
        }
    }


}

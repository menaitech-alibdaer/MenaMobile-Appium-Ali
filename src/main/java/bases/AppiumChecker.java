package bases;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppiumChecker {

    public static void startAppiumIfNotRunning() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "start", "/B", "appium");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Output Appium logs
                if (line.contains("Appium REST http interface listener started")) {
                    System.out.println("Appium started successfully.");
                    break;
                }else{
                    System.out.println("Appium started already.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopAppium() {
        try {
            String findProcessCommand = "cmd.exe /c tasklist | findstr /i \"node.exe\""; // Appium runs as a node process
            ProcessBuilder findProcessBuilder = new ProcessBuilder(findProcessCommand.split(" "));
            Process findProcess = findProcessBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(findProcess.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("node.exe")) {
                    // Extract the PID of the process and kill it
                    String[] processDetails = line.trim().split("\\s+");
                    String pid = processDetails[1]; // PID is the second column
                    String killCommand = "cmd.exe /c taskkill /PID " + pid + " /F";
                    ProcessBuilder killProcessBuilder = new ProcessBuilder(killCommand.split(" "));
                    killProcessBuilder.start();
                    System.out.println("Appium stopped successfully.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //startAppiumIfNotRunning();

        stopAppium();
        // Continue with your tests here after Appium has started
        System.out.println("Continuing with other tasks...");
    }
}


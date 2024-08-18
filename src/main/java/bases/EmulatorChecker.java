package bases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmulatorChecker {

    private static final String ADB_PATH = "C:\\Users\\ali.b\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe"; // e.g., "C:\\Users\\YourUser\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb"
    private static final String EMULATOR_PATH = "C:\\Users\\ali.b\\AppData\\Local\\Android\\Sdk\\emulator\\emulator.exe"; // e.g., "C:\\Users\\YourUser\\AppData\\Local\\Android\\Sdk\\emulator\\emulator"
    private static final String EMULATOR_NAME = "Ali"; // e.g., "Pixel_3_API_30"

    public static boolean isEmulatorRunning() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(ADB_PATH, "devices");
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("emulator")) {
                    return true; // An emulator is running
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // No emulator is running
    }

    public static void startEmulatorIfNotRunning() {
        if (!isEmulatorRunning()) {
            System.out.println("No emulator is running. Starting emulator...");

            try {
                // Use Windows' start command to run the emulator in a new background process
                ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "start", "/B", EMULATOR_PATH, "-avd", EMULATOR_NAME);
                processBuilder.redirectErrorStream(true);
                processBuilder.start();

                // Wait for the emulator to fully boot
                //waitForEmulatorToBoot();

                System.out.println("Emulator started successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Emulator is already running.");
        }
    }

    public static void main(String[] args) {
        startEmulatorIfNotRunning();

        // Continue with your tests here after the emulator has started
    }

}


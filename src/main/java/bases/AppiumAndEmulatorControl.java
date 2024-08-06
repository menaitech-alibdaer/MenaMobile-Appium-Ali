package bases;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class AppiumAndEmulatorControl {

    private static Process appiumProcess;
    private static Process emulatorProcess;

//    public static void main(String[] args) {
//        try {
//            // Start Appium server
//            startAppium();
//
//            // Start Emulator
//            startEmulator();
//
//            // Start checking if processes are still running
//            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//            scheduler.scheduleAtFixedRate(AppiumAndEmulatorControl::checkProcesses, 0, 5, TimeUnit.SECONDS);
//
//            // Main thread continues to execute other code
//            System.out.println("Appium server and emulator started, proceeding with other tasks...");
//
//            // Add other code here
//            performOtherTasks();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void startAppium() {
        Thread appiumThread = new Thread(() -> {
            try {
                // Command to start Appium
                String command = "appium";

                // Create a ProcessBuilder instance to launch Appium
                ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);
                processBuilder.redirectErrorStream(true);

                // Start the process
                appiumProcess = processBuilder.start();

                // Read the output of the command
                BufferedReader reader = new BufferedReader(new InputStreamReader(appiumProcess.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Wait for the process to complete
                appiumProcess.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        appiumThread.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void startEmulator() {
        Thread emulatorThread = new Thread(() -> {
            try {
                // Path to the emulator directory
                //String emulatorPath = "C:\\Users\\ali.b\\AppData\\Local\\Android\\Sdk\\emulator";
                String emulatorPath = String.valueOf(new File(System.getProperty("user.home")+
                        File.separator +"AppData"+
                        File.separator +"Local"+
                        File.separator +"Android"+
                        File.separator +"Sdk"+
                        File.separator +"emulator"));

                // Name of the AVD to run
                String avdName = "Ali";

                // Create a ProcessBuilder instance to launch the emulator
                ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "emulator", "-avd", avdName);
                processBuilder.directory(new java.io.File(emulatorPath));
                processBuilder.redirectErrorStream(true);

                // Start the process
                emulatorProcess = processBuilder.start();

                // Read the output of the command
                BufferedReader reader = new BufferedReader(new InputStreamReader(emulatorProcess.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Wait for the process to complete
                emulatorProcess.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        emulatorThread.start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void checkProcesses() {
        if (appiumProcess != null && appiumProcess.isAlive()) {
            System.out.println("Appium is still running.");
        } else {
            System.out.println("Appium has stopped.");
        }

        if (emulatorProcess != null && emulatorProcess.isAlive()) {
            System.out.println("Emulator is still running.");
        } else {
            System.out.println("Emulator has stopped.");
        }
    }

    public static void performOtherTasks() {
        // Implement other tasks here
        System.out.println("Performing other tasks...");
        // Example task
        try {
            Thread.sleep(2000); // Simulate a task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Other tasks completed.");
    }
}

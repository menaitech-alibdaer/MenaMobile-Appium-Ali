import io.appium.java_client.AppiumBy;

public class test {

    public static void main(String[] args) {

//        String time = "3:55 AM";
//        // Split the time and period
//        String[] parts = time.split(" ");
//        String timePart = parts[0];
//        String period = parts[1];
//
//        // Split the time part into hours and minutes
//        String[] timeComponents = timePart.split(":");
//        int hour = Integer.parseInt(timeComponents[0]);
//        int minute = Integer.parseInt(timeComponents[1]);
//
//        // Display the results
//        System.out.println("Hour: " + hour);
//        System.out.println("Minutes: " + minute);
//        System.out.println("Period: " + period);

        System.out.println(getTransactionReason());

    }


    public static String getTransactionReason(){
        String getReason = "Reason: \n1Ali Ali Ali123Ali-The Transaction Was Submitted Via Mobile Application";

        int startIndex = getReason.indexOf('\n') + 1;
        int endIndex = getReason.indexOf('-');

        return getReason.substring(startIndex, endIndex);

    }


}

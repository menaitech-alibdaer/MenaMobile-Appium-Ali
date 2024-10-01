import io.appium.java_client.AppiumBy;
import utilities.MobileHelper;

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

        //System.out.println(getTransactionReason());

        //String det = "Hanh Christiansen\nApproved\nAppium Comment - Approve\n26.09.2024 12:55PM";
        String det = "Bethel Olson\nCancel\n01.10.2024 3:03PM";

        int lastNewline = det.lastIndexOf("\n");
        String textAfterLastNewline = det.substring(lastNewline + 1).trim();
        String getDate = textAfterLastNewline.substring(0, 10);

        System.out.println(getDate);

    }

    public static String extractDate(String det) {
        // Check if there is a newline before the date
        int lastNewline = det.lastIndexOf("\n");
        String textAfterLastNewline = det.substring(lastNewline + 1).trim();

        return textAfterLastNewline.substring(0, 10);
    }

    public static String getTransactionReason(){
        String getReason = "Reason: \n1Ali Ali Ali123Ali-The Transaction Was Submitted Via Mobile Application";

        int startIndex = getReason.indexOf('\n') + 1;
        int endIndex = getReason.indexOf('-');

        return getReason.substring(startIndex, endIndex);

    }


}

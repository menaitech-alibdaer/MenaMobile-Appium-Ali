import io.appium.java_client.AppiumBy;
import utilities.MobileHelper;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import static utilities.MssqlConnect.selectQuery;

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

//        String det = "Len Gene Lesch Cronin : \nAli Delegate";
//        String textAfterNewline = det.substring(det.indexOf("\n") + 1);
//        System.out.println(textAfterNewline);

//        selectQuery("select Id from VacationProfiles where NameEn = 'Annual Vacation' and BranchId = 646", "Revamp");

//        System.out.println(formatToThreeFractionDigits(1500));      // 1500.000
//        System.out.println(formatToThreeFractionDigits(1500.5));    // 1500.500
//        System.out.println(formatToThreeFractionDigits(1500.58));   // 1500.580
//        System.out.println(formatToThreeFractionDigits(1500.584));  // 1500.584

//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS");
//        String formattedDate1 = now.withNano(now.getNano() / 100).format(formatter1);
//
//        // Formatting the output
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS");
//        String formattedDate2 = now.with(ChronoField.NANO_OF_SECOND, now.getNano() / 100).format(formatter2);


        // Print the result
//        System.out.println(formattedDate1);
//        System.out.println(formattedDate2);

        //System.out.println(dd());

        System.out.println(formatToThreeFractionDigits("0"));
        System.out.println(formatToThreeFractionDigits("0.51"));
        System.out.println(formatToThreeFractionDigits("0.1"));
        System.out.println(formatToThreeFractionDigits("2"));
        System.out.println(formatToThreeFractionDigits("3.0"));
        System.out.println(formatToThreeFractionDigits("5.3"));


    }

    public static String dd(){
        String input = "Annual Vacation\nCurrent Balance\n2.000\nUp To End Of Year\n0.000";
        String regex = "\\d+(\\.\\d+)?";
        String result = null;

        // Find the match
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            matcher.find();
            String extractedNumber = matcher.group();
            result = extractedNumber;
        } else {
            result = "No number found!";
        }
        return result;
    }

    public static String getApprovalCommittee(String aaaa, String managerName){
        String textBetweenNewlines = null;
        try{
            String det = aaaa;
            boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

            if(containsMoreThanOneNewline){
                textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
            }else{
                textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
            }

            return textBetweenNewlines;

        }catch (Exception e){
            try {
                String det = aaaa;
                boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

                if(containsMoreThanOneNewline){
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
                }else{
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
                }

                return textBetweenNewlines;

            }catch (Exception ex){

                String det = aaaa;
                boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

                if(containsMoreThanOneNewline){
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
                }else{
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
                }

                return textBetweenNewlines;

            }
        }
    }

    public static String formatToThreeFractionDigits(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        return decimalFormat.format(number);
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

    public static String formatToThreeFractionDigits(String numberStr) {
        double number = Double.parseDouble(numberStr);
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        return decimalFormat.format(number);
    }



}

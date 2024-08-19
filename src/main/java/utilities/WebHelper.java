package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class WebHelper {

    private static final Faker fake = new Faker();
    private static final DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
    private static final DateTimeFormatter currentDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static LocalDate date = LocalDate.now();
    //static String currentDate = date.format(currentDateFormatter);
    static String month = date.format(monthFormatter);
    static String year = String.valueOf(Year.now().getValue());
    private static String employeeCodeForMobile;

    // Method to take ScreenShot when the test cases fail

//    public static void captureScreenshot(WebDriver driver, String screenshotName, String error){
//
//        hold(500);
//        TakesScreenshot tsc = (TakesScreenshot) driver;
//        File src = tsc.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(src, new File("Reports/screenshots/" + screenshotName + ".png"));
//        } catch (IOException e) {
//            System.out.println("Exception while taking Screenshot '" + e + "'");
//            throw new RuntimeException(e);
//        }
//
//        //read the image
//        BufferedImage image;
//        try {
//            image = ImageIO.read(new File("Reports/screenshots/" + screenshotName + ".png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        //// This method to write Exception on ScreenShot ////
//        //get the Graphics object
//        Graphics g = image.getGraphics();
//        //set font
//        //g.setFont(g.getFont().deriveFont(25f));
//        g.setFont(new Font("default", Font.BOLD, 20));
//        g.setColor(Color.RED);
//        //display the text at the coordinates(x=50, y=150)
//        g.drawString(error, 20, 875);
//        g.dispose();
//        //write the image
//        try {
//            ImageIO.write(image, "png", new File("Reports/screenshots/" + screenshotName + ".png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    public static String screenshotAsBase64(WebDriver driver){
        String screenshotBase64 = "";
        try {
            screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        }catch (Exception ignored){
            System.out.println("screenshotAsBase64 IGNORED!");
        }
        return screenshotBase64;
    }

    public static int randomNumber() {
        Random r = new Random();
        return ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
    }

    public static int randomNumber2() {
        Random r = new Random();
        return ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
    }

    public static void hold(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String firstName(){
        String str = fake.name().firstName();
        return str.replace("'", "");

    }
    public static String secondName(){
        String str = fake.name().firstName();
        return str.replace("'", "");
    }
    public static String thirdName(){
        String str = fake.name().lastName();
        return str.replace("'", "");
    }
    public static String lastName(){
        String str = fake.name().lastName();
        return str.replace("'", "");
    }
    public static String mobile(){
        return fake.phoneNumber().cellPhone();
    }
    public static String emailAddress(){
        return fake.internet().emailAddress();
    }
    public static String random(int numberOfDigits){
        return fake.number().digits(numberOfDigits);
    }
    public static String passwordGenerator(){
        return fake.internet().password(10,11,true,true,true);
    }

    public static String currentYear(){
        return year;
    }

    public static String currentMonth(){
        return month;
    }
    public static String currentDate(){
        DateTimeFormatter currentDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.now();
        return date.format(currentDateFormatter);
    }
    public static String currentDateMinusDays(int numberOfDays){
        LocalDate date = LocalDate.now().minusDays(numberOfDays);
        return date.format(currentDateFormatter);
    }
    public static String getDaysBetweenTwoDate(String dateBefore, String dateAfter) {

        Date dateB = null;
        try {
            dateB = new SimpleDateFormat("dd/MM/yyyy").parse(dateBefore);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date dateA = null;
        try {
            dateA = new SimpleDateFormat("dd/MM/yyyy").parse(dateAfter);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        long dateBeforeInMs = dateB.getTime();
        long dateAfterInMs = dateA.getTime();

        long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);

        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        // Alternatively:
        // int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
        return String.valueOf(daysDiff);
    }
    public static String getBirthYear(int age){
        return String.valueOf(date.minusYears(age).getYear());
    }
    public static String minusYears(int years){
        return String.valueOf(date.minusYears(years).getYear());
    }
    public static String numberDaysOfCurrentMonth(){
        Calendar c = Calendar.getInstance();
        int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return String.valueOf(monthMaxDays);
    }

    public static String getNextMonth(String format) {
        Calendar currentMonth = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
//        System.out.println("Current month of date : "
//        + dateFormat.format(currentMonth.getTime()));
//        Increment month
        currentMonth.add(Calendar.MONTH, 1);
        return dateFormat.format(currentMonth.getTime());
    }

    public static String getNextMonth() {
        Calendar currentMonth = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("Current month of date : "
//        + dateFormat.format(currentMonth.getTime()));
//        Increment month
        currentMonth.add(Calendar.MONTH, 1);
        return dateFormat.format(currentMonth.getTime());
    }

    public static String converterCalculate(double value, String currency){

        double val = 0.00;
        if(currency.equalsIgnoreCase("USD")){
            val = value * 1.41;
        } else if (currency.equalsIgnoreCase("EUR")) {
            val = value * 1.30;
        }
        DecimalFormat df = new DecimalFormat("####0.00"); /// to return with TWO decimal Digits
        return df.format(val);

    }

    public static void csvUpdate(String fileToUpdate, String replace,
                                 int row, int col)  {

        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(fileToUpdate));

            List<String[]> csvBody = null;

            csvBody = reader.readAll();
            csvBody.get(row)[col] = replace;
            reader.close();
            CSVWriter writer = null;

            writer = new CSVWriter(new FileWriter(fileToUpdate));

            writer.writeAll(csvBody);

            writer.flush();
            writer.close();
        } catch (IOException | CsvException e ) {
            e.printStackTrace();
        }

    }

}

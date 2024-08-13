package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    static ExtentReports extent;
    final static String filePath = "ExtentReport.html";
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static String fileSeparator = File.separator;
    static String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_a").format(Calendar.getInstance().getTime());
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
        	//ExtentSparkReporter html = new ExtentSparkReporter("Reports" +fileSeparator+timeStamp+ ".html");
            ExtentSparkReporter html = new ExtentSparkReporter("Reports" +fileSeparator+filePath);
        	html.config().setDocumentTitle("Automation Framework");
        	html.config().setReportName("HRMS System");
        	html.config().setTheme(Theme.DARK);
            //html.config().setProtocol(Protocol.HTTP);
            html.config().setOfflineMode(true);
            html.viewConfigurer().viewOrder().as(new ViewName[]{
                ViewName.DASHBOARD, ViewName.TEST,
                ViewName.EXCEPTION, ViewName.DEVICE,
                ViewName.CATEGORY, ViewName.AUTHOR,
                ViewName.LOG}).apply();
            extent = new ExtentReports();
            extent.attachReporter(html);
        }
        
        return extent;
    }
    
    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getReporter().createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public static void setLog(String text){
        if (ExtentReport.getTest()!=null) {
            ExtentReport.getTest().log(Status.INFO, text);
        }
    }
}

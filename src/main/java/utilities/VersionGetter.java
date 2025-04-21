package utilities;

import io.reactivex.rxjava3.annotations.NonNull;

import static org.testng.Assert.fail;
import static utilities.MssqlConnect.liteVersion;

public class VersionGetter {

    @NonNull
    protected static String systemVersion = null;
    @NonNull
    protected static boolean liteVersion = Boolean.parseBoolean(System.getProperty("liteVersion","false"));
    @NonNull
    protected static String versionURL = null;
    @NonNull
    protected static String menaMeURL = null;
    @NonNull
    protected static String browsers = "chrome";

    public static void versionSetter(String setVersion){
        if(setVersion.equalsIgnoreCase("AUG")){
            systemVersion = System.getProperty("systemVersion","AUG");
        }else if(setVersion.equalsIgnoreCase("OCT")){
            systemVersion = System.getProperty("systemVersion","OCT");
        }else if(setVersion.equalsIgnoreCase("JUL")){
            systemVersion = System.getProperty("systemVersion","JUL");
        }else if(setVersion.equalsIgnoreCase("Revamp")){
            systemVersion = System.getProperty("systemVersion","Revamp");
        }else{
            systemVersion = System.getProperty("systemVersion","Revamp");
            System.out.println("Run default value version : "+systemVersion);
        }
    }

    public static String versionGetter() {
        String sv = null;
        if(systemVersion == null){
            fail("System Version not exist!");
        }else{
            sv = systemVersion;
        }
        return sv;
    }

    public static void liteSetter(boolean lite){
        if(lite){
            liteVersion("1");
            liteVersion = Boolean.parseBoolean(System.getProperty("liteVersion","true"));
        }else{
            liteVersion("0");
            liteVersion = Boolean.parseBoolean(System.getProperty("liteVersion","false"));
        }
        System.out.println("Lite Version: "+lite);
    }

    public static boolean liteGetter(){
        return liteVersion;
    }

    public static void urlSetter(String version){
        if(version.equalsIgnoreCase("AUG")){
            versionURL = "https://nowaf.menaitech.com/menas01_08_2022_sql2016/application/hrms/";
            menaMeURL = "https://nowaf.menaitech.com/menas01_08_2022_sql2016/application/hrms/MenaME";
        }else if(version.equalsIgnoreCase("OCT")){
            versionURL = "https://qc.menaitech.com/menas01_10_2020_sql2016/application/hrms/";
            menaMeURL = "https://qc.menaitech.com/menas01_10_2020_sql2016/application/hrms/MenaME";
        }else if(version.equalsIgnoreCase("JUL")){
            versionURL = "https://nowaf.menaitech.com/MenaS01_07_2024_SQL2016/application/hrms/";
            menaMeURL = "https://nowaf.menaitech.com/MenaS01_07_2024_SQL2016/application/hrms/MenaME";
        }else if(version.equalsIgnoreCase("Revamp")){
            versionURL = "https://pay-dev.menaitech.com/mobileapi/mobileapi/";
            menaMeURL = "https://pay-dev.menaitech.com/MenaME-Revamp/";
        }else{
            System.out.println("Run default value URL : https://nowaf.menaitech.com/menas01_08_2022_sql2016/application/hrms/");
        }
    }

    public static String urlGetter(){
        return versionURL;
    }
    public static String urlMenaMeGetter(){
        return menaMeURL;
    }
    public static void browserSetter(String browser){
        browsers = browser;
    }
    public static String browserGetter(){
        return browsers;
    }

}

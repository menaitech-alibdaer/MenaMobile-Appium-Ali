package utilities;

import io.reactivex.rxjava3.annotations.NonNull;

import static utilities.MssqlConnect.liteVersion;

public class VersionGetter {

    @NonNull
    protected static String systemVersion = System.getProperty("systemVersion","JUL");
    @NonNull
    protected static boolean liteVersion = Boolean.parseBoolean(System.getProperty("liteVersion","false"));
    @NonNull
    protected static String versionURL = "https://nowaf.menaitech.com/MenaS01_07_2024_SQL2016/application/hrms/";
    @NonNull
    protected static String menaMeURL = "https://nowaf.menaitech.com/MenaS01_07_2024_SQL2016/application/hrms/MenaME";
    @NonNull
    protected static String browsers = "chrome";

    public static void versionSetter(String setVersion){
        if(setVersion.equalsIgnoreCase("AUG")){
            systemVersion = System.getProperty("systemVersion","AUG");
        }else if(setVersion.equalsIgnoreCase("OCT")){
            systemVersion = System.getProperty("systemVersion","OCT");
        }else if(setVersion.equalsIgnoreCase("JUL")){
            systemVersion = System.getProperty("systemVersion","JUL");
        }else{
            System.out.println("Run default value version : AUG");
        }
    }

    public static String versionGetter() {
        return systemVersion;
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
            versionURL = "https://nowaf.menaitech.com/menas01_10_2020_sql2016/application/hrms/";
            menaMeURL = "https://nowaf.menaitech.com/menas01_10_2020_sql2016/application/hrms/MenaME";
        }else if(version.equalsIgnoreCase("JUL")){
            versionURL = "https://nowaf.menaitech.com/MenaS01_07_2024_SQL2016/application/hrms/";
            menaMeURL = "https://nowaf.menaitech.com/MenaS01_07_2024_SQL2016/application/hrms/MenaME";
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

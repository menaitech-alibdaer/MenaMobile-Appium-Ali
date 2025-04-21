package utilities;

import bases.WebBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.fail;
import static utilities.ExtentReport.setLog;
import static utilities.MobileHelper.encryptSHA1;
import static utilities.VersionGetter.liteGetter;
import static utilities.VersionGetter.versionGetter;

public class MssqlConnect extends WebBase {

    public static String AUG_database = "menas01_08_2022_sql2016";
    public static String OCT_database = "menas01_10_2020_sql2016";
    public static String JUL_database = "MenaS01_07_2024_sql2016";
    public static String revamp_database = "Payroll";

    public static void sqlQuery(String Query){

        String db = null;

        if(versionGetter().equalsIgnoreCase("OCT")){
            db = OCT_database;
        }else if(versionGetter().equalsIgnoreCase("AUG")){
            db = AUG_database;
        }else if(versionGetter().equalsIgnoreCase("JUL")){
            db = JUL_database;
        }else if(versionGetter().equalsIgnoreCase("Revamp")){
            db = revamp_database;
        }else{
            fail("Database Name not exist");
        }

        String host;
        String username;
        String password;

        if(db.equals(revamp_database)){
            host = "jdbc:sqlserver://DEVELOPMENTSRV;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "sa";
            password = "12345678";
        }else{
            host = "jdbc:sqlserver://20.79.90.124:1432;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "qcUser";
            password = "P@ssw0rd@qc@789";
        }

        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            Statement statement = connection.createStatement();
            statement.execute(Query);
            connection.close();

            System.out.println("Database Name: "+db);
            System.out.println("This query executed: "+Query);

            setLog("Database Name: "+db);
            setLog("query executed: "+Query);

        } catch (SQLException e) {
            System.out.println("There's an error:");
            e.printStackTrace();
        }

    }

    public static void sqlQuery(String Query, String dataBase){

        String db = null;

        if(dataBase.equalsIgnoreCase("OCT")){
            db = OCT_database;
        }else if(dataBase.equalsIgnoreCase("AUG")){
            db = AUG_database;
        }else if(dataBase.equalsIgnoreCase("JUL")){
            db = JUL_database;
        }else if(dataBase.equalsIgnoreCase("Revamp")){
            db = revamp_database;
        }else{
            fail("Database Name not exist");
        }

        String host;
        String username;
        String password;

        if(db.equals(revamp_database)){
            host = "jdbc:sqlserver://DEVELOPMENTSRV;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "sa";
            password = "12345678";
        }else{
            host = "jdbc:sqlserver://20.79.90.124:1432;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "qcUser";
            password = "P@ssw0rd@qc@789";
        }

        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            Statement statement = connection.createStatement();
            statement.execute(Query);
            connection.close();

            System.out.println("Database Name: "+db);
            System.out.println("This query executed: "+Query);

            setLog("Database Name: "+db);
            setLog("query executed: "+Query);

        } catch (SQLException e) {
            System.out.println("There's an error:");
            e.printStackTrace();
        }

    }

    public static String selectQuery(String query) {
        StringBuilder result = new StringBuilder();
        String db = null;

        // Determine the database name based on the version
        if (versionGetter().equalsIgnoreCase("OCT")) {
            db = OCT_database;
        } else if (versionGetter().equalsIgnoreCase("AUG")) {
            db = AUG_database;
        } else if (versionGetter().equalsIgnoreCase("JUL")) {
            db = JUL_database;
        } else if (versionGetter().equalsIgnoreCase("Revamp")) {
            db = revamp_database;
        }else{
            fail("Database Name not exist");
        }

        String host;
        String username;
        String password;

        if(db.equals(revamp_database)){
            host = "jdbc:sqlserver://DEVELOPMENTSRV;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "sa";
            password = "12345678";
        }else{
            host = "jdbc:sqlserver://20.79.90.124:1432;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "qcUser";
            password = "P@ssw0rd@qc@789";
        }

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(host, username, password);
            Statement statement = connection.createStatement();

            // Execute the SQL query and retrieve the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieve metadata about the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Process the result set
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    result.append(columnValue);

                    if (i < columnCount) {
                        result.append(", ");
                    }
                }
                result.append("\n");  // Add a newline for each row
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Database Name: " + db);
            System.out.println("Query executed: " + query);

            setLog("Database Name: " + db);
            setLog("Query executed: " + query);

        } catch (SQLException e) {
            System.out.println("There's an error:");
            e.printStackTrace();
        }

        return result.toString();  // Return the result as a string
    }

    public static String selectQuery(String query, String dataBase) {
        StringBuilder result = new StringBuilder();
        String db = null;

        if(dataBase.equalsIgnoreCase("OCT")){
            db = OCT_database;
        }else if(dataBase.equalsIgnoreCase("AUG")){
            db = AUG_database;
        }else if(dataBase.equalsIgnoreCase("JUL")){
            db = JUL_database;
        }else if(dataBase.equalsIgnoreCase("Revamp")){
            db = revamp_database;
        }else{
            fail("Database Name not exist");
        }

        String host;
        String username;
        String password;

        if(db.equals(revamp_database)){
            host = "jdbc:sqlserver://DEVELOPMENTSRV;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "sa";
            password = "12345678";
        }else{
            host = "jdbc:sqlserver://20.79.90.124:1432;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "qcUser";
            password = "P@ssw0rd@qc@789";
        }

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(host, username, password);
            Statement statement = connection.createStatement();

            // Execute the SQL query and retrieve the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieve metadata about the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Process the result set
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    result.append(columnValue);

                    if (i < columnCount) {
                        result.append(", ");
                    }
                }
                result.append("\n");  // Add a newline for each row
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Database Name: " + db);
            System.out.println("Query executed: " + query);

            setLog("Database Name: " + db);
            setLog("Query executed: " + query);

        } catch (SQLException e) {
            System.out.println("There's an error:");
            e.printStackTrace();
        }

        return result.toString();  // Return the result as a string
    }


    public static void clientIdChanger(String clientId, String company){

        if(clientId.equalsIgnoreCase("NULL")){

            if(company.isEmpty()){
                MssqlConnect.sqlQuery("update adm_company set Client_id=NULL");
            }else{
                MssqlConnect.sqlQuery("update adm_company set Client_id=NULL where company_code = '"+company+"'");
            }

        }else{

            if(company.isEmpty()){
                MssqlConnect.sqlQuery("update adm_company set Client_id='"+clientId+"'");
            }else{
                MssqlConnect.sqlQuery("update adm_company set Client_id='"+clientId+"' where company_code = '"+company+"'");
            }

        }

    }

    public static void clientIdChanger(String clientId){

        if(clientId.equalsIgnoreCase("NULL") || clientId.isEmpty()){
            MssqlConnect.sqlQuery("update adm_company set Client_id=NULL");
        }else{
            MssqlConnect.sqlQuery("update adm_company set Client_id='"+clientId+"'");
        }

    }

    public static void menaMeRestPassword(String employeeCode){
        sqlQuery("update pay_employees set password='356a192b7913b04c54574d18c28d46e6395428ab' where employee_code='"+employeeCode+"'");
    }

    public static void menaMeSetPassword(String employeeCode, String password){
        String sha1 = encryptSHA1(password);
        sqlQuery("update pay_employees set password='"+sha1+"' where employee_code='"+employeeCode+"'");
    }

    public static void restFamilySetup(){
        sqlQuery("update pay_setup set Wife_Allowance_Code = 10, Child_Allowance_Code = 9, wife_allow_amount = 50, child_allowance_type = 1, child_all_allow = 0, wife_all_allow = 0 where branch_code = 'auto_a1' and company_code = 'automation';");
    }

    public static void restChildSort(){
        sqlQuery("DELETE FROM suggest_child_allowance where branch_code = 'auto_a1' and company_code = 'automation';" +
                "INSERT INTO suggest_child_allowance (internal_serial, child_sort, amount, branch_code, company_code) VALUES ('1', '1', '20', 'Auto_a1', 'Automation');" +
                "INSERT INTO suggest_child_allowance (internal_serial, child_sort, amount, branch_code, company_code) VALUES ('2', '2', '15', 'Auto_a1', 'Automation');" +
                "INSERT INTO suggest_child_allowance (internal_serial, child_sort, amount, branch_code, company_code) VALUES ('3', '3', '10', 'Auto_a1', 'Automation');");
    }

    public static void queryRestSetup(){

        if(liteGetter()){
            liteVersion("1");
        }else{
            liteVersion("0");
        }

        if(getBranch().equalsIgnoreCase("auto_a1")){

            sqlQuery("update adm_branch set Employee_Auto_Serial = 0, is_calc_with_previous = 0 where branch_code = 'auto_a1' and company_code = 'automation'; " +
                    "update pay_setup set english_arabic_man = 2, is_setup_overtime_hours = 0, is_calendar_days = 2, cut_off_date = 0, Wife_Allowance_Code = 10, Child_Allowance_Code = 9, wife_allow_amount = 50, child_allowance_type = 1, child_all_allow = 0, wife_all_allow = 0, allowance_per_date = 1, social_by_default = 0, non_citizen_social_by_default = 0 where branch_code = 'auto_a1' and company_code = 'automation'; " +
                    "update adm_company set is_retroactive_salaries = 0 where company_code='automation';update pay_setup set allowance_per_date = 1 where branch_code = 'auto_a1' and company_code = 'automation'");

            ///////////////////////

        }else if(getBranch().equalsIgnoreCase("auto_a3") || getBranch().equalsIgnoreCase("auto_a4")){
            socialSecurityStartMonth("0");
        }else if(getBranch().equalsIgnoreCase("auto_a5") || getBranch().equalsIgnoreCase("auto_a6") || getBranch().equalsIgnoreCase("auto_a7") || getBranch().equalsIgnoreCase("auto_a8")){
            insuranceStartMonth("0");
        }else if(getBranch().equalsIgnoreCase("auto_a11") || getBranch().equalsIgnoreCase("auto_a12")){
            allowancesCalculatedAccordingToDate(true, getBranch());
        }else if(getBranch().equalsIgnoreCase("auto_a14") || getBranch().equalsIgnoreCase("auto_a15") || getBranch().equalsIgnoreCase("auto_a16") || getBranch().equalsIgnoreCase("auto_a18") || getBranch().equalsIgnoreCase("auto_a19")){
            sqlQuery("update adm_branch set is_gulf = 1, is_cut_paid_vac_allows = 1, distribute_absence = 1 where branch_code = '"+getBranch()+"'");
        }else if(getBranch().equalsIgnoreCase("auto_a20")){
            sqlQuery("update adm_branch set is_gulf = 1, distribute_absence = 0 where branch_code = '"+getBranch()+"'");
        }

    }

    public static void liteVersion(String flag){
        sqlQuery("update HRMS_config set lite = "+flag+";");
    }

    public static void allowancesCalculatedAccordingToDate(boolean checkbox, String branch){

        if(checkbox){
            sqlQuery("update pay_setup set allowance_per_date = 1 where branch_code = '"+branch+"' and company_code = 'automation'");
        }else{
            sqlQuery("update pay_setup set allowance_per_date = 0 where branch_code = '"+branch+"' and company_code = 'automation'");
        }

    }

    public static void automaticallySubmitEmployeeToSocialSecurity(boolean checkbox){

        if(checkbox){
            sqlQuery("update pay_setup set social_by_default = 1, non_citizen_social_by_default = 1 where company_code = 'automation' and branch_code = 'auto_a3';");
        }else{
            sqlQuery("update pay_setup set social_by_default = 0, non_citizen_social_by_default = 0 where company_code = 'automation' and branch_code = 'auto_a3';");
        }
    }

    public static void automaticallySubmitEmployeeToHealthInsurance(boolean checkbox){

        if(checkbox){
            sqlQuery("update pay_setup set insurance_by_default = 1 where company_code = 'automation' and branch_code = 'auto_a1';");
        }else{
            sqlQuery("update pay_setup set insurance_by_default = 0 where company_code = 'automation' and branch_code = 'auto_a1';");
        }
    }

    public static void socialSecurityStartMonth(String month){

        if(!month.isEmpty()){
            sqlQuery("update pay_setup set social_security_starts = "+month+" where company_code = 'automation';");
        }else{
            sqlQuery("update pay_setup set social_security_starts = 0 where company_code = 'automation';");
        }
    }

    public static void insuranceStartMonth(String month){

        if(!month.isEmpty()){
            sqlQuery("update pay_setup set insurance_start = "+month+" where company_code = 'automation';");
        }else{
            sqlQuery("update pay_setup set insurance_start = 0 where company_code = 'automation';");
        }
    }

    public static void setMenaMePassword(String employeeCode, String dataBase){
        /////// Set Password: sa
        sqlQuery("UPDATE EmployeeGeneralInfo " +
                "SET " +
                "MenaMEPasswordHash = CONVERT(varbinary(max), '0x37D09C4D9E4F7A94B67B4AFF3A3845F6C2785D79A3FA4D37E580E21A543BF0DAFF4A2F2D6742D2CA76E292E9677B2E10AB6E072C83669DA7C9BB6CD17057BB83', 1), " +
                "MenaMEPasswordSalt = CONVERT(varbinary(max), '0xDEC780C9441D12B48AD19D5F9070A4D95E4C875758416EB74DE162D4AD17E3CEE9FFF60A31C7FE74A7C1F946D25067A1563E423BF7D32F7E0CF9259EA9B0B895E22CB1C40A70367554626A6F8B7A3C4AD44FC6C37D1C6A5830D2FF6805A55DA7DE6314835B914C5C9111EB04C69C3F04C1C19FC31FB1BCD23CB4A7580EB45A71', 1) " +
                "WHERE EmployeeCode = '"+employeeCode+"';", dataBase);
    }

    public static List<String[]> selectQueryAll(String query){

        List<String[]> result = new ArrayList<>();

        String db = null;

        // Determine the database name based on the version
        if (versionGetter().equalsIgnoreCase("OCT")) {
            db = OCT_database;
        } else if (versionGetter().equalsIgnoreCase("AUG")) {
            db = AUG_database;
        } else if (versionGetter().equalsIgnoreCase("JUL")) {
            db = JUL_database;
        } else if (versionGetter().equalsIgnoreCase("Revamp")) {
            db = revamp_database;
        }else{
            fail("Database Name not exist");
        }

        String host;
        String username;
        String password;

        if(db.equals(revamp_database)){
            host = "jdbc:sqlserver://DEVELOPMENTSRV;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "sa";
            password = "12345678";
        }else{
            host = "jdbc:sqlserver://20.79.90.124:1432;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
            username = "qcUser";
            password = "P@ssw0rd@qc@789";
        }

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(host, username, password);
            Statement statement = connection.createStatement();

            // Execute the SQL query and retrieve the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieve metadata about the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Process the result set
            while (resultSet.next()) {
                String[] row = new String[columnCount];  // Create an array for the current row
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getString(i); // Store column value in the array
                }
                result.add(row);  // Add the row array to the result list
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Database Name: " + db);
            System.out.println("Query executed: " + query);

            setLog("Database Name: " + db);
            setLog("Query executed: " + query);

        } catch (SQLException e) {
            System.out.println("There's an error:");
            e.printStackTrace();
        }

        return result;  // Return the list of arrays
    }

    public static List<Map<String, String>> selectQueryAll2(String query) {

        List<Map<String, String>> result = new ArrayList<>();

        String db = null;

        // Determine the database name based on the version
        if (versionGetter().equalsIgnoreCase("OCT")) {
            db = OCT_database;
        } else if (versionGetter().equalsIgnoreCase("AUG")) {
            db = AUG_database;
        } else if (versionGetter().equalsIgnoreCase("JUL")) {
            db = JUL_database;
        } else if (versionGetter().equalsIgnoreCase("Revamp")) {
            db = revamp_database;
        } else {
            fail("Database Name not exist");
        }

        String host;
        String username;
        String password;

        if (db.equals(revamp_database)) {
            host = "jdbc:sqlserver://DEVELOPMENTSRV;databaseName=" + db + ";encrypt=true;trustServerCertificate=true;";
            username = "sa";
            password = "12345678";
        } else {
            host = "jdbc:sqlserver://20.79.90.124:1432;databaseName=" + db + ";encrypt=true;trustServerCertificate=true;";
            username = "qcUser";
            password = "P@ssw0rd@qc@789";
        }

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(host, username, password);
            Statement statement = connection.createStatement();

            // Execute the SQL query and retrieve the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Retrieve metadata about the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Process the result set
            while (resultSet.next()) {
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);  // Get column name
                    String columnValue = resultSet.getString(i);    // Get column value
                    row.put(columnName, columnValue);               // Add to the map
                }
                result.add(row);  // Add the row map to the result list
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Database Name: " + db);
            System.out.println("Query executed: " + query);

            setLog("Database Name: " + db);
            setLog("Query executed: " + query);

        } catch (SQLException e) {
            System.out.println("There's an error:");
            e.printStackTrace();
        }

        return result;  // Return the list of maps

    }


}


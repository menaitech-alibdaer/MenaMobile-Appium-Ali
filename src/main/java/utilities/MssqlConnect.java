package utilities;

import bases.WebBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

import static utilities.ExtentReport.setLog;
import static utilities.MobileHelper.encryptSHA1;
import static utilities.VersionGetter.liteGetter;
import static utilities.VersionGetter.versionGetter;

public class MssqlConnect extends WebBase {

    public static String AUG_database = "menas01_08_2022_sql2016";
    public static String OCT_database = "menas01_10_2020_sql2016";
    public static String JUL_database = "MenaS01_07_2024_sql2016";

    public static void sqlQuery(String Query){

        String db = null;

        if(versionGetter().equalsIgnoreCase("OCT")){
            db = OCT_database;
        }else if(versionGetter().equalsIgnoreCase("AUG")){
            db = AUG_database;
        }else if(versionGetter().equalsIgnoreCase("JUL")){
            db = JUL_database;
        }

        String host = "jdbc:sqlserver://20.79.90.124:1432;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
        String username = "qcUser";
        String password = "P@ssw0rd@qc@789";

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
        }

        String host = "jdbc:sqlserver://20.79.90.124:1432;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
        String username = "qcUser";
        String password = "P@ssw0rd@qc@789";

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
        }

        String host = "jdbc:sqlserver://20.79.90.124:1432;databaseName="+db+";encrypt=true;trustServerCertificate=true;";
        String username = "qcUser";
        String password = "P@ssw0rd@qc@789";

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

    public static void countryProfileChanger(String countryProfile, String branchCode){

        if(countryProfile.equalsIgnoreCase("Jordan")){
            MssqlConnect.sqlQuery("update adm_branch set country_profile=1 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("KSA")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=2 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Palestine")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=3 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Qatar")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=4 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Lebanon")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=5 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Kuwait")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=6 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Libya")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=7 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Sudan")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=8 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Syria")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=9 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Singapore")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=10 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Egypt")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=11 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("UAE")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=12 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Oman")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=13 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Algeria")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=14 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Tunisia")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=15 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Morocco")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=16 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Iraq")) {
            MssqlConnect.sqlQuery("update adm_branch set country_profile=17 where branch_code = '"+branchCode+"'");
        } else {
            Assert.fail("Country Profile Not Exist!");
        }

    }

    public static void taxProfileChanger(String countryProfile, String branchCode){

        if(countryProfile.equalsIgnoreCase("Jordan Tax")){
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=1 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("West Bank Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=2 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Jerusalem Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=3 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Lebanese Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=4 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Libyan Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=5 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Syrian Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=6 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Sudan Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=7 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Algerian Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=8 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Egyptian Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=9 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Tunisian Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=10 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Moroccan Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=11 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Iraq Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=12 where branch_code = '"+branchCode+"'");
        } else if (countryProfile.equalsIgnoreCase("Yemeni Tax")) {
            MssqlConnect.sqlQuery("update adm_branch set tax_profile=13 where branch_code = '"+branchCode+"'");
        } else {
            Assert.fail("Tax Profile Not Exist!");
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

    public static void deleteDynamicList(String branchCode){
        sqlQuery("DELETE FROM Dynamic_lists_employees WHERE list_serial = 1 and branch_code = '"+branchCode+"' and company_code = 'automation';" +
                "DELETE FROM Dynamic_lists WHERE list_serial = 1 and branch_code = '"+branchCode+"' and company_code = 'automation'");
    }
    public static void createDynamicList(String branchCode){
        deleteDynamicList(branchCode);
        sqlQuery("INSERT INTO Dynamic_lists (company_code, branch_code, list_serial, list_name_e, list_name_a, Excluded_Dynamic_List) VALUES ('Automation', '"+branchCode+"', '1', 'auto_list', 'auto_list', NULL);");
    }
    public static void addEmployeeToDynamicList(String branchCode, String employeeCode){
        sqlQuery("INSERT INTO Dynamic_lists_employees (company_code, branch_code, list_serial, employee_code, Excluded_Emp) VALUES ('Automation', '"+branchCode+"', '1', '"+employeeCode+"', NULL);");
    }
    public static void allowancesCalculatedAccordingToDate(boolean checkbox, String branch){

        if(checkbox){
            sqlQuery("update pay_setup set allowance_per_date = 1 where branch_code = '"+branch+"' and company_code = 'automation'");
        }else{
            sqlQuery("update pay_setup set allowance_per_date = 0 where branch_code = '"+branch+"' and company_code = 'automation'");
        }

    }

    public static void raisesTransactionsEffectAccordingToRaiseDate(boolean checkbox, String branch){

        if(checkbox){
            sqlQuery("update pay_setup set raise_per_date = 1 where branch_code = '"+branch+"' and company_code = 'automation'");
        }else{
            sqlQuery("update pay_setup set raise_per_date = 0 where branch_code = '"+branch+"' and company_code = 'automation'");
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

    public static void shiftAllowance(String type){
        if(type.equalsIgnoreCase("fixed")){

            sqlQuery("update pay_code_tables set shift_allowance = 1  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift Allowance';" +
                    "update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Percent - Allowance';" +
                    "update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Withhold - Allowance';");

        }else if(type.equalsIgnoreCase("percent")){

            sqlQuery("update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift Allowance';" +
                    "update pay_code_tables set shift_allowance = 1  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Percent - Allowance';" +
                    "update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Withhold - Allowance';");

        }else if(type.equalsIgnoreCase("withhold")){

            sqlQuery("update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift Allowance';" +
                    "update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Percent - Allowance';" +
                    "update pay_code_tables set shift_allowance = 1  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Withhold - Allowance';");

        }else if(type.isEmpty()){

            sqlQuery("update pay_code_tables set shift_allowance = 1  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift Allowance';" +
                    "update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Percent - Allowance';" +
                    "update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Withhold - Allowance';");

        }else{

            sqlQuery("update pay_code_tables set shift_allowance = 1  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift Allowance';" +
                    "update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Percent - Allowance';" +
                    "update pay_code_tables set shift_allowance = 0  where branch_code = 'auto_a1' and company_code = 'automation' and system_desp_e = 'Shift - Withhold - Allowance';");

        }

    }

    @Test
    public void test(){
        sqlQuery("update pay_employees set password='356a192b7913b04c54574d18c28d46e6395428ab' where employee_code='testa22'", "aug");
    }

    @Test
    public void test1(){
        sqlQuery("update pay_setup set auto_delegate_before_vacation = 0 where branch_code = 'auto_mob1'", "jul");
    }

}


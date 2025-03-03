package bases;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.DecimalFormat;

import static apiBackend.CompanyAndBranch.getBranchId;
import static utilities.MssqlConnect.selectQuery;

public class ApiBase {

    private static final String baseUrl = "https://pay-dev.menaitech.com/payrollapi/api";

    protected static String employeeCode;
    protected static String firstName;
    protected static String secondName;
    protected static String thirdName;
    protected static String lastName;
    protected static int employeeId = 0;
    protected static int insuranceId = 0;

    public static String baseUrlApiGetter(){
        return baseUrl;
    }

    public static String employeeCodeGenerator(){
        return RandomStringUtils.random(4, true, false).toLowerCase() + RandomStringUtils.random(5, false, true);
    }

    public static void employeeCodeSetter(String empCode){
        employeeCode = empCode;
    }

    public static String employeeCodeGetter(){
        return employeeCode;
    }

    public static int getIdByEmployeeCode(String employeeCode){
        return Integer.parseInt(selectQuery("select EmployeeId from EmployeeGeneralInfo where EmployeeCode = '"+employeeCode+"'").trim());
    }

    public static void employeeIdSetter(String empCode){
        employeeId = Integer.parseInt(selectQuery("select EmployeeId from EmployeeGeneralInfo where EmployeeCode = '"+empCode+"' and BranchId = "+getBranchId()).trim());
    }

    public static int employeeIdGetter(){
        return employeeId;
    }

    public static void employeeInsuranceIdSetter(int employeeId){
        insuranceId = Integer.parseInt(selectQuery("select InsuranceId from EmployeeFinancialInsurances where employeeId = '"+employeeId+"'").trim());
    }

    public static int employeeInsuranceIdGetter(){
        return insuranceId;
    }

    public static void setFirstName(String name){
        firstName = name;
    }
    public static void setSecondName(String name){
        secondName = name;
    }
    public static void setThirdName(String name){
        thirdName = name;
    }
    public static void setLastName(String name){
        lastName = name;
    }
    public static String getFirstName(){
        return firstName;
    }
    public static String getSecondName(){
        return secondName;
    }
    public static String getThirdName(){
        return thirdName;
    }
    public static String getLastName(){
        return lastName;
    }

    public static String formatToThreeFractionDigits(String numberStr) {
        double number = Double.parseDouble(numberStr);
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        return decimalFormat.format(number);
    }

}

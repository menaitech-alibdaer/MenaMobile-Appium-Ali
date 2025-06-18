package apiBackend;

import bases.ApiBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static apiBackend.CompanyAndBranch.getBranchId;
import static apiBackend.CompanyAndBranch.getCompanyId;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.fail;
import static utilities.MssqlConnect.*;
import static utilities.WebHelper.*;
import static utilities.WebHelper.thirdName;
import static utilities.apiHelper.getCurrentDate;

public class Employees extends ApiBase {

    protected String employeeCode = null;
    protected String fullNameEmployee = null;
    protected String firstAndLastNameEmployee;

    public String getEmployeeCode(){
        return employeeCode;
    }
    public String getFullNameEmployee(){
        return fullNameEmployee;
    }
    public String getFirstAndLastNameEmployee(){
        return firstAndLastNameEmployee;
    }

    public void createNewEmployee(String birthDate, String email, String gender, String martialStatus, String nationality, String religion, String mobile,
                                  String site, String department, String section, String division, String unit, String subSection, String subDivision, String subUnit,
                                  String office, String team, String hiringDate, String employmentDate, String contractType, String Class, String degree, int step,
                                  String countryProfile, String currency, String manager, String projectManager, String jobTitle, String project, String workType,
                                  String category1, String category2, String category3, String title, String jobTitleInResidences, String governmentClassification, String subGovernmentClassification,
                                  boolean menaMeUser, String shiftType, String shiftType2, String shift, int shiftCategory, boolean addCardId, boolean isManager){

        employeeCodeSetter(employeeCodeGenerator());
        setFirstName(firstName());
        setSecondName(secondName());
        setThirdName(thirdName());
        setLastName(lastName());

        //System.out.println(employeeCodeGetter());

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        // Add primary keys dynamically
        if(getCompanyId() != 0){
            payload.put("companyId", getCompanyId());
        }else{
            fail("Invalid Company ID!");
        }
        if(getBranchId() != 0){
            payload.put("branchId", getBranchId());
        }else{
            fail("Invalid Branch ID!");
        }
        payload.put("employeeCode", employeeCodeGetter());
        payload.put("firstNameEn", getFirstName());
        payload.put("secondNameEn", getSecondName());
        payload.put("thirdNameEn", getThirdName());
        payload.put("lastNameEn", getLastName());
        payload.put("firstNameAr", getFirstName());
        payload.put("secondNameAr", getSecondName());
        payload.put("thirdNameAr", getThirdName());
        payload.put("lastNameAr", getLastName());

        fullNameEmployee = getFirstName() + " " + getSecondName() + " " + getThirdName() + " " + getLastName();
        firstAndLastNameEmployee = getFirstName() + " " + getLastName();

        if(!email.isEmpty()){
            payload.put("email", email);
        }
        if(!mobile.isEmpty()){
            payload.put("mobile", mobile);
        }
        payload.put("birthDate", birthDate);
        payload.put("hiringDate", hiringDate);
        payload.put("permanentOnDate", hiringDate);
        payload.put("employmentDate", employmentDate);
        payload.put("startContractDate", hiringDate);

        if(!martialStatus.isEmpty()){
            if(martialStatus.equalsIgnoreCase("Single")){
                payload.put("maritalStatusId", 1);
            }else if(martialStatus.equalsIgnoreCase("Married")){
                payload.put("maritalStatusId", 2);
            }else if(martialStatus.equalsIgnoreCase("Divorced")){
                payload.put("maritalStatusId", 3);
            }else if(martialStatus.equalsIgnoreCase("Widow")){
                payload.put("maritalStatusId", 4);
            }
        }else{
            payload.put("maritalStatusId", 1);
        }

        if(!gender.isEmpty()){
            if(gender.equalsIgnoreCase("Male")){
                payload.put("genderId", 1);
            }else{
                payload.put("genderId", 2);
            }
        }else{
            payload.put("genderId", 1);
        }

        if(!nationality.isEmpty()){
            int nationalityId = Integer.parseInt(
                    selectQuery("SELECT n.NationalityId FROM Nationalities n " +
                    "JOIN BranchNationalities bn ON n.NationalityId = bn.NationalityId " +
                    "WHERE n.NationalityNameEn = '"+nationality+"' AND bn.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("nationalityId", nationalityId);
        }else{
            payload.put("nationalityId", 1);
        }

        if(!religion.isEmpty()){
            int religionId = Integer.parseInt(
                    selectQuery("SELECT r.ReligionId FROM Religions r " +
                            "JOIN BranchReligions br ON r.ReligionId = br.ReligionId " +
                            "WHERE r.ReligionNameEn = '"+religion+"' AND br.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("religionId", religionId);
        }

        if(!site.isEmpty()){
            int siteId = Integer.parseInt(
                    selectQuery("SELECT s.SiteId FROM Sites s " +
                            "JOIN BranchSites bs ON s.SiteId = bs.SiteId " +
                            "WHERE s.SiteNameEn = '"+site+"' AND bs.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("siteId", siteId);
        }

        if(!department.isEmpty()){
            int departmentId = Integer.parseInt(
                    selectQuery("SELECT d.DepartmentId FROM Departments d " +
                            "JOIN BranchDepartments bd ON d.DepartmentId = bd.DepartmentId " +
                            "WHERE d.DepartmentNameEn = '"+department+"' AND bd.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("departmentId", departmentId);
        }

        if(!section.isEmpty()){
            int sectionId = Integer.parseInt(
                    selectQuery("SELECT s.SectionId FROM Sections s " +
                            "JOIN BranchSections bs ON s.SectionId = bs.SectionId " +
                            "WHERE s.SectionNameEn = '"+section+"' AND bs.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("sectionId", sectionId);
        }

        if(!division.isEmpty()){
            int divisionId = Integer.parseInt(
                    selectQuery("SELECT d.DivisionId FROM Divisions d " +
                            "JOIN BranchDivisions bd ON d.DivisionId = bd.DivisionId " +
                            "WHERE d.DivisionNameEn = '"+division+"' AND bd.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("divisionId", divisionId);
        }

        if(!unit.isEmpty()){
            int unitId = Integer.parseInt(
                    selectQuery("SELECT u.UnitId FROM Units u " +
                            "JOIN BranchUnits bu ON u.UnitId = bu.UnitId " +
                            "WHERE u.UnitNameEn = '"+unit+"' AND bu.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("unitId", unitId);
        }

        if(!subSection.isEmpty()){
            int subSectionId = Integer.parseInt(
                    selectQuery("SELECT ss.SubSectionId FROM SubSections ss " +
                            "JOIN BranchSubSections bss ON ss.SubSectionId = bss.SubSectionId " +
                            "WHERE ss.SubSectionNameEn = '"+subSection+"' AND bss.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("subSectionId", subSectionId);
        }

        if(!subDivision.isEmpty()){
            int subDivisionId = Integer.parseInt(
                    selectQuery("SELECT sd.SubDivisionId FROM SubDivisions sd " +
                            "JOIN BranchSubDivisions bsd ON sd.SubDivisionId = bsd.SubDivisionId " +
                            "WHERE sd.SubDivisionNameEn = '"+subDivision+"' AND bsd.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("subDivisionId", subDivisionId);
        }

        if(!subUnit.isEmpty()){
            int subUnitId = Integer.parseInt(
                    selectQuery("SELECT su.SubUnitId FROM SubUnits su " +
                            "JOIN BranchSubUnits bsu ON su.SubUnitId = bsu.SubUnitId " +
                            "WHERE su.SubUnitNameEn = '"+subUnit+"' AND bsu.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("subUnitId", subUnitId);
        }

        if(!project.isEmpty()){
            int projectId = Integer.parseInt(
                    selectQuery("SELECT p.ProjectId FROM Projects p " +
                            "JOIN BranchProjects bp ON p.ProjectId = bp.ProjectId " +
                            "WHERE p.ProjectNameEn = '"+project+"' AND bp.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("projectId", projectId);
        }

        if(!contractType.isEmpty()){
            int contractTypeId = Integer.parseInt(
                    selectQuery("SELECT ct.ContractTypeId FROM ContractTypes ct " +
                            "JOIN BranchContractTypes bct ON ct.ContractTypeId = bct.ContractTypeId " +
                            "WHERE ct.ContractTypeNameEn = '"+contractType+"' AND bct.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("contractTypeId", contractTypeId);
        }

        if(!category1.isEmpty()){
            int category1Id = Integer.parseInt(
                    selectQuery("SELECT c1.CategoryId1 FROM Categories1 c1 " +
                            "JOIN BranchCategories1 bc1 ON c1.CategoryId1 = bc1.CategoryId1 " +
                            "WHERE c1.Category1NameEn = '"+category1+"' AND bc1.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("categoryId1", category1Id);
        }

        if(!category2.isEmpty()){
            int category2Id = Integer.parseInt(
                    selectQuery("SELECT c2.CategoryId2 FROM Categories2 c2 " +
                            "JOIN BranchCategories2 bc2 ON c2.CategoryId2 = bc2.CategoryId2 " +
                            "WHERE c2.Category2NameEn = '"+category2+"' AND bc2.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("categoryId2", category2Id);
        }

        if(!category3.isEmpty()){
            int categoryId3 = Integer.parseInt(
                    selectQuery("SELECT c3.CategoryId3 FROM Categories3 c3 " +
                            "JOIN BranchCategories3 bc3 ON c3.CategoryId3 = bc3.CategoryId3 " +
                            "WHERE c3.Category3NameEn = '"+category3+"' AND bc3.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("categoryId3", categoryId3);
        }

        if(!title.isEmpty()){
            int titleId = Integer.parseInt(
                    selectQuery("SELECT t.TitleId FROM Titles t " +
                            "JOIN BranchTitles bt ON t.TitleId = bt.TitleId " +
                            "WHERE t.TitleNameEn = '"+title+"' AND bt.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("titleId", titleId);
        }

        if(!workType.isEmpty()){
            if(workType.equalsIgnoreCase("Monthly")){
                payload.put("workTypeId", 1);
            }else if(workType.equalsIgnoreCase("Daily")){
                payload.put("workTypeId", 2);
            }else if(workType.equalsIgnoreCase("Part Time")){
                payload.put("workTypeId", 3);
            }else{
                payload.put("workTypeId", 1);
            }
        }else{
            payload.put("workTypeId", 1);
        }

        if(!jobTitle.isEmpty()){
            int jobTitleId = Integer.parseInt(
                    selectQuery("SELECT jt.JobTitleId FROM JobTitles jt " +
                            "JOIN BranchJobTitles bjt ON jt.JobTitleId = bjt.JobTitleId " +
                            "WHERE jt.JobTitleNameEn = '"+jobTitle+"' AND bjt.BranchId = "+getBranchId()+";").trim()
            );

            payload.put("jobTitleId", jobTitleId);
        }

        if(!jobTitleInResidences.isEmpty()){
            int jobTitleInResidenceId = Integer.parseInt(
                    selectQuery("SELECT jtr.JobTitleInResidenceId FROM JobTitleInResidences jtr " +
                            "JOIN BranchJobTitleInResidences bjtr ON jtr.JobTitleInResidenceId = bjtr.JobTitleInResidenceId " +
                            "WHERE jtr.JobTitleInResidenceNameEn = '"+jobTitleInResidences+"' AND bjtr.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("jobTitleInResidenceId", jobTitleInResidenceId);
        }

        if(!manager.isEmpty()){
            int managerId = Integer.parseInt(
              selectQuery("select EmployeeId from EmployeeGeneralInfo where EmployeeCode = '"+manager+"' and branchId = "+getBranchId()).trim()
            );
            payload.put("managerId", managerId);
        }
        if(!projectManager.isEmpty()){
            int projectManagerId = Integer.parseInt(
                    selectQuery("select EmployeeId from EmployeeGeneralInfo where EmployeeCode = '"+projectManager+"' and branchId = "+getBranchId()).trim()
            );
            payload.put("projectManagerId", projectManagerId);
        }
        if(!office.isEmpty()){
            int officeId = Integer.parseInt(
                    selectQuery("SELECT o.OfficeId FROM Offices o " +
                            "JOIN BranchOffices bo ON o.OfficeId = bo.OfficeId " +
                            "WHERE o.OfficeNameEn = '"+office+"' AND bo.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("officeId", officeId);
        }

        if(!team.isEmpty()){
            int teamId = Integer.parseInt(
                    selectQuery("SELECT t.TeamId FROM Teams t " +
                            "JOIN BranchTeams bt ON t.TeamId = bt.TeamId " +
                            "WHERE t.TeamNameEn = '"+team+"' AND bt.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("teamId", teamId);
        }
        //payload.put("selfServiceUser", false);
        if(!shiftType.isEmpty()){
            if(shiftType.equalsIgnoreCase("Roster")){
                payload.put("shiftTypeCategoryId", 1);
            }else if(shiftType.equalsIgnoreCase("Regular")){
                payload.put("shiftTypeCategoryId", 2);
            }
        }
        if(!shiftType2.isEmpty()){
            payload.put("shiftTypeId", shiftType2);
        }
        if(!shift.isEmpty()){
            payload.put("shiftId", shift);
        }
        if(shiftCategory != 0){
            payload.put("shiftCategoryId", shiftCategory);
        }
        if(addCardId){
            payload.put("cardId", employeeCodeGetter());
        }

        if(!Class.isEmpty()){
            int classId = Integer.parseInt(
                    selectQuery("SELECT c.ClassId FROM Classes c " +
                            "JOIN BranchClasses bc ON c.ClassId = bc.ClassId " +
                            "WHERE c.ClassNameEn = '"+Class+"' AND bc.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("classId", classId);
        }

        if(!degree.isEmpty()){
            int degreeId = Integer.parseInt(
                    selectQuery("SELECT d.DegreeId FROM Degrees d " +
                            "JOIN BranchDegrees bd ON d.DegreeId = bd.DegreeId " +
                            "WHERE d.DegreeNameEn = '"+degree+"' AND bd.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("degreeId", degreeId);
        }

        if(step != 0){
            payload.put("stepId", step);
        }
//        if(jobRotation != 0){
//            payload.put("jobRotationId", jobRotation);
//        }
        if(!countryProfile.isEmpty()){
            int countryProfileId = Integer.parseInt(
                    selectQuery("select id from CountryProfiles where BranchId = "+getBranchId()+" and TitleEn = '"+countryProfile+"';").trim()
            );
            payload.put("countryProfileId", countryProfileId);
        }
        if(!currency.isEmpty()){
            int currencyId = Integer.parseInt(
                    selectQuery("select id from Currencies where BranchId = "+getBranchId()+" and NameEn = '"+currency+"';").trim()
            );
            payload.put("currencyId", currencyId);
        }
        payload.put("haveSpouses", false);
        payload.put("haveChildrens", false);
        payload.put("IsDisableCardId", false);
        payload.put("terminated", false);
        payload.put("isGeneralInfoDataLock", false);
        payload.put("hasSuspended", false);
        payload.put("hasStop", false);
        payload.put("hasPostedTerminationSalary", false);

        if(!governmentClassification.isEmpty()){
            int governmentId = Integer.parseInt(
                    selectQuery("select id from GovernmentClassifications where BranchId = "+getBranchId()+" and TitleEn = '"+governmentClassification+"';").trim()
            );
            payload.put("governmentId", governmentId);

            if(!subGovernmentClassification.isEmpty()){
                int subGovernmentId = Integer.parseInt(
                        selectQuery("select id from SubGovernmentClassifications where GovernmentClassificationId = "+governmentId+" and TitleEn = '"+subGovernmentClassification+"';").trim()
                );
                payload.put("subGovernmentId", subGovernmentId);
            }
        }

        payload.put("isStatus", 1);
        payload.put("menaMEUser", menaMeUser);

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/Employee/save-employee-general-info") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200){
                employeeCode = employeeCodeGetter();
                employeeIdSetter(employeeCodeGetter());
                employeeInsuranceIdSetter(employeeIdGetter());
                System.out.println("==============================================");
                System.out.println("Response Status Code: " + response.statusCode());
                System.out.println("Employee Id: "+employeeIdGetter());
                System.out.println("Employee Code: "+employeeCodeGetter());
                System.out.println("Employee Insurance Id: "+employeeInsuranceIdGetter());
                System.out.println("Employee MenaME Password: sa");
                System.out.println("==============================================");
                setMenaMePassword(employeeCodeGetter(), "Revamp");
                if(isManager){
                    addEmployeeToPermissionList(employeeIdGetter(), 1);
                }else{
                    addEmployeeToPermissionList(employeeIdGetter(), 0);
                }
            }else{
                fail("Employee Cannot Created! \n Status Code = "+response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setBasicSalary(String basicSalary){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        // Add primary keys dynamically
        payload.put("EmployeeId", employeeIdGetter());
        payload.put("basicSalary", basicSalary);
        payload.put("IsFinancialInfoDataLock", false);

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/Employee/save-employee-financial-info") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200){
                System.out.println("Basic Salary added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addAllowance(String allowanceType, String amount, String recurring, String fromDate, String toDate, boolean status){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        payload.put("EmployeeId", employeeIdGetter());

        if(!allowanceType.isEmpty()){
            int allowanceId = Integer.parseInt(
                    selectQuery("select id from AllowanceProfiles where BranchId = "+getBranchId()+" and NameEn = '"+allowanceType+"';").trim()
            );
            payload.put("allowanceId", allowanceId);
        }

        if(!amount.isEmpty()){
            payload.put("amount", amount);
        }

        if(!recurring.isEmpty()){
            if(recurring.equalsIgnoreCase("Till Further Notice")){
                payload.put("recurringFlag", 1);
            }else if(recurring.equalsIgnoreCase("Date Range")){
                payload.put("recurringFlag", 2);
            }
        }else{
            payload.put("recurringFlag", 1);
        }

        if(!fromDate.isEmpty()){
            payload.put("fromDate", fromDate);
        }else{
            String hiringDate = selectQuery("select HiringDate from EmployeeGeneralInfo where EmployeeId = '"+employeeIdGetter()+"'").trim();
            // Remove the time part (just keep the date)
            String dateOnlyStr = hiringDate.split(" ")[0];  // Take the part before the space
            payload.put("fromDate", dateOnlyStr);
        }
        if(!toDate.isEmpty()){
            payload.put("toDate", toDate);
        }
        payload.put("active", status);

        ////////////////////////////////////////////////////////////////////

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeAllowance/create")
                    .then()
//                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Allowance added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addSocialSecurity(String socialSecurityType, String startDate, String amount, boolean retirement){

        Map<String, Object> payload = new HashMap<>();

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("insuredFlag")){
            payload.put("insuredFlag", true);
            payload.put("insuranceProgramId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("insuranceProgramId"));
            payload.put("insuranceStartDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("insuranceStartDate"));
            //payload.put("insuranceCardExpiry", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("insuranceCardExpiry"));
        }

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("entitledToExtraSalaryFlag")){
            payload.put("entitledToExtraSalaryFlag", true);
            payload.put("extraSalaryId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("extraSalaryId"));
        }

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("stbFlag")){

            payload.put("stbFlag", true);

            List<Map<String, Object>> employeeSTBs = new ArrayList<>();
            Map<String, Object> employeeSTB = new HashMap<>();

            employeeSTB.put("EmployeeId", employeeIdGetter());
            employeeSTB.put("stbTypeId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("employeeSTBs[0].stbTypeId"));
            employeeSTB.put("startDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSTBs[0].startDate"));
            employeeSTBs.add(employeeSTB);
            payload.put("employeeSTBs", employeeSTBs);

        }

        payload.put("insuranceId", employeeInsuranceIdGetter());
        payload.put("EmployeeId", employeeIdGetter());
        payload.put("subjectToSocialSecurityFlag", true);
        payload.put("employeeStatusFlag", true);
        payload.put("retirementFlag", retirement);
        payload.put("entitledToOvertimeFlag", true);

        List<Map<String, Object>> employeeSocialSecurities = new ArrayList<>();
        Map<String, Object> employeeSocialSecurity = new HashMap<>();

        employeeSocialSecurity.put("EmployeeId", employeeIdGetter());

        if(!socialSecurityType.isEmpty()){
            int socialSecurityTypeId = Integer.parseInt(
                    selectQuery("select id from SocialSecurityProfile where NameEn = '"+socialSecurityType+"' and BranchId = '"+getBranchId()+"'").trim()
            );
            employeeSocialSecurity.put("socialSecurityTypeId", socialSecurityTypeId);
        }

        if(!startDate.isEmpty()){
            employeeSocialSecurity.put("socialSecurityStartDate", startDate);
        }else{
            String hiringDate = selectQuery("select HiringDate from EmployeeGeneralInfo where EmployeeId = '"+employeeIdGetter()+"'").trim();
            // Remove the time part (just keep the date)
            String dateOnlyStr = hiringDate.split(" ")[0];  // Take the part before the space
            employeeSocialSecurity.put("socialSecurityStartDate", dateOnlyStr);
        }

        if(!amount.isEmpty()){
            employeeSocialSecurity.put("socialSecuritySalary", amount);
        }else{
            String basicSalary = selectQuery("select BasicSalary from EmployeeFinancialInfo where EmployeeId = "+employeeIdGetter()).trim();
            employeeSocialSecurity.put("socialSecuritySalary", basicSalary);
        }

        employeeSocialSecurities.add(employeeSocialSecurity);
        payload.put("employeeSocialSecurities", employeeSocialSecurities);

        ////////////////////////////////////////////////////////////////////

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeFinancialInsurance/save-employee-insurance")
                    .then()
//                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Social Security added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void healthInsurance(String insuranceProgram, String startDate, String cardExpiry){

        Map<String, Object> payload = new HashMap<>();

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("subjectToSocialSecurityFlag")){

            payload.put("subjectToSocialSecurityFlag", true);
            payload.put("retirementFlag", getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("retirementFlag"));

            List<Map<String, Object>> employeeSocialSecurities = new ArrayList<>();
            Map<String, Object> employeeSocialSecurity = new HashMap<>();

            employeeSocialSecurity.put("EmployeeId", employeeIdGetter());
            employeeSocialSecurity.put("socialSecurityTypeId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("employeeSocialSecurities[0].socialSecurityTypeId"));
            employeeSocialSecurity.put("socialSecurityStartDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSocialSecurities[0].socialSecurityStartDate"));
            employeeSocialSecurity.put("socialSecuritySalary", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSocialSecurities[0].socialSecuritySalary"));
            employeeSocialSecurities.add(employeeSocialSecurity);
            payload.put("employeeSocialSecurities", employeeSocialSecurities);

        }

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("entitledToExtraSalaryFlag")){
            payload.put("entitledToExtraSalaryFlag", true);
            payload.put("extraSalaryId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("extraSalaryId"));
        }

        payload.put("insuranceId", employeeInsuranceIdGetter());
        payload.put("EmployeeId", employeeIdGetter());
        payload.put("insuredFlag", true);
        payload.put("employeeStatusFlag", true);
        payload.put("entitledToOvertimeFlag", true);

//        List<Map<String, Object>> employeeSocialSecurities = new ArrayList<>();
//        Map<String, Object> employeeSocialSecurity = new HashMap<>();

        //payload.put("EmployeeId", employeeIdGetter());

        if(!insuranceProgram.isEmpty()){
            int insuranceProgramId = Integer.parseInt(
                    selectQuery("select id from HealthInsuranceProfiles where NameEn = '"+insuranceProgram+"' and BranchId = '"+getBranchId()+"'").trim()
            );
            payload.put("insuranceProgramId", insuranceProgramId);
        }

        if(!startDate.isEmpty()){
            payload.put("insuranceStartDate", startDate);
        }else{
            String hiringDate = selectQuery("select HiringDate from EmployeeGeneralInfo where EmployeeId = '"+employeeIdGetter()+"'").trim();
            // Remove the time part (just keep the date)
            String dateOnlyStr = hiringDate.split(" ")[0];  // Take the part before the space
            payload.put("insuranceStartDate", dateOnlyStr);
        }

        if(!cardExpiry.isEmpty()){
            payload.put("insuranceCardExpiry", cardExpiry);
        }

//        employeeSocialSecurities.add(employeeSocialSecurity);
//        payload.put("employeeSocialSecurities", employeeSocialSecurities);

        ////////////////////////////////////////////////////////////////////

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeFinancialInsurance/save-employee-insurance")
                    .then()
//                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Health Insurance added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Response getEmployeeInsurance(int employeeId){

        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .spec(SpecBuilder())
                .queryParam("employeeId", employeeId) // Pass integer as query param
                .when()
                .get("/EmployeeFinancialInsurance/employee-insurance")
                .then()
                .statusCode(200) // Validate response
                .extract()
                .response();

        return response;

    }

    public Response getVacationBalance(int empId){
        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .spec(SpecBuilder())
                .queryParam("employeeId", empId) // Pass integer as query param
                .when()
                .get("/EmployeeVacationBalance/GetAll")
                .then()
                .statusCode(200) // Validate response
                .extract()
                .response();

        return response;
    }

    public void deleteVacationBalance(int empId, int vacationTypeId, int year){

        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .spec(SpecBuilder())
                .queryParam("vacationTypeId", vacationTypeId) // Pass integer as query param
                .queryParam("employeeId", empId)
                .queryParam("year", year)
                .when()
                .post("/EmployeeVacationBalance/DeleteEmployeeVacationBalance")
                .then()
                .statusCode(200) // Validate response
                .extract()
                .response();

        System.out.println("Response: " + response.getStatusCode() + " - Vacation Type Id: "+vacationTypeId+" has been deleted");

    }

    public void deleteAllVacationBalance(int empId){

        //List<Integer> list = getVacationBalance(empId).jsonPath().getList("vacationTypeId");
        //Integer[] array = list.toArray(new Integer[0]);
        //System.out.println(Arrays.toString(array));

        List<Integer> vacationTypeId = getVacationBalance(empId).jsonPath().getList("vacationTypeId");
        List<Integer> years = getVacationBalance(empId).jsonPath().getList("year");

        if(!vacationTypeId.isEmpty()){
            for(int i = 0; i < vacationTypeId.size(); i++){
                deleteVacationBalance(empId, vacationTypeId.get(i), years.get(i));
            }
        }else{
            System.out.println("There is no vacation balance to delete it");
        }

    }

    public void addVacationBalance(String vacationType, String previousBalance, String newBalance, String year, String fromDate, String toDate, boolean deletePreviousBalance){

        if(deletePreviousBalance){
            deleteAllVacationBalance(employeeIdGetter());
        }

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        // Add primary keys dynamically
        payload.put("EmployeeId", employeeIdGetter());

        int vacationTypeId = Integer.parseInt(selectQuery("select Id from VacationProfiles where NameEn = '"+vacationType+"' and BranchId = "+getBranchId()).trim());
        payload.put("vacationTypeId", vacationTypeId);
        payload.put("year", year);

        if(!previousBalance.isEmpty()){
            payload.put("previousBalance", previousBalance);
        }else{
            payload.put("previousBalance", 0);
        }

        payload.put("newBalance", newBalance);

        if(!fromDate.isEmpty()){
            payload.put("fromDate", fromDate);
        }

        if(!toDate.isEmpty()){
            payload.put("toDate", toDate);
        }

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeVacationBalance/create") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200){
                System.out.println("Vacation Balance added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getVacationCurrentBalance(String employeeCode, String vacationType, int year){

        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .spec(SpecBuilder())
                .queryParam("employeeId", getIdByEmployeeCode(employeeCode))
                .queryParam("year", year)
                .when()
                .get("/EmployeeVacationBalance/GetAll")
                .then()
                .statusCode(200) // Validate response
                .extract()
                .response();

        try {
            return formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.currentBalance").trim());
        }catch (Exception ignored){
            return "Not Found!";
        }

    }

    public String getFromVacationBalance(String employeeCode, String vacationType, int year, String filed){

        String value = null;

        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .spec(SpecBuilder())
                .queryParam("employeeId", getIdByEmployeeCode(employeeCode))
                .queryParam("year", year)
                .when()
                .get("/EmployeeVacationBalance/GetAll")
                .then()
                .statusCode(200) // Validate response
                .extract()
                .response();

        if(filed.equalsIgnoreCase("Current Balance")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.currentBalance").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Year")){
            try {
                value = response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.year").trim();
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Previous Balance")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.previousBalance").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("New Balance")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.newBalance").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Up To End Of Year Balance") || filed.equalsIgnoreCase("Up To End Of Year")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.upToEndOfYear").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Remaining Previous")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.remainingPrevious").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Days Taken")){
            try {
                value = response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.daysTaken").trim();
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Adjustment Days")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.adjustmentDays").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Compensation Days")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.compensationDays").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Posted Days Taken")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.postedDaysTaken").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }else if(filed.equalsIgnoreCase("Days Amount")){
            try {
                value = formatToThreeFractionDigits(response.jsonPath().getString("find { it.vacationName == '"+vacationType+"' }.daysAmount").trim());
            }catch (Exception ignored){
                value = "Not Found!";
            }
        }
        return value;
    }

    public void addSubstitute(String employeeCode, String substituteCode, boolean isDirectManager){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        if(!substituteCode.isEmpty()){
            int substituteId = getIdByEmployeeCode(substituteCode);
            payload.put("substituteId", substituteId);
        }
        if(!employeeCode.isEmpty()){
            int employeeId = getIdByEmployeeCode(employeeCode);
            payload.put("employeeId", employeeId);
        }

        payload.put("incrementalCode", 0);

        if(isDirectManager){
            payload.put("isDirectManager", true);
        }else{
            payload.put("isDirectManager", false);
        }

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeSubstitute/create") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Employee Substitutes added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addExtraSalary(String employeeCode, String extraSalary){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("insuredFlag")){
            payload.put("insuredFlag", true);
            payload.put("insuranceProgramId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("insuranceProgramId"));
            payload.put("insuranceStartDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("insuranceStartDate"));
            //payload.put("insuranceCardExpiry", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("insuranceCardExpiry"));
        }

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("subjectToSocialSecurityFlag")){

            payload.put("subjectToSocialSecurityFlag", true);
            payload.put("retirementFlag", getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("retirementFlag"));

            List<Map<String, Object>> employeeSocialSecurities = new ArrayList<>();
            Map<String, Object> employeeSocialSecurity = new HashMap<>();

            employeeSocialSecurity.put("EmployeeId", employeeIdGetter());
            employeeSocialSecurity.put("socialSecurityTypeId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("employeeSocialSecurities[0].socialSecurityTypeId"));
            employeeSocialSecurity.put("socialSecurityStartDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSocialSecurities[0].socialSecurityStartDate"));
            employeeSocialSecurity.put("socialSecuritySalary", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSocialSecurities[0].socialSecuritySalary"));
            employeeSocialSecurities.add(employeeSocialSecurity);
            payload.put("employeeSocialSecurities", employeeSocialSecurities);

        }

        if(!employeeCode.isEmpty()){
            int employeeId = getIdByEmployeeCode(employeeCode);
            payload.put("employeeId", employeeId);
            employeeInsuranceIdSetter(employeeId);
            payload.put("insuranceId", employeeInsuranceIdGetter());
        }

        payload.put("entitledToExtraSalaryFlag", true);
        int extraSalaryId = Integer.parseInt(
                selectQuery("select id from ExtraSalaryProfiles where ProfileTitle = '"+extraSalary+"' and BranchId = "+getBranchId()).trim()
        );
        payload.put("extraSalaryId", extraSalaryId);
        payload.put("employeeStatusFlag", true);
        payload.put("entitledToOvertimeFlag", true);

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeFinancialInsurance/save-employee-insurance") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Employee Extra Salary added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void entitledToOvertime(String employeeCode){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("insuredFlag")){
            payload.put("insuredFlag", true);
            payload.put("insuranceProgramId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("insuranceProgramId"));
            payload.put("insuranceStartDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("insuranceStartDate"));
            //payload.put("insuranceCardExpiry", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("insuranceCardExpiry"));
        }

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("subjectToSocialSecurityFlag")){

            payload.put("subjectToSocialSecurityFlag", true);
            payload.put("retirementFlag", getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("retirementFlag"));

            List<Map<String, Object>> employeeSocialSecurities = new ArrayList<>();
            Map<String, Object> employeeSocialSecurity = new HashMap<>();

            employeeSocialSecurity.put("EmployeeId", employeeIdGetter());
            employeeSocialSecurity.put("socialSecurityTypeId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("employeeSocialSecurities[0].socialSecurityTypeId"));
            employeeSocialSecurity.put("socialSecurityStartDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSocialSecurities[0].socialSecurityStartDate"));
            employeeSocialSecurity.put("socialSecuritySalary", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSocialSecurities[0].socialSecuritySalary"));
            employeeSocialSecurities.add(employeeSocialSecurity);
            payload.put("employeeSocialSecurities", employeeSocialSecurities);

        }

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("entitledToExtraSalaryFlag")){
            payload.put("entitledToExtraSalaryFlag", true);
            payload.put("extraSalaryId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("extraSalaryId"));
        }

        if(!employeeCode.isEmpty()){
            int employeeId = getIdByEmployeeCode(employeeCode);
            payload.put("employeeId", employeeId);
            employeeInsuranceIdSetter(employeeId);
            payload.put("insuranceId", employeeInsuranceIdGetter());
        }

        payload.put("employeeStatusFlag", true);
        payload.put("entitledToOvertimeFlag", true);

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeFinancialInsurance/save-employee-insurance") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Employee Entitled To Overtime successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addSTB(String stbType, String startDate){

        Map<String, Object> payload = new HashMap<>();

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("insuredFlag")){
            payload.put("insuredFlag", true);
            payload.put("insuranceProgramId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("insuranceProgramId"));
            payload.put("insuranceStartDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("insuranceStartDate"));
            //payload.put("insuranceCardExpiry", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("insuranceCardExpiry"));
        }

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("subjectToSocialSecurityFlag")){

            payload.put("subjectToSocialSecurityFlag", true);
            payload.put("retirementFlag", getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("retirementFlag"));

            List<Map<String, Object>> employeeSocialSecurities = new ArrayList<>();
            Map<String, Object> employeeSocialSecurity = new HashMap<>();

            employeeSocialSecurity.put("EmployeeId", employeeIdGetter());
            employeeSocialSecurity.put("socialSecurityTypeId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("employeeSocialSecurities[0].socialSecurityTypeId"));
            employeeSocialSecurity.put("socialSecurityStartDate", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSocialSecurities[0].socialSecurityStartDate"));
            employeeSocialSecurity.put("socialSecuritySalary", getEmployeeInsurance(employeeIdGetter()).jsonPath().getString("employeeSocialSecurities[0].socialSecuritySalary"));
            employeeSocialSecurities.add(employeeSocialSecurity);
            payload.put("employeeSocialSecurities", employeeSocialSecurities);

        }

        if(getEmployeeInsurance(employeeIdGetter()).jsonPath().getBoolean("entitledToExtraSalaryFlag")){
            payload.put("entitledToExtraSalaryFlag", true);
            payload.put("extraSalaryId", getEmployeeInsurance(employeeIdGetter()).jsonPath().getInt("extraSalaryId"));
        }

        payload.put("insuranceId", employeeInsuranceIdGetter());
        payload.put("EmployeeId", employeeIdGetter());
        payload.put("stbFlag", true);
        payload.put("employeeStatusFlag", true);
        payload.put("entitledToOvertimeFlag", true);

        List<Map<String, Object>> employeeSTBs = new ArrayList<>();
        Map<String, Object> employeeSTB = new HashMap<>();

        employeeSTB.put("EmployeeId", employeeIdGetter());

        if(!stbType.isEmpty()){
            int stbTypeId = Integer.parseInt(
                    selectQuery("select id from STBProfiles where NameEn = '"+stbType+"' and BranchId = '"+getBranchId()+"'").trim()
            );
            employeeSTB.put("stbTypeId", stbTypeId);
        }

        if(!startDate.isEmpty()){
            employeeSTB.put("startDate", startDate);
        }else{
            String hiringDate = selectQuery("select HiringDate from EmployeeGeneralInfo where EmployeeId = '"+employeeIdGetter()+"'").trim();
            // Remove the time part (just keep the date)
            String dateOnlyStr = hiringDate.split(" ")[0];  // Take the part before the space
            employeeSTB.put("startDate", dateOnlyStr);
        }

        employeeSTBs.add(employeeSTB);
        payload.put("employeeSTBs", employeeSTBs);

        ////////////////////////////////////////////////////////////////////

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeFinancialInsurance/save-employee-insurance")
                    .then()
//                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("STB added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getSTBAmount(String employeeCode, String stbType, String endDate){

        int stbTypeId = Integer.parseInt(
                selectQuery("select id from STBProfiles where NameEn = '"+stbType+"' and BranchId = '"+getBranchId()+"'").trim()
        );

        String date = null;

        if(!endDate.isEmpty()){
            date = endDate;
        }else{
            date = getCurrentDate();
        }

        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .spec(SpecBuilder())
                .queryParam("profileId", stbTypeId)
                .queryParam("employeeId", getIdByEmployeeCode(employeeCode))
                .queryParam("endDate", date)
                .when()
                .get("/STBTransaction/GetSTBWithdrawAmounts")
                .then()
                .statusCode(200) // Validate response
                .extract()
                .response();

        try {
            return formatToThreeFractionDigits(response.jsonPath().getString("stbAmount").trim());
        }catch (Exception ignored){
            return "Not Found!";
        }

    }

    public void addEmployeeToPermissionList(int employeeId, int isManager){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS");
        String formattedDate = now.withNano(now.getNano() / 100).format(formatter);

        int menaMeSecuritySetupId = Integer.parseInt(selectQuery("select id from MenaMeSecuritySetups where BranchId = "+getBranchId() + " and TitleEn = 'MenaME Users'").trim());
        sqlQuery("INSERT INTO MenaMeSecurityEmployeePermissions (MenaMeSecuritySetupId, EmployeeId, IsManager, CreatedById, CreationDate) VALUES ("+menaMeSecuritySetupId+", "+employeeId+", "+isManager+", 1, '"+formattedDate+"');");
    }

    public void addAddress(String employeeCode, String startDate, String endDate, String country, String city, String neighborhood, String street, String buildingName, String floor,
                           String poBox, String zipCode){

        Map<String, Object> payload = new HashMap<>();
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));

        if(!startDate.isEmpty()){
            payload.put("fromYear", startDate);
        }else{
            payload.put("fromYear", getCurrentDate());
        }
        if(!endDate.isEmpty()){
            payload.put("toYear", endDate);
        }else{
            payload.put("toYear", getCurrentDate());
        }
        if(!country.isEmpty()){
            int countryId = Integer.parseInt(
                    selectQuery("SELECT c.CountryId FROM Countries c " +
                            "JOIN BranchCountries bc ON c.CountryId = bc.CountryId " +
                            "WHERE c.CountryNameEn = '"+country+"' AND bc.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("countryId", countryId);

            if(!city.isEmpty()){
                int cityId = Integer.parseInt(selectQuery("select CityId from Cities where CountryId = "+countryId+" and CityNameEn = '"+city+"'").trim());
                payload.put("cityId", cityId);
            }

        }
        if(!neighborhood.isEmpty()){
            payload.put("neighborhood", neighborhood);
        }
        if(!street.isEmpty()){
            payload.put("street", street);
        }
        if(!buildingName.isEmpty()){
            payload.put("buildingName", buildingName);
        }
        if(!floor.isEmpty()){
            payload.put("floor", floor);
        }
        if(!poBox.isEmpty()){
            payload.put("poBox", poBox);
        }
        if(!zipCode.isEmpty()){
            payload.put("zipCode", zipCode);
        }

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeAddress/create")
                    .then()
//                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Address added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addPaymentMethod(String employeeCode, String paymentType, String bank, String bankBranch, String accountNumber, String ibanNumber){

        Map<String, Object> payload = new HashMap<>();
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));

        if(paymentType.equalsIgnoreCase("Cash")){
            payload.put("paymentMethodId", 1);
        }else if(paymentType.equalsIgnoreCase("Check")){
            payload.put("paymentMethodId", 2);
        }else if(paymentType.equalsIgnoreCase("Bank")){
            payload.put("paymentMethodId", 3);
        }else{
            payload.put("paymentMethodId", 1);
        }

        int bankIdG = 0;

        if(!bank.isEmpty()){
            int bankId = Integer.parseInt(
                    selectQuery("select b.BankId from Banks b " +
                    "JOIN BranchBanks bb ON b.BankId = bb.BankId " +
                    "where b.BankNameEn = '"+bank+"' and bb.BranchId = "+getBranchId()+";").trim()
            );
            bankIdG = bankId;
            payload.put("bankId", bankId);
        }

        if(!bankBranch.isEmpty()){
            int bankBranchId = Integer.parseInt(
                    selectQuery("select BankBranchId from BankBranches where BankBranchNameEn = '"+bankBranch+"' and BankId = "+bankIdG).trim()
            );
            payload.put("bankBranchId", bankBranchId);

        }
        if(!accountNumber.isEmpty()){
            payload.put("accountNumber", accountNumber);
        }
        if(!ibanNumber.isEmpty()){
            payload.put("ibanNumber", ibanNumber);
        }
        payload.put("active", true);

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeePaymentMethod/create")
                    .then()
//                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Payment Information added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addEducation(String employeeCode, String startDate, String endDate, boolean untilNow, String country, String city, String institute, String faculty, String major,
                             String academicDegree, String grading, String universityAverage, String graduationYear, String educationNotes, boolean educationMinor){

        Map<String, Object> payload = new HashMap<>();
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));

        payload.put("startDate", startDate);
        if(!untilNow){
            payload.put("endDate", endDate);
        }
        payload.put("untilNow", untilNow);

        if(!country.isEmpty()){
            int countryId = Integer.parseInt(
                    selectQuery("SELECT c.CountryId FROM Countries c " +
                            "JOIN BranchCountries bc ON c.CountryId = bc.CountryId " +
                            "WHERE c.CountryNameEn = '"+country+"' AND bc.BranchId = "+getBranchId()+";").trim()
            );
            payload.put("countryId", countryId);

            if(!city.isEmpty()){
                int cityId = Integer.parseInt(selectQuery("select CityId from Cities where CountryId = "+countryId+" and CityNameEn = '"+city+"'").trim());
                payload.put("cityId", cityId);
            }

        }

        if(!institute.isEmpty()){
            int instituteId = Integer.parseInt(selectQuery("select i.InstituteId from Institutes i " +
                    "JOIN BranchInstitutes bi ON i.InstituteId = bi.InstituteId " +
                    "where i.InstituteNameEn = '"+institute+"' and bi.BranchId = "+getBranchId()).trim()
            );
            payload.put("instituteId", instituteId);
        }
        if(!faculty.isEmpty()){
            int facultyId = Integer.parseInt(selectQuery("select f.facultyId from Faculties f " +
                    "JOIN BranchFaculties bf ON f.facultyId = bf.facultyId " +
                    "where f.FacultyNameEn = '"+faculty+"' and bf.BranchId = "+getBranchId()).trim()
            );
            payload.put("facultyId", facultyId);
        }
        if(!major.isEmpty()){
            int majorId = Integer.parseInt(selectQuery("select m.MajorId from Majors m " +
                    "JOIN BranchMajors mb ON m.MajorId = mb.MajorId " +
                    "where m.MajorNameEn = '"+major+"' and mb.BranchId = "+getBranchId()).trim()
            );
            payload.put("majorId", majorId);
        }
        if(!academicDegree.isEmpty()){
            int academicDegreeId = Integer.parseInt(selectQuery("select ad.AcademicDegreeId from AcademicDegrees ad " +
                    "JOIN BranchAcademicDegrees bad ON ad.AcademicDegreeId = bad.AcademicDegreeId " +
                    "where ad.AcademicDegreeNameEn = '"+academicDegree+"' and bad.BranchId = "+getBranchId()).trim()
            );
            payload.put("academicDegreeId", academicDegreeId);
        }
        if(!grading.isEmpty()){
            if(grading.equalsIgnoreCase("Accepted")){
                payload.put("gradingId", 1);
            }else if(grading.equalsIgnoreCase("Good")){
                payload.put("gradingId", 2);
            }else if(grading.equalsIgnoreCase("Very Good")){
                payload.put("gradingId", 3);
            }else if(grading.equalsIgnoreCase("Excellent")){
                payload.put("gradingId", 4);
            }else{
                payload.put("gradingId", 4);
            }
        }

        if(!universityAverage.isEmpty()){
            payload.put("universityAverage", universityAverage);
        }
        if(!graduationYear.isEmpty()){
            payload.put("graduationYear", graduationYear);
        }
        if(!educationNotes.isEmpty()){
            payload.put("educationNotes", educationNotes);
        }
        payload.put("educationMinor", educationMinor);

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeEducation/create")
                    .then()
//                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Education added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addCertificate(String employeeCode, String fromDate, String toDate, String certificateType, String certificate, String certificateSerial, String showIn,
                               String status, String issueDate, String grade, String certificateNumber, String notes){

        Map<String, Object> payload = new HashMap<>();
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));
        payload.put("fromDate", fromDate);
        payload.put("toDate", toDate);

        int ctG = 0;

        if(!certificateType.isEmpty()){
            int certificateTypeId = Integer.parseInt(selectQuery("select ct.CertificateTypeId from CertificateTypes ct " +
                    "JOIN BranchCertificateTypes bct ON ct.CertificateTypeId = bct.CertificateTypeId " +
                    "where ct.CertificateTypeNameEn = '"+certificateType+"' and bct.BranchId = "+getBranchId()).trim()
            );
            ctG = certificateTypeId;
            payload.put("certificateTypeId", certificateTypeId);

            if(!certificate.isEmpty()){
                int certificateId = Integer.parseInt(selectQuery("select CertificateId from Certificates where CertificateTypeId = "+ctG+" and CertificateNameEn = '"+certificate+"'").trim()
                );
                payload.put("certificateId", certificateId);
            }
        }

        if(!certificateSerial.isEmpty()){
            payload.put("certificateSerial", certificateSerial);
        }
        if(!showIn.isEmpty()){
            if(showIn.equalsIgnoreCase("Generic Resume")){
                payload.put("showInId", 1);
            }else if(showIn.equalsIgnoreCase("Detailed Resume")){
                payload.put("showInId", 2);
            }else if(showIn.equalsIgnoreCase("Not Shown")){
                payload.put("showInId", 3);
            }else if(showIn.equalsIgnoreCase("Both")){
                payload.put("showInId", 4);
            }else{
                payload.put("showInId", 1);
            }
        }
        if(!status.isEmpty()){
            if(status.equalsIgnoreCase("Passed")){
                payload.put("statusId", 1);
            }else if(status.equalsIgnoreCase("Failed")){
                payload.put("statusId", 2);
            }else if(status.equalsIgnoreCase("Pending")){
                payload.put("statusId", 3);
            }else{
                payload.put("statusId", 1);
            }
        }

        if(!issueDate.isEmpty()){
            payload.put("issueDate", issueDate);
        }
        if(!grade.isEmpty()){
            payload.put("grade", grade);
        }
        if(!certificateNumber.isEmpty()){
            payload.put("certificateNumber", certificateNumber);
        }
        if(!certificateNumber.isEmpty()){
            payload.put("certificateNumber", certificateNumber);
        }
        if(!notes.isEmpty()){
            payload.put("notes", notes);
        }
//        if(attachment){
//            File file = new File("src/main/resources/testUpload.jpg");
//            byte[] fileContent = null;
//            try {
//                fileContent = Files.readAllBytes(file.toPath());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            String base64Encoded = Base64.getEncoder().encodeToString(fileContent);
//            System.out.println(base64Encoded);
//
//            payload.put("attachment", base64Encoded);
//        }

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/EmployeeCertificate/create")
                    .then()
//                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Certificate added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

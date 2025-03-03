package apiBackend;

import bases.ApiBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

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
                    .header("Content-Type", "application/json")
                    .body(jsonPayload)
                    .when()
                    .post("/Employee/save-employee-general-info") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

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
                    .header("Content-Type", "application/json")
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
                    .header("Content-Type", "application/json")
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

        payload.put("insuranceId", employeeInsuranceIdGetter());
        payload.put("EmployeeId", employeeIdGetter());
        payload.put("subjectToSocialSecurityFlag", true);
        payload.put("retirementFlag", retirement);

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
                    .header("Content-Type", "application/json")
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

        payload.put("insuranceId", employeeInsuranceIdGetter());
        payload.put("EmployeeId", employeeIdGetter());
        payload.put("insuredFlag", true);

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
                    .header("Content-Type", "application/json")
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
                    .header("Content-Type", "application/json")
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
                    .header("Content-Type", "application/json")
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

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    .header("Content-Type", "application/json")
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

    public void addEmployeeToPermissionList(int employeeId, int isManager){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS");
        String formattedDate = now.withNano(now.getNano() / 100).format(formatter);

        int menaMeSecuritySetupId = Integer.parseInt(selectQuery("select id from MenaMeSecuritySetups where BranchId = "+getBranchId()).trim());
        sqlQuery("INSERT INTO MenaMeSecurityEmployeePermissions (MenaMeSecuritySetupId, EmployeeId, IsManager, CreatedById, CreationDate) VALUES ("+menaMeSecuritySetupId+", "+employeeId+", "+isManager+", 1, '"+formattedDate+"');");
    }


}

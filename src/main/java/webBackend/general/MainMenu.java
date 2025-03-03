package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.VersionGetter.versionGetter;

public class MainMenu extends WebBase {
    
    @FindBy(id = "236")
    WebElement employees;
    @FindBy(id = "ReportsTab")
    WebElement reports;
    @FindBy(id = "8716")
    WebElement extraModules;
    @FindBy(xpath = "//a[contains(@href, 'employees/employees.php')]")
    WebElement personnelInformation;
    @FindBy(xpath = "//a[contains(@href, 'employees/allownce.php')]")
    WebElement financialInformation;
    @FindBy(id = "5722")
    WebElement massAllowances;
    @FindBy(id = "4425")
    WebElement employeesResidences;
    @FindBy(id = "3663")
    WebElement substitutes;
    @FindBy(id = "5611")
    WebElement applicationExams;
    @FindBy(id = "5617")
    WebElement importApplicationExams;
    @FindBy(id = "3012")
    WebElement employeesGreetings;
    @FindBy(id = "10537")
    WebElement changeContractHistory;
    @FindBy(id = "10269")
    WebElement importEmployees;
    @FindBy(id = "12700")
    WebElement importEmployeesIntegration;
    @FindBy(xpath = "(//label[text()='Lock Employees Data'])[2]")
    WebElement lockEmployeesData;
    @FindBy(id = "5667")
    WebElement costCentersImport;
    @FindBy(id = "3674")
    WebElement coveredDeductions;
    @FindBy(id = "4916")
    WebElement dynamicProvisionsDistribution;
    @FindBy(id = "10634")
    WebElement monthlyKPIImport;
    @FindBy(id = "8715")
    WebElement settings;
    @FindBy(id = "1374")
    WebElement branchesSetup;
    @FindBy(id = "1418")
    WebElement branchesSetupSynchronization;
    @FindBy(id = "3586")
    WebElement securitySetup;
    @FindBy(id = "5083")
    WebElement usersReports;
    @FindBy(id = "3623")
    WebElement dictionarySetup;
    @FindBy(id = "6914")
    WebElement smtpServerSetup;
    @FindBy(id = "6431")
    WebElement menaMESetup;
    @FindBy(id = "4617")
    WebElement menaMESecuritySetup;
    @FindBy(id = "55193")
    WebElement menaMePasswords;
    @FindBy(id = "9956")
    WebElement menaMEUsersReport;
    @FindBy(id = "9950")
    WebElement menaMEFailedLogins;
    @FindBy(id = "8728")
    WebElement integrationSetup;
    @FindBy(id = "678")
    WebElement personnelSetup;
    @FindBy(id = "127")
    WebElement financialSetup;
    @FindBy(id = "2479")
    WebElement exitInterviewQuestions;
    @FindBy(id = "1029")
    WebElement hierarchySetup;
    @FindBy(id = "2042")
    WebElement organizationChart;
    @FindBy(id = "1040")
    WebElement salaryScale;
    @FindBy(id = "5544")
    WebElement ManagersPermissions;
    @FindBy(id = "5448")
    WebElement KeyStaffSetup;
    @FindBy(id = "10")
    WebElement SystemParameters;
    @FindBy(id = "1375")
    WebElement CurrenciesSetup;
    @FindBy(id = "2864")
    WebElement HolidaysSetup;
    @FindBy(id = "2781")
    WebElement NotificationsSetup;
    @FindBy(id = "3962")
    WebElement RegionsSetup;
    @FindBy(id = "5013")
    WebElement SignaturesSetup;
    @FindBy(id = "55292")
    WebElement HeadersSetup;
    @FindBy(id = "4473")
    WebElement DynamicListsSetup;
    @FindBy(id = "52506")
    WebElement SystemTheme;
    @FindBy(id = "5533")
    WebElement AttachmentsSetup;
    @FindBy(id = "6905")
    WebElement ExternalLinksSetup;
    @FindBy(id = "9727")
    WebElement BonusSetup;
    @FindBy(id = "12519")
    WebElement BadgesSetup;
    @FindBy(id = "5445")
    WebElement WorkflowSetup;
    @FindBy(id = "5451")
    WebElement WorkflowAssign;
    @FindBy(id = "5466")
    WebElement WorkflowScreening;
    @FindBy(id = "6630")
    WebElement WorkflowReport;
    @FindBy(id = "7147")
    WebElement WFTemplatesReport;
    @FindBy(id = "11332")
    WebElement DetailedWFTemplatesReport;
    @FindBy(id = "3405")
    WebElement BanksFilesSetup;
    @FindBy(id = "3405")
    WebElement SalaryReportsSetup;
    @FindBy(id = "11757")
    WebElement BankIntegrationSetup;
    @FindBy(id = "3649")
    WebElement ServicePointsSetup;
    @FindBy(id = "8726")
    WebElement WorkforceManagement;
    @FindBy(xpath = "//label[text()='Setup']")
    WebElement ManpowerPlanningSetup;
    @FindBy(id = "2897")
    WebElement ManpowerPlanning;
    @FindBy(id = "6686")
    WebElement ManpowerScreening;
    @FindBy(xpath = "//label[text()='Reports']")
    WebElement ManpowerPlanningReports;
    @FindBy(id = "7207")
    WebElement ManpowerCountReport;
    @FindBy(id = "7670")
    WebElement ManpowerActualVsPlan;
    @FindBy(id = "7676")
    WebElement ManpowerDetailedReport;
    @FindBy(id = "7675")
    WebElement ManpowerSummaryReport;
    @FindBy(id = "9323")
    WebElement ManpowerHistoryReport;
    @FindBy(id = "1888")
    WebElement ChangeTransactions;
    @FindBy(xpath = "(//label[text()='Tabular Entry'])[2]")
    WebElement HRTabularEntry;
    @FindBy(id = "3965")
    WebElement MassChangeTransactions;
    @FindBy(id = "50813")
    WebElement ImportChangeTransactions;
    @FindBy(id = "6434")
    WebElement PostChangeTransactions;
    @FindBy(id = "2655")
    WebElement EmployeesUpgrade;
    @FindBy(id = "7240")
    WebElement PostingUnpostingUpgradeTransactions;
    @FindBy(id = "1869")
    WebElement EmployeesTasks;
    @FindBy(id = "3297")
    WebElement EvaluationResults;
    @FindBy(id = "2486")
    WebElement ExitInterviews;
    @FindBy(xpath = "(//label[text()='Setup'])[2]")
    WebElement LeaveManagementSetup;
    @FindBy(id = "1991")
    WebElement VacationsBalances;
    @FindBy(xpath = "(//label[@id='337'])[2]")
    WebElement EmployeesTransactionsFinancial;
    @FindBy(xpath = "(//font[@id='337'])[2]")
    WebElement EmployeesTransactionsFinancial_oct;
    @FindBy(xpath = "//a[@href='transactions/work_suspension_transactions.php']")
    WebElement WorkSuspension;
    @FindBy(xpath = "//a[@href='transactions/hourlyleaves.php']")
    WebElement EmployeesTransactionsLeave;
    @FindBy(xpath = "//a[@href='transactions/transactions.php']")
    WebElement EmployeeTransactionsFinancial;
    @FindBy(xpath = "//a[@href='transactions/non_payroll_trans.php']")
    WebElement NonPayrollTransactionsE;
    @FindBy(xpath = "//a[contains(@href, 'setup/mename_general_setup_1175')]")
    WebElement GeneralSettings;
    @FindBy(xpath = "//label[text()='Tabular Entry']")
    WebElement LeaveTabularEntry;
    @FindBy(id = "6819")
    WebElement VacationsResumption;
    @FindBy(id = "2156")
    WebElement VacationBalancesMoving;
    @FindBy(id = "4564")
    WebElement VacationsBalancesDifferences;
    @FindBy(id = "3038")
    WebElement RoundLeave;
    @FindBy(id = "468")
    WebElement LeavePostingUnposting;
    @FindBy(xpath = "(//label[text()='Reports'])[2]")
    WebElement LeaveReports;
    @FindBy(xpath = "//label[text()='Salary Transactions']")
    WebElement SalaryTransactions;
    @FindBy(xpath = "//font[text()='Salary Transactions']")
    WebElement SalaryTransactions_oct;
    @FindBy(xpath = "//label[text()='Main Salary Reports']")
    WebElement MainSalaryReports;
    @FindBy(xpath = "//font[text()='Main Salary Reports']")
    WebElement MainSalaryReports_oct;
    @FindBy(xpath = "//label[text()='Salary Slips']")
    WebElement SalarySlips;
    @FindBy(xpath = "//font[text()='Salary Slips']")
    WebElement SalarySlips_oct;
    @FindBy(xpath = "//a[contains(@href, 'salary_slip_offcycle.php')]")
    WebElement OffCycleSalarySlip;
    @FindBy(xpath = "//label[text()='Mass Transactions']")
    WebElement MassTransactions;
    @FindBy(xpath = "//font[text()='Mass Transactions']")
    WebElement MassTransactions_oct;
    @FindBy(xpath = "//a[contains(@href, '/mass_transactions.php')]")
    WebElement MassTransactionsPage;
    @FindBy(xpath = "//a[contains(@href, '/update_security_salary.php')]")
    WebElement UpdateSocialSecuritySalary;
    @FindBy(xpath = "//a[contains(@href, '/movetransactions.php?loan_type_flag=1')]")
    WebElement MassPostingUnposting;
    @FindBy(xpath = "//a[contains(@href, '/data_load_transaction.php')]")
    WebElement importTransactions;
    @FindBy(xpath = "//a[contains(@href, '/salary_report_setup_300')]")
    WebElement SpecialSalaryReport;
    @FindBy(id = "467")
    WebElement SalaryCalculation;
    @FindBy(xpath = "//a[contains(@href, '/nonpayroll_trans_calculation.php')]")
    WebElement nonpayroll_trans_calculation;
    @FindBy(xpath = "//a[contains(@href, 'calculatesalary_extra.php')]")
    WebElement extraSalary;
    @FindBy(id = "469")
    WebElement EmployeeTermination;
    @FindBy(xpath = "//a[contains(@href, 'expansion_vac_advance_trans.php')]")
    WebElement VacationInAdvanceScreening;
    @FindBy(id = "52814")
    WebElement UpdateFamilyAllowance;
    @FindBy(id = "10943")
    WebElement RoundOvertime;
    @FindBy(xpath = "//a[contains(@href, 'employee_saving.php')]")
    WebElement pf_Balances;
    @FindBy(id = "473")
    WebElement EmployeeTransactions;
    @FindBy(id = "1466")
    WebElement VacationsBalancesReport;
    @FindBy(id = "2871")
    WebElement VacationsSheet;
    @FindBy(id = "2874")
    WebElement VacationsSummary;
    @FindBy(id = "4089")
    WebElement VacationsTotals;
    @FindBy(id = "4740")
    WebElement VacationResumptionReport;
    @FindBy(id = "5055")
    WebElement CompoundVacationsReport;
    @FindBy(id = "5562")
    WebElement LeaveVacationRequests;
    @FindBy(id = "11688")
    WebElement WeeklyLeavesSummaryReport;
    @FindBy(xpath = "//a[contains(@href, 'view_employees.php')]")
    WebElement EmployeesExplorer;
    @FindBy(xpath = "//a[contains(@href, 'calculate_allowances.php')]")
    WebElement DynamicAllowancesCalculation;


    public void mainMenu(String tabName, String subTabName){

        closeIFrame();
        hold(1000);
        waitFrameAndWindow();

         if (tabName.equalsIgnoreCase("Settings")) {
             hold(800);
             clickOn_menu(settings, subTabName, tabName);
             hold(1000);
             subTabs(subTabName, "Settings");
         } else if (tabName.equalsIgnoreCase("Employees")){
             hold(800);
             clickOn_menu(employees, subTabName, tabName);
             hold(1000);
             subTabs(subTabName, "Employees");
         } else if (tabName.equalsIgnoreCase("Workforce Management") || tabName.contains("Workforce")) {
             hold(800);
             clickOn_menu(WorkforceManagement, subTabName, tabName);
             hold(1000);
             subTabs(subTabName, "Workforce Management");
         } else if (tabName.equalsIgnoreCase("Reports")){
             hold(800);
             clickOn_menu(reports, subTabName, tabName);
             hold(1000);
             subTabs(subTabName, "Reports");
         } else if (tabName.equalsIgnoreCase("Extra Modules")){
             hold(800);
             clickOn_menu(extraModules, subTabName, tabName);
             hold(1000);
             subTabs(subTabName, "Extra Modules");
         }

         setLog("Open Menu - "+tabName+ " ➞ " +subTabName);

    }


    //////////////// The method below 'subTabs' contains all the Sub Tabs ////////////////
    public void subTabs(String subTabName, String tabName){

        subTabName = subTabName.toLowerCase();
        tabName = tabName.toLowerCase();

        //////////// ***Trick*** I used a While loop to be able to add a break inside the if statement //////////
        while (true){
            if (subTabName.equalsIgnoreCase("Branches Setup")) {
                hold(1000);
                clickOn_menu(branchesSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Branches Setup Synchronization")) {
                hold(1000);
                clickOn_menu(branchesSetupSynchronization, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Security Setup")) {
                hold(1000);
                clickOn_menu(securitySetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Users Reports")) {
                hold(1000);
                clickOn_menu(usersReports, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Dictionary Setup")) {
                hold(1000);
                clickOn_menu(dictionarySetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("SMTP Server Setup")) {
                hold(1000);
                clickOn_menu(smtpServerSetup, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("MenaME Security Setup"))) {
                hold(1000);
                clickOn_menu(menaMESetup, subTabName, tabName);
                hold(1000);
                clickOn_menu(menaMESecuritySetup, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("MenaMe Passwords")) || subTabName.contains(toLowerCase("QRC"))) {
                hold(1000);
                clickOn_menu(menaMESetup, subTabName, tabName);
                hold(1000);
                clickOn_menu(menaMePasswords, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("MenaME Users Report"))) {
                hold(1000);
                clickOn_menu(menaMESetup, subTabName, tabName);
                hold(1000);
                clickOn_menu(menaMEUsersReport, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("MenaME Failed Logins"))) {
                hold(1000);
                clickOn_menu(menaMESetup, subTabName, tabName);
                hold(1000);
                clickOn_menu(menaMEFailedLogins, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Integration Setup")) {
                hold(1000);
                clickOn_menu(integrationSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Personnel Setup")) {
                hold(1000);
                clickOn_menu(personnelSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Financial Setup")) {
                hold(1000);
                clickOn_menu(financialSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Exit Interview Questions")) {
                hold(1000);
                clickOn_menu(exitInterviewQuestions, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Hierarchy Setup")) {
                hold(1000);
                clickOn_menu(hierarchySetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Organization Chart")) {
                hold(1000);
                clickOn_menu(organizationChart, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Salary Scale")) {
                hold(1000);
                clickOn_menu(salaryScale, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Managers Permissions")) {
                hold(1000);
                clickOn_menu(ManagersPermissions, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Key-Staff Setup") || subTabName.equalsIgnoreCase("Key Staff Setup")) {
                hold(1000);
                clickOn_menu(KeyStaffSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("System Parameters")) {
                hold(1000);
                clickOn_menu(SystemParameters, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Currencies Setup")) {
                hold(1000);
                clickOn_menu(CurrenciesSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Holidays Setup")) {
                hold(1000);
                clickOn_menu(HolidaysSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Notifications Setup")) {
                hold(1000);
                clickOn_menu(NotificationsSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Regions Setup")) {
                hold(1000);
                clickOn_menu(RegionsSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Signatures Setup")) {
                hold(1000);
                clickOn_menu(SignaturesSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Headers Setup")) {
                hold(1000);
                clickOn_menu(HeadersSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Dynamic Lists Setup")) {
                hold(1000);
                clickOn_menu(DynamicListsSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("System Theme")) {
                hold(1000);
                clickOn_menu(SystemTheme, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Attachments Setup")) {
                hold(1000);
                clickOn_menu(AttachmentsSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("External Links Setup")) {
                hold(1000);
                clickOn_menu(ExternalLinksSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Bonus Setup")) {
                hold(1000);
                clickOn_menu(BonusSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Badges Setup")) {
                hold(1000);
                clickOn_menu(BadgesSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Workflow Setup")) {
                hold(1000);
                clickOn_menu(WorkflowSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Workflow Assign")) {
                hold(1000);
                clickOn_menu(WorkflowAssign, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Workflow Screening")) {
                hold(1000);
                clickOn_menu(WorkflowScreening, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Workflow Report")) {
                hold(1000);
                clickOn_menu(WorkflowReport, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("WF Templates Report")) {
                hold(1000);
                clickOn_menu(WFTemplatesReport, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Detailed WF Templates Report")) {
                hold(1000);
                clickOn_menu(DetailedWFTemplatesReport, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Salary Reports Setup")) {
                hold(1000);
                clickOn_menu(SalaryReportsSetup, subTabName, tabName);
                break;
            }  else if (subTabName.equalsIgnoreCase("Personnel Information")){
                hold(1000);
                clickOn_menu(personnelInformation, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Financial Information")) {
                hold(1000);
                clickOn_menu(financialInformation, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Mass Allowances")) {
                hold(1000);
                clickOn_menu(massAllowances, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Employees Residences")) {
                hold(1000);
                clickOn_menu(employeesResidences, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Substitutes")) {
                hold(1000);
                clickOn_menu(substitutes, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Application Exams")) {
                hold(1000);
                clickOn_menu(applicationExams, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Import Application Exams")) {
                hold(1000);
                clickOn_menu(importApplicationExams, subTabName, tabName);
                break;
            }  else if (subTabName.contains(toLowerCase("PF Balances"))) {
                hold(1000);
                clickOn_menu(pf_Balances, subTabName, tabName);
                break;
            }  else if (subTabName.equalsIgnoreCase("Employees Greetings")) {
                hold(1000);
                clickOn_menu(employeesGreetings, subTabName, tabName);
                break;
            }  else if (subTabName.equalsIgnoreCase("Change Contract History")) {
                hold(1000);
                clickOn_menu(changeContractHistory, subTabName, tabName);
                break;
            }  else if (subTabName.equalsIgnoreCase("Import Employees")) {
                hold(1000);
                clickOn_menu(importEmployees, subTabName, tabName);
                break;
            }  else if (subTabName.equalsIgnoreCase("Import Employees - Integration")) {
                hold(1000);
                clickOn_menu(importEmployeesIntegration, subTabName, tabName);
                break;
            }  else if (subTabName.equalsIgnoreCase("Lock Employees Data")) {
                hold(1000);
                clickOn_menu(lockEmployeesData, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Cost Centers Import")) {
                hold(1000);
                clickOn_menu(costCentersImport, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Covered Deductions")) {
                hold(1000);
                clickOn_menu(coveredDeductions, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Dynamic Provisions Distribution")) {
                hold(1000);
                clickOn_menu(dynamicProvisionsDistribution, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Monthly KPI Import")) {
                hold(1000);
                clickOn_menu(monthlyKPIImport, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Banks Files Setup")) {
                hold(1000);
                clickOn_menu(BanksFilesSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Bank Integration Setup")) {
                hold(1000);
                clickOn_menu(BankIntegrationSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Service Points Setup")) {
                hold(1000);
                clickOn_menu(ServicePointsSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Manpower Planning Setup")) {
                hold(1000);
                clickOn_menu(ManpowerPlanningSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Manpower Planning")) {
                hold(1000);
                clickOn_menu(ManpowerPlanning, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Manpower Screening")) {
                hold(1000);
                clickOn_menu(ManpowerScreening, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Manpower Count"))) {
                hold(1000);
                clickOn_menu(ManpowerPlanningReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(ManpowerCountReport, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Manpower Actual"))) {
                hold(1000);
                clickOn_menu(ManpowerPlanningReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(ManpowerActualVsPlan, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Manpower Detailed"))) {
                hold(1000);
                clickOn_menu(ManpowerDetailedReport, subTabName, tabName);
                hold(1000);
                clickOn_menu(ManpowerPlanning, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Manpower Summary"))) {
                hold(1000);
                clickOn_menu(ManpowerPlanningReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(ManpowerSummaryReport, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Manpower History"))) {
                hold(1000);
                clickOn_menu(ManpowerPlanningReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(ManpowerHistoryReport, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Change Transactions")) {
                hold(1000);
                clickOn_menu(ChangeTransactions, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("HR Tabular Entry")) {
                hold(1000);
                clickOn_menu(HRTabularEntry, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Mass Change Transactions")) {
                hold(1000);
                clickOn_menu(MassChangeTransactions, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Import Change Transactions")) {
                hold(1000);
                clickOn_menu(ImportChangeTransactions, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Post Change Transactions")) {
                hold(1000);
                clickOn_menu(PostChangeTransactions, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Employees Upgrade")) {
                hold(1000);
                clickOn_menu(EmployeesUpgrade, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Employees Explorer")) {
                hold(1000);
                clickOn_menu(EmployeesExplorer, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Posting/Unposting Upgrade"))) {
                hold(1000);
                clickOn_menu(PostingUnpostingUpgradeTransactions, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Employees Tasks")) {
                hold(1000);
                clickOn_menu(EmployeesTasks, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Evaluation Results")) {
                hold(1000);
                clickOn_menu(EvaluationResults, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Exit Interviews")) {
                hold(1000);
                clickOn_menu(ExitInterviews, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Leave Management Setup") || subTabName.contains(toLowerCase("Leave Management"))) {
                hold(1000);
                clickOn_menu(LeaveManagementSetup, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Vacations Balances")) {
                hold(1000);
                clickOn_menu(VacationsBalances, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Employees Transactions Leave")) {
                hold(1000);
                clickOn_menu(EmployeesTransactionsLeave, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Leave Tabular Entry") || subTabName.contains(toLowerCase("Leave Tabular"))) {
                hold(1000);
                clickOn_menu(LeaveTabularEntry, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Vacations Resumption")) {
                hold(1000);
                clickOn_menu(VacationsResumption, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Vacation Balances Moving")) {
                hold(1000);
                clickOn_menu(VacationBalancesMoving, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Vacations Balances Differences")) {
                hold(1000);
                clickOn_menu(VacationsBalancesDifferences, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Round Leave")) {
                hold(1000);
                clickOn_menu(RoundLeave, subTabName, tabName);
                break;
            } else if (subTabName.equalsIgnoreCase("Leave Posting & Unposting") || subTabName.contains(toLowerCase("Leave Posting"))) {
                hold(1000);
                clickOn_menu(LeavePostingUnposting, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Employee Transactions"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(EmployeeTransactions, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Vacations Balances Reports"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(VacationsBalancesReport, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Vacations Sheet"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(VacationsSheet, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Vacations Summary"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(VacationsSummary, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Vacations Totals"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(VacationsTotals, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Resumption Report"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(VacationResumptionReport, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Compound Vacations Report"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(CompoundVacationsReport, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Leave/Vacation Requests"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(LeaveVacationRequests, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Weekly Leaves Summary Report"))) {
                hold(1000);
                clickOn_menu(LeaveReports, subTabName, tabName);
                hold(1000);
                clickOn_menu(WeeklyLeavesSummaryReport, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Employee Termination"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(SalaryTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(SalaryTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(EmployeeTermination, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Vacation In Advance Screening"))) {
                hold(1000);
                clickOn_menu(VacationInAdvanceScreening, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Update Family Allowance"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(MassTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(MassTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(UpdateFamilyAllowance, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Round Overtime"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(MassTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(MassTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(RoundOvertime, subTabName, tabName);
                break;
            } else if (subTabName.contains(toLowerCase("Salary Calculation"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(SalaryTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(SalaryTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(SalaryCalculation, subTabName, tabName);
                break;
            }  else if (subTabName.contains(toLowerCase("Special Salary Report"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(MainSalaryReports, subTabName, tabName);
                }else {
                    clickOn_menu(MainSalaryReports_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(SpecialSalaryReport, subTabName, tabName);
                break;
            }  else if (subTabName.contains(toLowerCase("Off-Cycle Salary Slip"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(SalarySlips, subTabName, tabName);
                }else {
                    clickOn_menu(SalarySlips_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(OffCycleSalarySlip, subTabName, tabName);
                break;
            }  else if (subTabName.contains(toLowerCase("Non-Payroll Benefit Calculation"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(SalaryTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(SalaryTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(nonpayroll_trans_calculation, subTabName, tabName);
                break;
            }  else if (subTabName.contains(toLowerCase("Extra Salary"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(SalaryTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(SalaryTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(extraSalary, subTabName, tabName);
                break;
            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("Employees Transactions"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(EmployeesTransactionsFinancial, subTabName, tabName);
                }else {
                    clickOn_menu(EmployeesTransactionsFinancial_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(EmployeeTransactionsFinancial, subTabName, tabName);
                break;

            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("Non Payroll Transactions"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(EmployeesTransactionsFinancial, subTabName, tabName);
                }else {
                    clickOn_menu(EmployeesTransactionsFinancial_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(NonPayrollTransactionsE, subTabName, tabName);
                break;

            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("Work Suspension"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(EmployeesTransactionsFinancial, subTabName, tabName);
                }else {
                    clickOn_menu(EmployeesTransactionsFinancial_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(WorkSuspension, subTabName, tabName);
                break;

            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("Mass Transactions"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(MassTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(MassTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(MassTransactionsPage, subTabName, tabName);
                break;

            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("Mass Posting & Unposting"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(MassTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(MassTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(MassPostingUnposting, subTabName, tabName);
                break;

            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("Update Social Security Salary"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(MassTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(MassTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(UpdateSocialSecuritySalary, subTabName, tabName);
                break;

            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("Import Transactions"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(MassTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(MassTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(importTransactions, subTabName, tabName);
                break;

            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("Dynamic Allowances Calculation"))) {
                hold(1000);
                if(!versionGetter().equalsIgnoreCase("OCT")){
                    clickOn_menu(MassTransactions, subTabName, tabName);
                }else {
                    clickOn_menu(MassTransactions_oct, subTabName, tabName);
                }
                hold(1000);
                clickOn_menu(DynamicAllowancesCalculation, subTabName, tabName);
                break;

            }  else if (tabName.equalsIgnoreCase("Workforce Management") && subTabName.contains(toLowerCase("General Settings"))) {
                hold(1000);
                clickOn_menu(GeneralSettings, subTabName, tabName);
                break;

            }else{
                break;
            }
        }

    }

    public String toLowerCase(String title){
        return title.toLowerCase();
    }

    protected void clickOn_menu(WebElement element, String subTabName, String tabName){

        try {
            elementWait(element);
            element.click();
        } catch (Exception e){
            e.printStackTrace();
            try {
                mainMenu(tabName, subTabName);
            }catch (Exception ee){
                ee.printStackTrace();
            }

        }

    }

}

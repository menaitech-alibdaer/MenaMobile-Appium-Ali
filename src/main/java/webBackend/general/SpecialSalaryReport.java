package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class SpecialSalaryReport extends WebBase {

    @FindBy(name = "employee_code")
    public WebElement empCode;
    @FindBy(id = "body_frame")
    WebElement body_frame;
    @FindBy(name = "select_year")
    public WebElement select_year;
    @FindBy(name = "select_year_to")
    WebElement select_year_to;
    @FindBy(name = "select_month_to")
    WebElement select_month_to;
    @FindBy(name = "select_month")
    public WebElement select_month;
    @FindBy(name = "report_form")
    WebElement reportFormE;
    @FindBy(name = "show_employee_code")
    WebElement show_employee_code;
    @FindBy(name = "hide_zero_val")
    WebElement hideAnyColumnHasZeroValueE;
    @FindBy(name = "hide_record_with_zero_values")
    WebElement hideAnyRecordWithZeroValuesE;
    @FindBy(name = "is_employee_currency")
    WebElement useTheEmployeeCurrencyE;
    @FindBy(xpath = "//input[@name='onservice' and @value='1']")
    WebElement currentEmployeesE;
    @FindBy(xpath = "//input[@name='onservice' and @value='2']")
    WebElement terminatedE;
    @FindBy(xpath = "//input[@name='onservice' and @value='3']")
    WebElement bothE;
    @FindBy(xpath = "//input[@name='yearly_deatils' and @value='1']")
    WebElement yearlyDetails;
    @FindBy(xpath = "//input[@name='yearly_deatils' and @value='2']")
    WebElement yearlyTotal;
    @FindBy(name = "dynamic_lists")
    WebElement dynamic_list;
    @FindBy(name = "site")
    WebElement siteE;
    @FindBy(name = "currency")
    WebElement reportCurrencyE;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuShowButton")
    WebElement MenuShowButton;
    @FindBy(id = "show_emp_offcycle_vac_with_no_resumption")
    WebElement show_emp_offcycle_vac_with_no_resumption;
    @FindBy(xpath = "//font[text()='Month']/following::font[2]")
    public WebElement monthE;
    @FindBy(id = "RSIFrame")
    WebElement reportIFrame;
    @FindBy(xpath = "//img[contains(@src, 'loadingAnimation.gif')]")
    WebElement loadingElement;
    @FindBy(className = "rgClose")
    WebElement closeReport;
    @FindBy(xpath = "//tr[@class='reportGroupHeader']//td[contains(text(), 'American Dollar')]")
    WebElement findAmericanDollar;
    @FindBy(xpath = "//tr[@class='reportGroupHeader']//td[contains(text(), 'Jordanian Dinar')]")
    WebElement findJordanianDinar;
    @FindBy(xpath = "//td[@colspan='1']")
    List<WebElement> reportHeader;
    @FindBy(xpath = "//table[@class='reportTable']//td[1]")
    List<WebElement> listOfAllEmployeesCodeInReportWithHeaderAndFooter;
    @FindBy(xpath = "//table[@class='reportTable']//td[@class='textToExcel']")
    public List<WebElement> allEmployeeInReport;

    String parentWindow;


    public void viewReport(String employeeCode, String year, String month, String toYear, String toMonth, String reportForm, String employeeStatus){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(200);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        hold(200);
        alert.accept();
        closeIFrame();
        goToFrame(body_frame);
        hold(200);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        if(!toYear.isEmpty()){
            hold(200);
            Select toYearSelect = new Select(select_year_to);
            toYearSelect.selectByVisibleText(toYear);
            hold(200);
        }
        if(!toMonth.isEmpty()){
            Select toMonthSelect = new Select(select_month_to);
            toMonthSelect.selectByVisibleText(toMonth);
            hold(200);
        }
        Select report = new Select(reportFormE);
        report.selectByVisibleText(reportForm);
        hold(200);
        if(!show_employee_code.isSelected()){
            clickOn(show_employee_code);
        }
        if(employeeStatus.equalsIgnoreCase("Current")){
            clickOn(currentEmployeesE);
        }else if(employeeStatus.equalsIgnoreCase("Terminated")){
            clickOn(terminatedE);
        }else if(employeeStatus.equalsIgnoreCase("Both")){
            clickOn(bothE);
        }
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Special Salary Report - View Report - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month+" - To Year: "+ toYear+" - To Month: "+toMonth+" - Report Form: "+reportForm+" - Employee Status: "+employeeStatus);

    }

    public void viewReport(String employeeCode, String year, String month, String toYear, String toMonth, String reportForm, String employeeStatus, boolean showEmpOffcycleVacation){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(200);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        hold(200);
        alert.accept();
        closeIFrame();
        goToFrame(body_frame);
        hold(200);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        if(!toYear.isEmpty()){
            hold(200);
            Select toYearSelect = new Select(select_year_to);
            toYearSelect.selectByVisibleText(toYear);
            hold(200);
        }
        if(!toMonth.isEmpty()){
            Select toMonthSelect = new Select(select_month_to);
            toMonthSelect.selectByVisibleText(toMonth);
            hold(200);
        }
        Select report = new Select(reportFormE);
        report.selectByVisibleText(reportForm);
        hold(200);
        if(!show_employee_code.isSelected()){
            clickOn(show_employee_code);
        }
        if(employeeStatus.equalsIgnoreCase("Current")){
            clickOn(currentEmployeesE);
        }else if(employeeStatus.equalsIgnoreCase("Terminated")){
            clickOn(terminatedE);
        }else if(employeeStatus.equalsIgnoreCase("Both")){
            clickOn(bothE);
        }
        if(showEmpOffcycleVacation){
            if(!show_emp_offcycle_vac_with_no_resumption.isSelected()){
                clickOn(show_emp_offcycle_vac_with_no_resumption);
            }
        }else{
            if(show_emp_offcycle_vac_with_no_resumption.isSelected()){
                clickOn(show_emp_offcycle_vac_with_no_resumption);
            }
        }
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Special Salary Report - View Report - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month+" - To Year: "+ toYear+" - To Month: "+toMonth+" - Report Form: "+reportForm+" - Employee Status: "+employeeStatus);

    }

    public void viewReport_withTerminatedAlert(String employeeCode, String year, String month, String toYear, String toMonth, String reportForm, String employeeStatus){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1000);
        if(checkAlertIfPresent()){
            Alert alert = getDriver().switchTo().alert();
            hold(200);
            alert.accept();
            closeIFrame();
            goToFrame(body_frame);
        }
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(200);
        if(checkAlertIfPresent()){
            Alert alert = getDriver().switchTo().alert();
            hold(200);
            alert.accept();
            closeIFrame();
            goToFrame(body_frame);
        }
        hold(200);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(200);
        Select toYearSelect = new Select(select_year_to);
        toYearSelect.selectByVisibleText(toYear);
        hold(200);
        Select toMonthSelect = new Select(select_month_to);
        toMonthSelect.selectByVisibleText(toMonth);
        hold(200);
        Select report = new Select(reportFormE);
        report.selectByVisibleText(reportForm);
        hold(200);
        if(!show_employee_code.isSelected()){
            clickOn(show_employee_code);
        }
        if(employeeStatus.equalsIgnoreCase("Current")){
            clickOn(currentEmployeesE);
        }else if(employeeStatus.equalsIgnoreCase("Terminated")){
            clickOn(terminatedE);
        }else if(employeeStatus.equalsIgnoreCase("Both")){
            clickOn(bothE);
        }
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Special Salary Report - View Report - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month+" - To Year: "+ toYear+" - To Month: "+toMonth+" - Report Form: "+reportForm+" - Employee Status: "+employeeStatus);

    }

    public void viewReportByDynamicList(String dynamicList, String year, String month, String toYear, String toMonth, String reportForm, String employeeStatus){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        hold(300);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(200);
        if(checkAlertIfPresent()){
            Alert alert = getDriver().switchTo().alert();
            hold(200);
            alert.accept();
            closeIFrame();
            goToFrame(body_frame);
        }
        hold(200);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(200);
        Select toYearSelect = new Select(select_year_to);
        toYearSelect.selectByVisibleText(toYear);
        hold(200);
        Select toMonthSelect = new Select(select_month_to);
        toMonthSelect.selectByVisibleText(toMonth);
        hold(200);
        normalSelect(dynamic_list, dynamicList);
        hold(300);
        Select report = new Select(reportFormE);
        report.selectByVisibleText(reportForm);
        hold(200);
        if(!show_employee_code.isSelected()){
            clickOn(show_employee_code);
        }
        if(employeeStatus.equalsIgnoreCase("Current")){
            clickOn(currentEmployeesE);
        }else if(employeeStatus.equalsIgnoreCase("Terminated")){
            clickOn(terminatedE);
        }else if(employeeStatus.equalsIgnoreCase("Both")){
            clickOn(bothE);
        }
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Special Salary Report - View Report By Dynamic List: "+dynamicList+" - Year: "+year+" - Month: "+month+" - To Year: "+ toYear+" - To Month: "+toMonth+" - Report Form: "+reportForm+" - Employee Status: "+employeeStatus);

    }

    public void viewReportByDynamicList(String dynamicList, String year, String month, String toYear, String toMonth, String reportForm,
                                        String employeeStatus, boolean hideAnyColumnHasZeroValue, boolean hideAnyRecordWithZeroValues, boolean useTheEmployeeCurrency){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        hold(300);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(200);
        if(checkAlertIfPresent()){
            Alert alert = getDriver().switchTo().alert();
            hold(200);
            alert.accept();
            closeIFrame();
            goToFrame(body_frame);
        }
        hold(200);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(200);
        Select toYearSelect = new Select(select_year_to);
        toYearSelect.selectByVisibleText(toYear);
        hold(200);
        Select toMonthSelect = new Select(select_month_to);
        toMonthSelect.selectByVisibleText(toMonth);
        hold(200);
        normalSelect(dynamic_list, dynamicList);
        hold(300);
        Select report = new Select(reportFormE);
        report.selectByVisibleText(reportForm);
        hold(200);
        if(!show_employee_code.isSelected()){
            clickOn(show_employee_code);
        }
        if(employeeStatus.equalsIgnoreCase("Current")){
            clickOn(currentEmployeesE);
        }else if(employeeStatus.equalsIgnoreCase("Terminated")){
            clickOn(terminatedE);
        }else if(employeeStatus.equalsIgnoreCase("Both")){
            clickOn(bothE);
        }
        hold(200);
        if(hideAnyColumnHasZeroValue){
            if(!hideAnyColumnHasZeroValueE.isSelected()){
                clickOn(hideAnyColumnHasZeroValueE);
            }
        }else{
            if(hideAnyColumnHasZeroValueE.isSelected()){
                clickOn(hideAnyColumnHasZeroValueE);
            }
        }
        if(hideAnyRecordWithZeroValues){
            if(!hideAnyRecordWithZeroValuesE.isSelected()){
                clickOn(hideAnyRecordWithZeroValuesE);
            }
        }else{
            if(hideAnyRecordWithZeroValuesE.isSelected()){
                clickOn(hideAnyRecordWithZeroValuesE);
            }
        }
        if(useTheEmployeeCurrency){
            if(!useTheEmployeeCurrencyE.isSelected()){
                clickOn(useTheEmployeeCurrencyE);
            }
        }else{
            if(useTheEmployeeCurrencyE.isSelected()){
                clickOn(useTheEmployeeCurrencyE);
            }
        }
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Special Salary Report - View Report By Dynamic List: "+dynamicList+" - Year: "+year+" - Month: "+month+" - To Year: "+ toYear+" - To Month: "+toMonth+" - Report Form: "+reportForm+" - Employee Status: "+employeeStatus+" - Hide Any Record With Zero Values: "+hideAnyRecordWithZeroValues+" - Hide Any Column Has Zero Value: "+hideAnyColumnHasZeroValue);

    }

    public void viewReportBySite(String site, String year, String month, String toYear, String toMonth, String reportForm, String employeeStatus){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        hold(300);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(200);
        if(checkAlertIfPresent()){
            Alert alert = getDriver().switchTo().alert();
            hold(200);
            alert.accept();
            closeIFrame();
            goToFrame(body_frame);
        }
        hold(200);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(200);
        Select toYearSelect = new Select(select_year_to);
        toYearSelect.selectByVisibleText(toYear);
        hold(200);
        Select toMonthSelect = new Select(select_month_to);
        toMonthSelect.selectByVisibleText(toMonth);
        hold(200);
        normalSelect(siteE, site);
        hold(300);
        Select report = new Select(reportFormE);
        report.selectByVisibleText(reportForm);
        hold(200);
        if(!show_employee_code.isSelected()){
            clickOn(show_employee_code);
        }
        if(employeeStatus.equalsIgnoreCase("Current")){
            clickOn(currentEmployeesE);
        }else if(employeeStatus.equalsIgnoreCase("Terminated")){
            clickOn(terminatedE);
        }else if(employeeStatus.equalsIgnoreCase("Both")){
            clickOn(bothE);
        }
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Special Salary Report - View Report By Site: "+site+" - Year: "+year+" - Month: "+month+" - To Year: "+ toYear+" - To Month: "+toMonth+" - Report Form: "+reportForm+" - Employee Status: "+employeeStatus);

    }

    public void viewReport(String employeeCode, String year, String month, String toYear, String toMonth, String reportForm, String employeeStatus, String yearly, String reportCurrency){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        normalSelect(select_year, year);
        hold(200);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        hold(200);
        alert.accept();
        closeIFrame();
        goToFrame(body_frame);
        hold(200);
        normalSelect(select_month, month);
        if(!toYear.isEmpty()){
            hold(200);
            normalSelect(select_year_to, toYear);
            hold(200);
        }
        if(!toMonth.isEmpty()){
            normalSelect(select_month_to, toMonth);
            hold(200);
        }
        normalSelect(reportFormE, reportForm);
        hold(200);
        if(!reportCurrency.isEmpty()){
            normalSelect(reportCurrencyE, reportCurrency);
            hold(200);
        }
        if(!show_employee_code.isSelected()){
            clickOn(show_employee_code);
        }
        if(employeeStatus.equalsIgnoreCase("Current")){
            clickOn(currentEmployeesE);
        }else if(employeeStatus.equalsIgnoreCase("Terminated")){
            clickOn(terminatedE);
        }else if(employeeStatus.equalsIgnoreCase("Both")){
            clickOn(bothE);
        }
        if(yearly.equalsIgnoreCase("Yearly Details")){
            clickOn(yearlyDetails);
        }else if(yearly.equalsIgnoreCase("Yearly Total")){
            clickOn(yearlyTotal);
        }
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Special Salary Report - View Report - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month+" - To Year: "+ toYear+" - To Month: "+toMonth+" - Report Form: "+reportForm+" - Employee Status: "+employeeStatus+" - Report Currency: "+reportCurrency);

    }

    public void viewReportBySite(String site, String year, String month, String toYear, String toMonth, String reportForm,
                                 String employeeStatus, boolean hideAnyColumnHasZeroValue, boolean hideAnyRecordWithZeroValues){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        hold(300);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(200);
        if(checkAlertIfPresent()){
            Alert alert = getDriver().switchTo().alert();
            hold(200);
            alert.accept();
            closeIFrame();
            goToFrame(body_frame);
        }
        hold(200);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(200);
        Select toYearSelect = new Select(select_year_to);
        toYearSelect.selectByVisibleText(toYear);
        hold(200);
        Select toMonthSelect = new Select(select_month_to);
        toMonthSelect.selectByVisibleText(toMonth);
        hold(200);
        normalSelect(siteE, site);
        hold(300);
        Select report = new Select(reportFormE);
        report.selectByVisibleText(reportForm);
        hold(200);
        if(!show_employee_code.isSelected()){
            clickOn(show_employee_code);
        }
        if(employeeStatus.equalsIgnoreCase("Current")){
            clickOn(currentEmployeesE);
        }else if(employeeStatus.equalsIgnoreCase("Terminated")){
            clickOn(terminatedE);
        }else if(employeeStatus.equalsIgnoreCase("Both")){
            clickOn(bothE);
        }
        hold(200);
        if(hideAnyColumnHasZeroValue){
            if(!hideAnyColumnHasZeroValueE.isSelected()){
                clickOn(hideAnyColumnHasZeroValueE);
            }
        }else{
            if(hideAnyColumnHasZeroValueE.isSelected()){
                clickOn(hideAnyColumnHasZeroValueE);
            }
        }
        if(hideAnyRecordWithZeroValues){
            if(!hideAnyRecordWithZeroValuesE.isSelected()){
                clickOn(hideAnyRecordWithZeroValuesE);
            }
        }else{
            if(hideAnyRecordWithZeroValuesE.isSelected()){
                clickOn(hideAnyRecordWithZeroValuesE);
            }
        }
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Special Salary Report - View Report By Site: "+site+" - Year: "+year+" - Month: "+month+" - To Year: "+ toYear+" - To Month: "+toMonth+" - Report Form: "+reportForm+" - Employee Status: "+employeeStatus+" - Hide Any Record With Zero Values: "+hideAnyRecordWithZeroValues+" - Hide Any Column Has Zero Value: "+hideAnyColumnHasZeroValue);

    }

    public boolean checkEmployeeIfInReport(String employeeCode){
        boolean check = false;
        for(int i = 0; i< listOfAllEmployeesCodeInReportWithHeaderAndFooter.size(); i++){
            if(listOfAllEmployeesCodeInReportWithHeaderAndFooter.get(i).getText().contains(employeeCode)){
                check = true;
            }
        }
        return check;
    }

    public boolean checkColumnIfInReport(String column){
        boolean check = false;
        for(int i = 0; i< reportHeader.size(); i++){
            if(reportHeader.get(i).getText().contains(column)){
                check = true;
            }
        }
        return check;
    }

    public void closeSalaryReport(){

        closeIFrame();
        clickOn(closeReport);
        hold(200);
        backToParentWindow(parentWindow);
        
        setLog("Close Salary Report");

    }

    public String getEmployeeCode(){
        return getDriver().findElement(By.xpath("//font[text()='Employee Code']/following::font[2]")).getText().trim();
    }
    public String month(){
        return monthE.getText().trim();
    }


//    public WebElement getByEmpAndCol(String rowContains, String columnName) {
//        WebElement targetElement = reportHeader.stream()
//                .filter(element -> element.getText().equalsIgnoreCase(columnName))
//                .findFirst()
//                .orElseThrow(() -> new NoSuchElementException("Target element not found. Column: " + columnName));
//        int targetIndex = rowContains.equalsIgnoreCase("Report Total") ? reportHeader.indexOf(targetElement) - 1 : reportHeader.indexOf(targetElement);
//        targetElement = getDriver().findElement(By.xpath(String.format("//td[contains(text(), '%s')]/following-sibling::td[%s]", rowContains, targetIndex)));
//        return targetElement;
//    }

    public String getByEmpAndCol(String rowContains, String columnName) {
        WebElement targetElement = reportHeader.stream()
                .filter(element -> element.getText().equalsIgnoreCase(columnName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Target element not found. Column: " + columnName));
        int targetIndex = reportHeader.indexOf(targetElement);
        targetElement = getDriver().findElement(By.xpath(String.format("//td[text()='%s']/following-sibling::td[%s]", rowContains, targetIndex)));
        return targetElement.getText().trim();
    }

//    public String getByMonthAndCol(String rowContains, String month) {
//        WebElement targetElement = reportRows.stream()
//                .filter(element -> element.findElement(By.xpath("//td[text()='"+month+"']")).getText().equalsIgnoreCase(month))
//                .findFirst()
//                .orElseThrow(() -> new NoSuchElementException("Target element not found. Column: " + month));
//        int targetIndex = reportHeader.indexOf(targetElement);
//        targetElement = getDriver().findElement(By.xpath(String.format("//td[text()='%s']/following-sibling::td[%s]", rowContains, targetIndex)));
//        return targetElement.getText().trim();
//    }

    public String getByMonth(String month, String columnName) {
        WebElement targetElement = reportHeader.stream()
                .filter(element -> element.getText().equalsIgnoreCase(columnName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Target element not found. Column: " + columnName));
        int targetIndex = reportHeader.indexOf(targetElement) + 1;
        targetElement = getDriver().findElement(By.xpath(String.format("//td[@style='text-align:right' and text()='%s']/..//td[%s]", month, targetIndex)));
        return targetElement.getText().trim();
    }

//    public String getByMonthAndEmp(String employeeCode, String month, String columnName) {
//        WebElement targetElement = reportHeader.stream()
//                .filter(element -> element.getText().equalsIgnoreCase(columnName))
//                .findFirst()
//                .orElseThrow(() -> new NoSuchElementException("Target element not found. Column: " + columnName));
//        int targetIndex = reportHeader.indexOf(targetElement) + 1;
//        targetElement = getDriver().findElement(with(By.xpath(String.format("//td[@style='text-align:right' and text()='%s']/..//td[%s]", month, targetIndex))).below(By.xpath("//td[contains(text(), '"+employeeCode+"')]")));
//        return targetElement.getText().trim();
//    }

    public String getByEmpAndColWithCurrency(String rowContains, String columnName, String currency) {
        WebElement targetElement = reportHeader.stream()
                .filter(element -> element.getText().equalsIgnoreCase(columnName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Target element not found. Column: " + columnName));
        int targetIndex = reportHeader.indexOf(targetElement);
        targetElement = getDriver().findElement(By.xpath(String.format("//tr[@class='reportGroupHeader']//td[contains(text(), '"+currency+"')]/following::tr[2]/td[text()='%s']/following-sibling::td[%s]", rowContains, targetIndex)));
        return targetElement.getText().trim();
    }

    public boolean checkDownloadReport(){
        elementWaitDisappear(loadingElement);
        return checkElementIfPresent(By.xpath("//a[contains(@href, 'download_attachment.php')]"));
    }

    public boolean checkReportIfAppear(){
        elementWaitDisappear(loadingElement);
        return checkElementIfPresent(By.xpath("//table[@class='reportTable']//td[1]"));
    }

}

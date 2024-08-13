package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class EmployeeCalendar extends WebBase {

    @FindBy(id = "inquiry")
    public WebElement inquiry;
    @FindBy(id = "inquiry_emp_calendar")
    public WebElement employeeCalendarBtn;
    @FindBy(id = "MenaBox_iframe")
    public WebElement menaBoxIFrame;
    @FindBy(id = "dropdownMenuButton1")
    public WebElement empCodeClickField;
    @FindBy(xpath = "(//div[@class='d1-q'])[2]")
    public WebElement advanceSearchBtn;
    @FindBy(id = "textSearchInput")
    public WebElement advanceSearch_searchField;
    @FindBy(className = "mar-top-5-minus")
    public List <WebElement> advanceSearch_clickOnEmployee;
    @FindBy(id = "employee_search_input")
    public WebElement empCode;
    @FindBy(id = "employee_search_searchresults")
    public WebElement firstEmployee;
    @FindBy(id = "day_1")
    public WebElement day_1;
    @FindBy(id = "day_2")
    public WebElement day_2;
    @FindBy(id = "day_3")
    public WebElement day_3;
    @FindBy(id = "day_21")
    public WebElement day_21;
    @FindBy(id = "vacation_btn_btn")
    public WebElement vacationBtn;
    @FindBy(id = "LoadingElement")
    public WebElement loadingElement;
    @FindBy(id = "leave_btn")
    public WebElement leaveBtn;
    @FindBy(id = "overtime_btn")
    public WebElement overtimeBtn;
    @FindBy(id = "vacation_type_selected")
    public WebElement vacationTypeE;
    @FindBy(xpath = "(//button[@id='dropdownMenuButton1'])[2]")
    public WebElement monthDropdown;
    @FindBy(xpath = "//label[contains(text(), 'Jan')]")
    public WebElement jan;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(2)')]")
    public WebElement feb;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(3)')]")
    public WebElement mar;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(4)')]")
    public WebElement apr;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(5)')]")
    public WebElement may;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(6)')]")
    public WebElement jun;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(7)')]")
    public WebElement jul;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(8)')]")
    public WebElement aug;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(9)')]")
    public WebElement sep;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(10)')]")
    public WebElement oct;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(11)')]")
    public WebElement nov;
    @FindBy(xpath = "//label[contains(@onclick, 'select_month(12)')]")
    public WebElement dec;
    @FindBy(xpath = "(//button[@id='dropdownMenuButton1'])[3]")
    public WebElement yearsDropdown;
    @FindBy(id = "li_year_2023")
    public WebElement year2023;
    @FindBy(id = "leave_type")
    public WebElement leaveTypeE;
    @FindBy(id = "period_leave")
    public WebElement leavePeriodE;
    @FindBy(id = "leave_p_btn")
    public WebElement addLeaveBtn;
    @FindBy(id = "overtime_type_1")
    public WebElement overtimeTypeE;
    @FindBy(id = "period_overtime_1")
    public WebElement overtimePeriodE;
    @FindBy(id = "overtime_pay_1")
    public WebElement overtimePaymentE;
    @FindBy(id = "overtime_project_1")
    public WebElement projectE;
    @FindBy(id = "overtime_activity_1")
    public WebElement activityE;
    @FindBy(id = "overtime_jobcard_1")
    public WebElement jobCardE;
    @FindBy(id = "overtime_p_btn")
    public WebElement addOvertimeBtn;
    @FindBy(id = "lv_type_day_1_1_1_lbl")
    public WebElement leaveNameDay1;
    @FindBy(id = "lv_type_day_1_2_1_lbl")
    public WebElement leave2NameDay1;
    @FindBy(id = "lv_type_day_2_1_1_lbl")
    public WebElement leaveNameDay2;
    @FindBy(id = "ot_type_day_1_1_1_lbl")
    public WebElement overtimeNameDay1;
    @FindBy(id = "ot_type_day_1_2_1_lbl")
    public WebElement overtime2NameDay1;
    @FindBy(id = "ot_type_day_2_1_1_lbl")
    public WebElement overtimeNameDay2;
    @FindBy(id = "lv_period_day_1_1_1_lbl")
    public WebElement leavePeriodDay1;
    @FindBy(id = "lv_period_day_1_2_1_lbl")
    public WebElement leave2PeriodDay1;
    @FindBy(id = "lv_period_day_2_1_1_lbl")
    public WebElement leavePeriodDay2;
    @FindBy(xpath = "(//div[@id='overtime_acc_1']//label)[3]")
    public WebElement overtimeAmountDay1;
    @FindBy(xpath = "(//div[@id='overtime_acc_1']//label)[8]")
    public WebElement overtime2AmountDay1;
    @FindBy(xpath = "(//div[@id='overtime_acc_2']//label)[3]")
    public WebElement overtimeAmountDay2;
    @FindBy(id = "ot_nonepay_day_1_1_1_lbl")
    public WebElement overtimePaymentDay1;
    @FindBy(id = "ot_nonepay_day_1_2_1_lbl")
    public WebElement overtime2PaymentDay1;
    @FindBy(id = "ot_nonepay_day_2_1_1_lbl")
    public WebElement overtimePaymentDay2;
    @FindBy(id = "ot_project_day_1_1_1_lbl")
    public WebElement overtimeProjectDay1;
    @FindBy(id = "ot_project_day_2_1_1_lbl")
    public WebElement overtimeProjectDay2;
    @FindBy(xpath = "//div[@id='vac_coll_1']//label")
    public List <WebElement> vacationDetailsInDay1_List;
    @FindBy(xpath = "//button[contains(@id,'vac_col_btn_')]")
    public List <WebElement> vacationName_List;
    public By toCheckLeaveDay3 = By.id("acc_btn_l_3");
    public By toCheckLeaveDay1 = By.id("acc_btn_l_1");
    @FindBy(xpath = "//img[contains(@src, 'redclose.svg')]")
    public WebElement deleteTransactions;
    @FindBy(xpath = "//img[contains(@src, 'moh.svg')]")
    public WebElement editTransactions;
    @FindBy(xpath = "//button[contains(@onclick, 'Remove_calender_alert')]")
    public WebElement okBtn;
    @FindBy(xpath = "//div[contains(@id,'day_')]//button")
    public List<WebElement> transactionAfterAdd_List;
    @FindBy(className = "accordion-item")
    public List <WebElement> findTransactionOnDays;
    @FindBy(xpath = "(//label[@class='font-size-13'])[1]")
    public WebElement employeeName;
    @FindBy(tagName = "b")
    public WebElement checkPermission;
    @FindBy(xpath = "//li[@id='employee_search_searchresults']//img[contains(@src, '/celender/')]")
    public WebElement employeeStatus;
    @FindBy(id = "save")
    public WebElement saveBtn;
    @FindBy(xpath = "//img[contains(@src, 'trans_alert.svg')]")
    public WebElement alertBtn;
    @FindBy(xpath = "(//div[contains(@class,'col-md-9 p-2')]//div)[2]")
    public WebElement alertText;
    @FindBy(className = "alert-label")
    public WebElement alertBox;

    public void openEmployeeCalendar(){

        closeIFrame();
        hold(300);
        clickOn(inquiry);
        hold(300);
        clickOn(employeeCalendarBtn);
        hold(500);
        goToFrame(menaBoxIFrame);
        hold(300);

        setLog("Open Employee Calendar");

    }
    public void chooseEmployee(String employeeCode, boolean getFromAdvanceSearch){

        elementWaitAdvanced(By.id("day_1"));

        if(!getFromAdvanceSearch){
            clickOn(empCodeClickField);
            hold(400);
            setText(empCode, employeeCode);
            hold(500);
            clickOn(firstEmployee);
            hold(300);
        }else{
            StringSelection stringSelection = new StringSelection(employeeCode);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            clickOn(advanceSearchBtn);
            hold(500);
            advanceSearch_searchField.sendKeys(Keys.chord(Keys.CONTROL, "v"));
            hold(1000);
            clickOn(advanceSearch_clickOnEmployee.get(0));
            hold(500);

        }

        setLog("choose Employee: "+employeeCode);

    }

    public void setEmployeeCodeToCheckStatus(String employeeCode){

        elementWaitAdvanced(By.id("body_form"));
        clickOn(empCodeClickField);
        hold(400);
        setText(empCode, employeeCode);
        hold(5000);

    }
    public void goToDateInCalendar(String month, String year){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(300);
        clickOn(getDriver().findElement(By.id("li_year_"+year)));
        hold(300);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        if(month.equals("01")){
            clickOn(jan);
        }else if(month.equals("02")){
            clickOn(feb);
        }else if(month.equals("03")){
            clickOn(mar);
        }else if(month.equals("04")){
            clickOn(apr);
        }else if(month.equals("05")){
            clickOn(may);
        }else if(month.equals("06")){
            clickOn(jun);
        }else if(month.equals("07")){
            clickOn(jul);
        }else if(month.equals("08")){
            clickOn(aug);
        }else if(month.equals("09")){
            clickOn(sep);
        }else if(month.equals("10")){
            clickOn(oct);
        }else if(month.equals("11")){
            clickOn(nov);
        }else if(month.equals("12")){
            clickOn(dec);
        }
        hold(300);
        elementWaitAdvanced(By.id("box2"));

        setLog("Go To Date In Calendar: "+year+" - Month: "+month);

    }

    public void clickOnTransaction(){

        for (WebElement findTransactionOnDay : findTransactionOnDays) {
            clickOn(findTransactionOnDay);
            hold(400);
        }

        setLog("Click On Transaction");

    }

    public void addLeave(String leaveTypeDay1, String leavePeriodDay1, String leaveTypeDay2, String leavePeriodDay2,
                         boolean withoutSave, boolean deleteAfterSave){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(300);
        clickOn(year2023);
        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        clickOn(jan);
        hold(300);
        elementWaitAdvanced(By.id("box2"));
        clickOn(leaveBtn);
        hold(300);
        if(!leaveTypeDay1.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("leave_type"));
            Select select = new Select(leaveTypeE);
            select.selectByVisibleText(leaveTypeDay1);
            hold(500);
            setText(leavePeriodE, leavePeriodDay1);
            hold(500);
            clickOn(addLeaveBtn);
        }
        if(!leaveTypeDay2.isEmpty()){
            clickOn(day_2);
            hold(300);
            elementWaitAdvanced(By.id("leave_type"));
            Select select = new Select(leaveTypeE);
            select.selectByVisibleText(leaveTypeDay2);
            hold(500);
            setText(leavePeriodE, leavePeriodDay2);
            hold(500);
            clickOn(addLeaveBtn);
        }
        clickOn(leaveBtn);
        hold(200);

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

        if(!leaveTypeDay1.isEmpty()){
            clickOn(transactionAfterAdd_List.get(0));
            hold(200);
        }
        if(!leaveTypeDay2.isEmpty()){
            clickOn(transactionAfterAdd_List.get(1));
            hold(200);
        }

        hold(500);
        if(deleteAfterSave){
            if(!leaveTypeDay1.isEmpty()){
                clickOn(deleteTransactions);
                hold(1500);
            }
            if(!leaveTypeDay2.isEmpty()){
                clickOn(deleteTransactions);
                hold(1000);
            }
            clickOn(saveBtn);
            hold(500);
        }

        setLog("Add Leave - "+"leave Type Day 1: "+leaveTypeDay1+" - leave Period Day 1: "+leavePeriodDay1+" - leave Type Day 2: "+leaveTypeDay2+" - leave Period Day 2: "+leavePeriodDay2);

    }

    public void addLeaveToCheckAlerts(String leaveTypeDay1, String leavePeriodDay1, String leaveTypeDay2, String leavePeriodDay2,
                         String leaveTypeDay3, String leavePeriodDay3){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(300);
        clickOn(year2023);
        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        clickOn(jan);
        hold(300);
        elementWaitAdvanced(By.id("box2"));
        clickOn(leaveBtn);
        hold(300);
        if(!leaveTypeDay1.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("leave_type"));
            Select select = new Select(leaveTypeE);
            select.selectByVisibleText(leaveTypeDay1);
            hold(500);
            setText(leavePeriodE, leavePeriodDay1);
            hold(500);
            clickOn(addLeaveBtn);
        }
        if(!leaveTypeDay2.isEmpty()){
            clickOn(day_2);
            hold(300);
            elementWaitAdvanced(By.id("leave_type"));
            Select select = new Select(leaveTypeE);
            select.selectByVisibleText(leaveTypeDay2);
            hold(500);
            setText(leavePeriodE, leavePeriodDay2);
            hold(500);
            clickOn(addLeaveBtn);
        }
        if(!leaveTypeDay3.isEmpty()){
            clickOn(day_3);
            hold(300);
            elementWaitAdvanced(By.id("leave_type"));
            Select select = new Select(leaveTypeE);
            select.selectByVisibleText(leaveTypeDay3);
            hold(500);
            setText(leavePeriodE, leavePeriodDay3);
            hold(500);
            clickOn(addLeaveBtn);
        }
        clickOn(leaveBtn);
        hold(500);

        clickOn(saveBtn);
        hold(500);

        setLog("Add Leave - "+"leave Type Day 1: "+leaveTypeDay1+" - leave Period Day 1: "+leavePeriodDay1+" - leave Type Day 2: "+leaveTypeDay2+" - leave Period Day 2: "+leavePeriodDay2);


    }

    public void addTwoLeave(String leaveType1, String leavePeriod1, String leaveType2, String leavePeriod2, boolean withoutSave){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(500);
        clickOn(year2023);
        hold(300);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        clickOn(jan);
        hold(300);
        elementWaitAdvanced(By.id("box2"));
        clickOn(leaveBtn);
        hold(300);
        if(!leaveType1.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("leave_type"));
            Select select = new Select(leaveTypeE);
            select.selectByVisibleText(leaveType1);
            hold(500);
            setText(leavePeriodE, leavePeriod1);
            hold(500);
            clickOn(addLeaveBtn);
        }
        if(!leaveType2.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("leave_type"));
            Select select2 = new Select(leaveTypeE);
            select2.selectByVisibleText(leaveType2);
            hold(500);
            setText(leavePeriodE, leavePeriod2);
            hold(500);
            clickOn(addLeaveBtn);
        }
        clickOn(leaveBtn);
        hold(200);

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

        if(!leaveType1.isEmpty()){
            clickOn(transactionAfterAdd_List.get(0));
            hold(200);
        }

        hold(500);
        setLog("Add Tow Leave - "+"leave Type 1: "+leaveType1+" - leave Period 1: "+leavePeriod1+" - leave Type 2: "+leaveType2+" - leave Period 2: "+leavePeriod2);

    }

    public void editLeave(String leaveType, String leavePeriod){
        if(!leaveType.isEmpty()){
            clickOn(editTransactions);
            hold(300);
            Select select = new Select(leaveTypeE);
            select.selectByVisibleText(leaveType);
            hold(500);
            leavePeriodE.clear();
            hold(200);
            setText(leavePeriodE, leavePeriod);
            hold(500);
            clickOn(addLeaveBtn);
            hold(500);
            clickOn(saveBtn);
            hold(500);
            clickOn(transactionAfterAdd_List.get(0));
            hold(300);
        }
        setLog("Edit Leave - "+"leaveType: "+leaveType+" - leave Period: "+leavePeriod);
    }

    public void findAlert(){

        hold(300);
        elementWaitAdvanced(By.xpath("//img[contains(@src, 'trans_alert.svg')]"));
        clickOn(alertBtn);
        hold(300);

    }

    public void clickOnDeleteTransaction(){
        hold(300);
        clickOn(deleteTransactions);
        hold(300);
    }
    public void clickOnEditTransaction(){
        hold(300);
        clickOn(editTransactions);
        hold(300);
    }
    public void closeAlert(){
        clickOn(okBtn);
        hold(500);
    }

    public void addOvertime(String typeDay1, String periodDay1, String paymentDay1, String projectDay1, String activityDay1, String jobCardDay1,
                            String typeDay2, String periodDay2, String paymentDay2, String projectDay2, String activityDay2, String jobCardDay2,
                            boolean withoutSave, boolean deleteAfterSave){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(300);
        clickOn(year2023);
        hold(300);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        clickOn(jan);
        hold(300);
        elementWaitAdvanced(By.id("box2"));
        clickOn(overtimeBtn);
        hold(300);
        if(!typeDay1.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("overtime_type_1"));
            Select select = new Select(overtimeTypeE);
            select.selectByVisibleText(typeDay1);
            hold(500);
            setText(overtimePeriodE, periodDay1);
            hold(200);
            Select payment = new Select(overtimePaymentE);
            payment.selectByVisibleText(paymentDay1);
            if(!projectDay1.isEmpty()){
                hold(200);
                Select project = new Select(projectE);
                project.selectByVisibleText(projectDay1);
                if(!activityDay1.isEmpty()){
                    hold(200);
                    Select activity = new Select(activityE);
                    activity.selectByVisibleText(activityDay1);
                    if(!jobCardDay1.isEmpty()){
                        hold(200);
                        Select jobCard = new Select(jobCardE);
                        jobCard.selectByVisibleText(jobCardDay1);
                    }
                }
            }
            hold(500);
            clickOn(addOvertimeBtn);
        }
        if(!typeDay2.isEmpty()){
            clickOn(day_2);
            hold(300);
            elementWaitAdvanced(By.id("overtime_type_1"));
            Select select = new Select(overtimeTypeE);
            select.selectByVisibleText(typeDay2);
            hold(500);
            setText(overtimePeriodE, periodDay2);
            hold(200);
            Select payment = new Select(overtimePaymentE);
            payment.selectByVisibleText(paymentDay2);
            if(!projectDay2.isEmpty()){
                hold(200);
                Select project = new Select(projectE);
                project.selectByVisibleText(projectDay2);
                if(!activityDay2.isEmpty()){
                    hold(200);
                    Select activity = new Select(activityE);
                    activity.selectByVisibleText(activityDay2);
                    if(!jobCardDay2.isEmpty()){
                        hold(200);
                        Select jobCard = new Select(jobCardE);
                        jobCard.selectByVisibleText(jobCardDay2);
                    }
                }
            }
            hold(500);
            clickOn(addOvertimeBtn);
        }
        clickOn(overtimeBtn);
        hold(200);

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

        if(!typeDay1.isEmpty()){
            clickOn(transactionAfterAdd_List.get(0));
            hold(200);
        }
        if(!typeDay2.isEmpty()){
            clickOn(transactionAfterAdd_List.get(1));
            hold(200);
        }

        hold(500);
        if(deleteAfterSave){
            if(!typeDay1.isEmpty()){
                clickOn(deleteTransactions);
                hold(1500);
            }
            if(!typeDay2.isEmpty()){
                clickOn(deleteTransactions);
                hold(1000);
            }
            clickOn(saveBtn);
            hold(500);
        }

        setLog("Add Overtime - "+"type Day 1:"+typeDay1+" - period Day 1: "+periodDay1+" - payment Day 1: "+paymentDay1+" - project Day 1: "+projectDay1+" - activity Day 1: "+activityDay1+"job Card Day 1: "+jobCardDay2+" - type Day 2:"+typeDay2+" - period Day 2: "+periodDay1+" - payment Day 2: "+paymentDay2+" - project Day 2: "+projectDay2+" - activity Day 2: "+activityDay1+"job Card Day 2: "+jobCardDay2);

    }

    public void addTwoOvertime(String type1, String period1, String payment1, String project1, String activity1, String jobCard1,
                            String type2, String period2, String payment2, String project2, String activity2, String jobCard2,
                            boolean withoutSave){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(300);
        clickOn(year2023);
        hold(300);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        clickOn(jan);
        hold(300);
        elementWaitAdvanced(By.id("box2"));
        clickOn(overtimeBtn);
        hold(300);
        if(!type1.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("overtime_type_1"));
            Select select = new Select(overtimeTypeE);
            select.selectByVisibleText(type1);
            hold(500);
            setText(overtimePeriodE, period1);
            hold(200);
            Select payment = new Select(overtimePaymentE);
            payment.selectByVisibleText(payment1);
            if(!project1.isEmpty()){
                hold(200);
                Select project = new Select(projectE);
                project.selectByVisibleText(project1);
                if(!activity1.isEmpty()){
                    hold(200);
                    Select activity = new Select(activityE);
                    activity.selectByVisibleText(activity1);
                    if(!jobCard1.isEmpty()){
                        hold(200);
                        Select jobCard = new Select(jobCardE);
                        jobCard.selectByVisibleText(jobCard1);
                    }
                }
            }
            hold(500);
            clickOn(addOvertimeBtn);
        }
        if(!type2.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("overtime_type_1"));
            Select select = new Select(overtimeTypeE);
            select.selectByVisibleText(type2);
            hold(500);
            setText(overtimePeriodE, period2);
            hold(200);
            Select payment = new Select(overtimePaymentE);
            payment.selectByVisibleText(payment2);
            if(!project2.isEmpty()){
                hold(200);
                Select project = new Select(projectE);
                project.selectByVisibleText(project2);
                if(!activity2.isEmpty()){
                    hold(200);
                    Select activity = new Select(activityE);
                    activity.selectByVisibleText(activity2);
                    if(!jobCard2.isEmpty()){
                        hold(200);
                        Select jobCard = new Select(jobCardE);
                        jobCard.selectByVisibleText(jobCard2);
                    }
                }
            }
            hold(500);
            clickOn(addOvertimeBtn);
        }
        clickOn(overtimeBtn);
        hold(200);

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

        if(!type1.isEmpty()){
            clickOn(transactionAfterAdd_List.get(0));
            hold(200);
        }

        hold(500);

        setLog("Add Overtime - "+"type 1:"+type1+" - period 1: "+period1+" - payment 1: "+payment1+" - project 1: "+project1+" - activity 1: "+activity1+"job Card 1: "+jobCard2+" - type 2:"+type2+" - period 2: "+period1+" - payment 2: "+payment2+" - project 2: "+project2+" - activity 2: "+activity1+"job Card 2: "+jobCard2);

    }

    public void addOvertimeToCheckAlerts(String type1, String period1, String payment1, String project1, String activity1, String jobCard1,
                               String type2, String period2, String payment2, String project2, String activity2, String jobCard2){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(300);
        clickOn(year2023);
        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        clickOn(jan);
        hold(300);
        elementWaitAdvanced(By.id("box2"));
        clickOn(overtimeBtn);
        hold(300);
        if(!type1.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("overtime_type_1"));
            Select select = new Select(overtimeTypeE);
            select.selectByVisibleText(type1);
            hold(500);
            setText(overtimePeriodE, period1);
            hold(200);
            Select payment = new Select(overtimePaymentE);
            payment.selectByVisibleText(payment1);
            if(!project1.isEmpty()){
                hold(200);
                Select project = new Select(projectE);
                project.selectByVisibleText(project1);
                if(!activity1.isEmpty()){
                    hold(200);
                    Select activity = new Select(activityE);
                    activity.selectByVisibleText(activity1);
                    if(!jobCard1.isEmpty()){
                        hold(200);
                        Select jobCard = new Select(jobCardE);
                        jobCard.selectByVisibleText(jobCard1);
                    }
                }
            }
            hold(500);
            clickOn(addOvertimeBtn);
        }
        if(!type2.isEmpty()){
            clickOn(day_1);
            hold(300);
            elementWaitAdvanced(By.id("overtime_type_1"));
            Select select = new Select(overtimeTypeE);
            select.selectByVisibleText(type2);
            hold(500);
            setText(overtimePeriodE, period2);
            hold(200);
            Select payment = new Select(overtimePaymentE);
            payment.selectByVisibleText(payment2);
            if(!project2.isEmpty()){
                hold(200);
                Select project = new Select(projectE);
                project.selectByVisibleText(project2);
                if(!activity2.isEmpty()){
                    hold(200);
                    Select activity = new Select(activityE);
                    activity.selectByVisibleText(activity2);
                    if(!jobCard2.isEmpty()){
                        hold(200);
                        Select jobCard = new Select(jobCardE);
                        jobCard.selectByVisibleText(jobCard2);
                    }
                }
            }
            hold(500);
            clickOn(addOvertimeBtn);
        }
        clickOn(overtimeBtn);
        hold(300);

        clickOn(saveBtn);
        hold(500);

        setLog("Add Overtime - "+"type 1:"+type1+" - period 1: "+period1+" - payment 1: "+payment1+" - project 1: "+project1+" - activity 1: "+activity1+"job Card 1: "+jobCard2+" - type 2:"+type2+" - period 2: "+period1+" - payment 2: "+payment2+" - project 2: "+project2+" - activity 2: "+activity1+"job Card 2: "+jobCard2);

    }

    public void editOvertime(String type, String period, String payment){
        if(!type.isEmpty()){
            clickOn(editTransactions);
            hold(300);
            Select select = new Select(overtimeTypeE);
            select.selectByVisibleText(type);
            hold(500);
            overtimePeriodE.clear();
            hold(200);
            setText(overtimePeriodE, period);
            hold(500);
            Select select2 = new Select(overtimePaymentE);
            select2.selectByVisibleText(payment);
            hold(500);
            clickOn(addOvertimeBtn);
            hold(500);
            clickOn(saveBtn);
            hold(500);
            clickOn(transactionAfterAdd_List.get(0));
            hold(300);
        }
        setLog("Edit Overtime - "+"Type: "+type+" - Period: "+period+" - Payment: "+payment);
    }

    public void addVacation(String type, int numberOfVacations, boolean deleteAfterSave, boolean clickOnVacationAfterSave){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(300);
        clickOn(year2023);
        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        clickOn(jan);
        hold(300);
        elementWaitDisappear(loadingElement);
        hold(300);
        clickOn(vacationBtn);
        hold(300);
        if(!type.isEmpty()){
            Select select = new Select(vacationTypeE);
            select.selectByVisibleText(type);
            hold(500);

            for(int i = 1;i<=numberOfVacations;i++){
                if(i == 21){
                    scrollToElement(day_21);
                }
                getDriver().findElement(By.id("day_"+i)).click();
                hold(100);
            }
            hold(300);
            scrollToElement(saveBtn);
            hold(500);
            clickOn(vacationBtn);
            hold(500);
        }

        clickOn(saveBtn);
        hold(500);

        if(clickOnVacationAfterSave){
            for(int i = 1;i<=numberOfVacations;i++){
                if(i == 21){
                    scrollToElement(day_21);
                }
                getDriver().findElement(By.id("vac_col_btn_"+i)).click();
                hold(200);
            }
            scrollToElement(saveBtn);
            hold(500);
        }

        if(deleteAfterSave){
            if(checkElementIfPresent(By.xpath("//img[contains(@src, 'redclose.svg')]"))){
                clickOn(deleteTransactions);
                hold(500);
            }
            clickOn(saveBtn);
            hold(500);
        }

        setLog("Add Vacation - "+"Type: "+type+" - Number Of Vacations: "+numberOfVacations);

    }

    public void addVacation(String year, String month, String type, int numberOfVacations, boolean deleteAfterSave, boolean clickOnVacationAfterSave){

        hold(500);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(yearsDropdown);
        hold(300);
        clickOn(getDriver().findElement(By.id("li_year_"+year)));
        hold(300);
        elementWaitAdvanced(By.id("dropdownMenuButton1"));
        clickOn(monthDropdown);
        hold(1000);
        if(month.equalsIgnoreCase("jan")){
            clickOn(jan);
        }else if(month.equalsIgnoreCase("feb")){
            clickOn(feb);
        }else if(month.equalsIgnoreCase("mar")){
            clickOn(mar);
        }else if(month.equalsIgnoreCase("apr")){
            clickOn(apr);
        }else if(month.equalsIgnoreCase("may")){
            clickOn(may);
        }else if(month.equalsIgnoreCase("jun")){
            clickOn(jun);
        }else if(month.equalsIgnoreCase("jul")){
            clickOn(jul);
        }else if(month.equalsIgnoreCase("aug")){
            clickOn(aug);
        }else if(month.equalsIgnoreCase("sep")){
            clickOn(sep);
        }else if(month.equalsIgnoreCase("oct")){
            clickOn(oct);
        }else if(month.equalsIgnoreCase("nov")){
            clickOn(nov);
        }else if(month.equalsIgnoreCase("dec")){
            clickOn(dec);
        }else{
            Assert.fail("Wrong Month!");
        }
        hold(300);
        elementWaitDisappear(loadingElement);
        hold(300);
        clickOn(vacationBtn);
        hold(300);
        if(!type.isEmpty()){
            Select select = new Select(vacationTypeE);
            select.selectByVisibleText(type);
            hold(500);

            for(int i = 1;i<=numberOfVacations;i++){
                if(i == 21){
                    scrollToElement(day_21);
                }
                getDriver().findElement(By.id("day_"+i)).click();
                hold(100);
            }
            hold(300);
            scrollToElement(saveBtn);
            hold(500);
            clickOn(vacationBtn);
            hold(500);
        }

        clickOn(saveBtn);
        hold(500);

        if(clickOnVacationAfterSave){
            for(int i = 1;i<=numberOfVacations;i++){
                if(i == 21){
                    scrollToElement(day_21);
                }
                getDriver().findElement(By.id("vac_col_btn_"+i)).click();
                hold(200);
            }
            scrollToElement(saveBtn);
            hold(500);
        }

        if(deleteAfterSave){
            if(checkElementIfPresent(By.xpath("//img[contains(@src, 'redclose.svg')]"))){
                clickOn(deleteTransactions);
                hold(500);
            }
            clickOn(saveBtn);
            hold(500);
        }

        setLog("Add Vacation - Year:"+year+" - Month: "+month+" - Type: "+type+" - Number Of Vacations: "+numberOfVacations);

    }

}

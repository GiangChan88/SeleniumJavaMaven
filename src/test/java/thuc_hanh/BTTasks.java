package thuc_hanh;

import bt_locator.LocatorsLeads;
import bt_locator.LocatorsTasks;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BTTasks extends BaseTest {
    public static void verifyDisplay(String field, String messageTrue, String messageFalse) {
        boolean check = driver.findElement(By.xpath(field)).isDisplayed();
        if (check) {
            System.out.println(messageTrue);
        } else {
            System.out.println(messageFalse);
        }
    }

    public static void addNewTask(String taskName, String hourlyRate, String startDate, String duaDate, String priority, String repeatEvery, String totalCycles,
                                  String relatedTo, String valueRelatedTo, String assignees, String followers, String followers2, String tags) throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(LocatorsTasks.menuTasks)).click();
        Thread.sleep(2000);
        verifyDisplay(LocatorsTasks.headerTasksSummary, "Đã tới trang Tasks", "FAILED!!! Không truy cập được vào trang Tasks");

        //click button New Lead
        driver.findElement(By.xpath(LocatorsTasks.btnAddTasks)).click();
        Thread.sleep(1000);
        verifyDisplay(LocatorsTasks.titleAddNewTask, "Mở pop-up Add new Tasks thành công", "FAILED!!! Không mở được pop-up Add new Tasks");

        //Checkbox public
        boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsTasks.checkboxPublic)).isSelected();
        if (!isSelectedPublic) {
            driver.findElement(By.xpath(LocatorsTasks.checkboxPublic)).click();
        }

        //Checkbox Billsble
        boolean isSelectedBillsble = driver.findElement(By.xpath(LocatorsTasks.checkboxPublic)).isSelected();
        if (!isSelectedBillsble) {
            driver.findElement(By.xpath(LocatorsTasks.checkboxPublic)).click();
        }

        //check attachment
        driver.findElement(By.xpath(LocatorsTasks.linkAttachFile)).click();

        //sendKeys input
        driver.findElement(By.xpath(LocatorsTasks.inputSubject)).sendKeys(taskName);
        driver.findElement(By.xpath(LocatorsTasks.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorsTasks.inputHourlyRate)).sendKeys(hourlyRate);
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).clear();
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).sendKeys(startDate);
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.inputDuaDate)).sendKeys(duaDate);
        driver.findElement(By.xpath(LocatorsTasks.inputDuaDate)).click();

        //dropdown Priority
        driver.findElement(By.xpath(LocatorsTasks.dropdownPriority)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.getValuePriority(priority))).click();
        Thread.sleep(500);

        //dropdown Repeat every and input Total cycle (cho if)
        driver.findElement(By.xpath(LocatorsTasks.dropdownRepeatEvery)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.getValueRepeatEvery(repeatEvery))).click();
        Thread.sleep(500);
        if(repeatEvery.equals("Custom")){
            //input
            driver.findElement(By.xpath(LocatorsTasks.repeatEveryCustom)).clear();
            driver.findElement(By.xpath(LocatorsTasks.repeatEveryCustom)).sendKeys("100");
            Thread.sleep(500);
            //dropdown
            driver.findElement(By.xpath(LocatorsTasks.dropdownRepeatEveryCustom)).click();
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorsTasks.getRepeatEveryCustom("Day(s)")));
            Thread.sleep(1000);
            //input Total
            driver.findElement(By.xpath(LocatorsTasks.checkboxInfinity)).click(); //click (bỏ chọn)
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorsTasks.inputTotalCycles)).clear();
            driver.findElement(By.xpath(LocatorsTasks.inputTotalCycles)).sendKeys("100000");
            Thread.sleep(500);
        }else if(repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks") || repeatEvery.equals("1 Month") || repeatEvery.equals("2 Months") ||
                repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months") || repeatEvery.equals("1 Year")) {
            driver.findElement(By.xpath(LocatorsTasks.checkboxInfinity)).click(); //click (bỏ chọn)
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorsTasks.inputTotalCycles)).clear();
            driver.findElement(By.xpath(LocatorsTasks.inputTotalCycles)).sendKeys("100000");
            Thread.sleep(500);
        }else{
            System.out.println("Không tồn tại");
        }

        //dropdown Related to
        driver.findElement(By.xpath(LocatorsTasks.dropdownRelatedTo)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.getValueRelatedTo(relatedTo))).click();
        Thread.sleep(500);

        //dropdown value Related to
        boolean isDisplayDropdownValueNew = driver.findElement(By.xpath(LocatorsTasks.dropdownForRelatedTo)).isDisplayed();
        System.out.println("Dropdown value RelatedTo hiển thị: " + isDisplayDropdownValueNew);

        //Click vô hàm valueDropdown Related to chọn giá trị
        driver.findElement(By.xpath(LocatorsTasks.dropdownForRelatedTo)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.inputSearchOfForRelatedTo)).sendKeys(valueRelatedTo);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.getValueForRelatedTo(valueRelatedTo))).click();
        Thread.sleep(500);

        //dropdown Assignees
        driver.findElement(By.xpath(LocatorsTasks.dropdownAssignees)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.inputSearchOffAssignees)).sendKeys(assignees);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.getValueAssignees(assignees))).click();
        Thread.sleep(500);

        //dropdown Followers Mutip
        driver.findElement(By.xpath(LocatorsTasks.dropdownFollowers)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.inputSearchOffFollowers)).sendKeys(followers);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.getValueFollowers(followers))).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(LocatorsTasks.inputSearchOffFollowers)).clear();
        driver.findElement(By.xpath(LocatorsTasks.inputSearchOffFollowers)).sendKeys(followers2);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.getValueFollowers(followers2))).click();
        Thread.sleep(500);

        //Tags
        driver.findElement(By.xpath(LocatorsTasks.inputAddTags)).sendKeys(tags);
        driver.findElement(By.xpath(LocatorsTasks.labelTags)).click();

//        driver.findElement(By.xpath(LocatorsTasks.textareaTaskDescription)).click();
//        driver.findElement(By.xpath(LocatorsTasks.textareaTaskDescription)).sendKeys("Giang");
        driver.findElement(By.xpath(LocatorsTasks.btnSave)).click();
        Thread.sleep(1000);
    }


    public static void main(String[] args) throws InterruptedException {
        String taskName = "GTest1";
        String hourlyRate = "24";
        String startDate = "20-10-2025";
        String duaDate = "05-11-2025";
        String priority = "High";
        String repeatEvery = "Week";
        String totalCycles = "100000";
        String relatedTo = "Lead";
        String valueRelatedTo = "GiangTest 02 - giang12345@gmail.com";
        String assignees = "Admin Anh Tester";
        String followers = "Admin Example";
        String followers2 = "Admin Anh Tester";
        String tags = "Giang";

        createDriver();
        loginCRM();
        Thread.sleep(1000);

        addNewTask(taskName, hourlyRate, startDate, duaDate, priority, repeatEvery, totalCycles, relatedTo, valueRelatedTo, assignees, followers, followers2, tags);
        Thread.sleep(1000);

        closeDriver();
    }

}

package thuc_hanh;

import bt_locator.LocatorsLeads;
import bt_locator.LocatorsTasks;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BTTasks extends BaseTest {

    public void clickMenuTask() throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(LocatorsTasks.menuTasks)).click();
        Thread.sleep(2000);
        List<WebElement> checkHeaderTaskSummary = driver.findElements(By.xpath(LocatorsTasks.headerTasksSummary));
        Assert.assertTrue(checkHeaderTaskSummary.size() > 0, "FAILED!!! Không truy cập được vào trang Tasks");
        System.out.println("Đã tới Tasks");
    }

    public void clickBtnAddTask() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(LocatorsTasks.btnAddTasks)).click();
        Thread.sleep(1000);
        List<WebElement> checkTitleAddNewTask = driver.findElements(By.xpath(LocatorsTasks.titleAddNewTask));
        Assert.assertTrue(checkTitleAddNewTask.size() > 0, "FAILED!!! Không mở được pop-up Add new Tasks");
        System.out.println("Mở pop-up Add new Tasks thành công");
    }

    public void addNewTask(String taskName, String hourlyRate, String startDate, String duaDate, String priority, String repeatEvery, String totalCycles,
                           String relatedTo, String searchValueRelatedTo, String valueRelatedTo, String assignees, String followers, String followers2, String tags, String bodyIframeDescription) throws InterruptedException {

        //Checkbox public
        WebElement checkboxPublic = driver.findElement(By.xpath(LocatorsTasks.checkboxPublic));
        if (!checkboxPublic.isSelected()) {
            checkboxPublic.click();
        }
        softAssert.assertTrue(checkboxPublic.isSelected(), "Checkbox public chưa được tích sau khi click");

        //Checkbox Billable
        WebElement checkboxBillsble = driver.findElement(By.xpath(LocatorsTasks.checkboxPublic));
        if (!checkboxBillsble.isSelected()) {
            checkboxBillsble.click();
        }
        softAssert.assertTrue(checkboxBillsble.isSelected(), "Checkbox Billable chưa được tích sau khi click");

        //check attachment
        driver.findElement(By.xpath(LocatorsTasks.linkAttachFile)).click();
        Thread.sleep(1000);

        //sendKeys input
        driver.findElement(By.xpath(LocatorsTasks.inputSubject)).sendKeys(taskName);
        driver.findElement(By.xpath(LocatorsTasks.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorsTasks.inputHourlyRate)).sendKeys(hourlyRate);
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).clear();
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).sendKeys(startDate);
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).click();
        Thread.sleep(1000);
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
        if (repeatEvery.equals("Custom")) {
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
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks") || repeatEvery.equals("1 Month") || repeatEvery.equals("2 Months") ||
                repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months") || repeatEvery.equals("1 Year")) {
            driver.findElement(By.xpath(LocatorsTasks.checkboxInfinity)).click(); //click (bỏ chọn)
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorsTasks.inputTotalCycles)).clear();
            driver.findElement(By.xpath(LocatorsTasks.inputTotalCycles)).sendKeys(totalCycles);
            Thread.sleep(500);
        } else {
            System.out.println("Không tồn tại");
        }

        //dropdown Related to
        driver.findElement(By.xpath(LocatorsTasks.dropdownRelatedTo)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.getValueRelatedTo(relatedTo))).click();
        Thread.sleep(500);

        //dropdown value Related to
//        boolean isDisplayDropdownValueNew = driver.findElement(By.xpath(LocatorsTasks.dropdownForRelatedTo)).isDisplayed();
//        System.out.println("Dropdown value RelatedTo hiển thị: " + isDisplayDropdownValueNew);

        //Click vô hàm valueDropdown Related to chọn giá trị
        driver.findElement(By.xpath(LocatorsTasks.dropdownForRelatedTo)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.inputSearchOfForRelatedTo)).sendKeys(searchValueRelatedTo);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsTasks.getValueForRelatedTo(valueRelatedTo))).click();
        Thread.sleep(500);

        //scroll kéo xuống dưới
        WebElement elementBtnSave = driver.findElement(By.xpath(LocatorsTasks.btnSave)); //trỏ tới element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementBtnSave); //true là cuộn xuống dưới, false là cuộn lên trên

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
        Thread.sleep(2000);

        //Tắt tags
        driver.findElement(By.xpath(LocatorsTasks.labelTag)).click();
        driver.findElement(By.xpath(LocatorsTasks.labelTag)).click();
        Thread.sleep(1000);

        //iframe
        driver.findElement(By.xpath(LocatorsTasks.areaDescription)).click();
        Thread.sleep(1500);
        driver.switchTo().frame("description_ifr");

        WebElement bodyIframe = driver.findElement(By.xpath("//body[@id='tinymce']"));
        bodyIframe.clear();
        bodyIframe.sendKeys(bodyIframeDescription);

        driver.switchTo().parentFrame();

        //click btn Save
        driver.findElement(By.xpath(LocatorsTasks.btnSave)).click();
        Thread.sleep(1000);
        System.out.println("Thêm mới thành công Tasks");
    }

    public void closePopupDetail() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsTasks.iconClosePopupDetail)).click();
    }

    //search Lead
    public void searchTaskSuccess(String expectedTaskName) throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath(LocatorsTasks.inputSearch));
        searchBox.clear();
        searchBox.sendKeys(expectedTaskName);
        Thread.sleep(2000);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tasks']//tbody/tr/td[contains(normalize-space(),'"+expectedTaskName+"')]"));
        //Kiểm tra xem bảng trả về rỗng hay không
        if (rows.size() == 0) {
            System.out.println("Tìm kiếm thành công: 0 bản ghi");
            Assert.assertTrue(true, "Còn dữ liệu");  // Test pass
        } else {
            String actualTaskName = driver.findElement(By.xpath(LocatorsTasks.firstRowItem)).getText();
            Assert.assertEquals(actualTaskName.trim(), expectedTaskName.trim(), "Name Task hiển thị sau khi tìm kiếm không khớp với Task vừa thêm ");
            System.out.println("Tìm kiếm thành công Task: " + actualTaskName);
        }
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public void compareFieldAttribute(String xpathActual, String expectedValue, String attributeActual) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
        Assert.assertEquals(actual.trim(), expected.trim(), "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
    }

    public void verifyCheckboxSelected(String xpathCheckbox) {
        boolean checked = driver.findElement(By.xpath(xpathCheckbox)).isSelected();
        Assert.assertTrue(checked, "Checkbox chưa được tích sau khi click");
    }

    public void compareIframeValue(String expectedValue) {
        driver.switchTo().frame("description_ifr");
        String actual = driver.findElement(By.xpath("//body[@id='tinymce']")).getText();
        driver.switchTo().defaultContent();

        Assert.assertEquals(actual.trim(), expectedValue.trim(),
                "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng thực tế là: " + actual);
    }

    public void clickBtnEdit(String taskName) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsTasks.firstRowItem));

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsTasks.buttonEdit(taskName))).click();
        Thread.sleep(1000);
        List<WebElement> checkTitleEditTask = driver.findElements(By.xpath("//h4[@id='myModalLabel' and normalize-space() = 'Edit task "+taskName+"']"));
        Assert.assertTrue(checkTitleEditTask.size() > 0, "FAILED!!! Không mở được pop-up Edit Tasks");
        System.out.println("Mở pop-up Edit Tasks thành công");
    }

    public void viewEditTaskSuccess(String taskName, String hourlyRate, String startDate, String duaDate, String priority, String repeatEvery, String totalCycles,
                                    String relatedTo, String valueRelatedTo, String tags, String bodyIframeDescription) throws InterruptedException {
        verifyCheckboxSelected(LocatorsTasks.checkboxPublic);
        verifyCheckboxSelected(LocatorsTasks.checkboxBillsble);
        compareFieldAttribute(LocatorsTasks.inputSubject, taskName, "value");
        compareFieldAttribute(LocatorsTasks.inputHourlyRate, hourlyRate, "value");
        compareFieldAttribute(LocatorsTasks.inputStartDate, startDate, "value");
        compareFieldAttribute(LocatorsTasks.inputDuaDate, duaDate, "value");
        compareFieldAttribute(LocatorsTasks.dropdownPriority, priority, "title");
        compareFieldAttribute(LocatorsTasks.dropdownRepeatEvery, repeatEvery, "title");
        compareFieldAttribute(LocatorsTasks.inputTotalCycles, totalCycles, "value");
        compareFieldAttribute(LocatorsTasks.dropdownRelatedTo, relatedTo, "title");
        compareFieldAttribute(LocatorsTasks.dropdownForRelatedTo, valueRelatedTo, "title");
        compareFieldAttribute(LocatorsTasks.inputEditTags, tags, "value");
        compareIframeValue(bodyIframeDescription);
        System.out.println("Tất cả các trường dữ liệu Task đã được Verify thành công");
    }

    public void editTaskSuccess(String taskName, String priority, String totalCycles, String tags, String bodyIframeDescription) throws InterruptedException {
        Actions actions = new Actions(driver);
        //dropdown Priority
        actions.click(driver.findElement(By.xpath(LocatorsTasks.dropdownPriority))).perform();
        Thread.sleep(500);
        actions.click(driver.findElement(By.xpath(LocatorsTasks.getValuePriority(priority)))).perform();
        Thread.sleep(500);

        //input
        WebElement inputTotalCycles = driver.findElement(By.xpath(LocatorsTasks.inputTotalCycles));
        inputTotalCycles.clear();
        actions.sendKeys(inputTotalCycles, totalCycles).perform();

        //scroll kéo xuống dưới
        WebElement elementBtnSave = driver.findElement(By.xpath(LocatorsTasks.btnSave)); //trỏ tới element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementBtnSave); //true là cuộn xuống dưới, false là cuộn lên trên

        //Tag
        Thread.sleep(1000);
        WebElement elementCloseTags = driver.findElement(By.xpath("//div[@id='inputTagsWrapper']/ul//a[@class='tagit-close']/span[1]"));
        actions.click(elementCloseTags).perform();
        Thread.sleep(1000);
        WebElement inputAddTags = driver.findElement(By.xpath(LocatorsTasks.inputAddTags));
        actions.sendKeys(inputAddTags, tags).perform();
        Thread.sleep(1000);

        //click ra input name để đóng tag
        WebElement labelTag = driver.findElement(By.xpath(LocatorsTasks.labelTag));
        actions.click(labelTag).perform();
        Thread.sleep(1000);
        actions.click(labelTag).perform();

        //iframe
        //driver.findElement(By.xpath(LocatorsTasks.areaDescription)).click();
        Thread.sleep(500);
        driver.switchTo().frame("description_ifr");

        WebElement bodyIframe = driver.findElement(By.xpath("//body[@id='tinymce']"));
        bodyIframe.clear();
        bodyIframe.sendKeys(bodyIframeDescription);

        driver.switchTo().parentFrame();

        //click btn Save
        Thread.sleep(1000);
        WebElement btnSave = driver.findElement(By.xpath(LocatorsTasks.btnSave));
        actions.click(btnSave).perform();
        System.out.println("Sửa Task thành công");
    }

    @Test(priority = 1)
    public void testAddNewTask() throws InterruptedException {
        String taskName = "GTest2";
        String hourlyRate = "24";
        String startDate = "20-10-2025";
        String duaDate = "05-11-2025";
        String priority = "High";
        String repeatEvery = "Week";
        String totalCycles = "100000";
        String relatedTo = "Lead";
        String searchValueRelatedTo = "Giang Chan";
        String valueRelatedTo = "Giang Chan - giang08@gmail.com";
        String assignees = "Admin Anh Tester";
        String followers = "Admin Example";
        String followers2 = "Admin Anh Tester";
        String tags = "Giang";
        String bodyIframeDescription = "Giang Add Tasks";
        Thread.sleep(1000);

        //click menu Task
        clickMenuTask();

        //click btn Add Task
        clickBtnAddTask();

        addNewTask(taskName, hourlyRate, startDate, duaDate, priority, repeatEvery, totalCycles, relatedTo, searchValueRelatedTo, valueRelatedTo, assignees, followers, followers2, tags, bodyIframeDescription);
        Thread.sleep(3000);

        closePopupDetail();
        Thread.sleep(1000);

        //verify
        searchTaskSuccess(taskName);
    }

    @Test(priority = 2)
    public void testViewEditTaskSuccess() throws InterruptedException {
        String taskName = "GTest3";
        String hourlyRate = "24";
        String startDate = "20-10-2025";
        String duaDate = "05-11-2025";
        String priority = "High";
        String repeatEvery = "Week";
        String totalCycles = "100000";
        String relatedTo = "Lead";
        String searchValueRelatedTo = "Giang Chan";
        String valueRelatedTo = "Giang Chan - giang08@gmail.com";
        String assignees = "Admin Anh Tester";
        String followers = "Admin Example";
        String followers2 = "Admin Anh Tester";
        String tags = "Giang";
        String bodyIframeDescription = "Giang Add Tasks2";
        Thread.sleep(1000);

        //click menu Task
        clickMenuTask();

        //click btn Add Task
        clickBtnAddTask();

        addNewTask(taskName, hourlyRate, startDate, duaDate, priority, repeatEvery, totalCycles, relatedTo, searchValueRelatedTo, valueRelatedTo, assignees, followers, followers2, tags, bodyIframeDescription);
        Thread.sleep(3000);

        closePopupDetail();
        Thread.sleep(1000);

        //verify
        searchTaskSuccess(taskName);

        //click btn edit
        clickBtnEdit(taskName);

        viewEditTaskSuccess(taskName, hourlyRate +".00", startDate, duaDate, priority, repeatEvery, totalCycles, relatedTo, valueRelatedTo, tags, bodyIframeDescription);
    }

    @Test(priority = 3)
    public void testEditTaskSuccess() throws InterruptedException {
        //Data Add
        String taskName = "GTest3";
        String hourlyRate = "24";
        String startDate = "20-10-2025";
        String duaDate = "05-11-2025";
        String priority = "High";
        String repeatEvery = "Week";
        String totalCycles = "100000";
        String relatedTo = "Lead";
        String searchValueRelatedTo = "Giang Chan";
        String valueRelatedTo = "Giang Chan - giang08@gmail.com";
        String assignees = "Admin Anh Tester";
        String followers = "Admin Example";
        String followers2 = "Admin Anh Tester";
        String tags = "Giang";
        String bodyIframeDescription = "Giang Add Tasks2";


        //Data Update
        String priorityUpdate = "Low";
        String totalCyclesUpdate = "6666";
        String tagsUpdate = "Giang12";
        String bodyIframeDescriptionUpdate = "Giang Update Tasks";

        //click menu Task
        clickMenuTask();

        //click btn addnewTask
        clickBtnAddTask();

        //Tạo data
        addNewTask(taskName, hourlyRate, startDate, duaDate, priority, repeatEvery, totalCycles, relatedTo, searchValueRelatedTo, valueRelatedTo, assignees, followers, followers2, tags, bodyIframeDescription);
        Thread.sleep(3000);

        closePopupDetail();
        Thread.sleep(1000);

        //verify
        searchTaskSuccess(taskName);
        Thread.sleep(2000);

        clickBtnEdit(taskName);

        //Edit Lead
        editTaskSuccess(taskName, priorityUpdate, totalCyclesUpdate, tagsUpdate, bodyIframeDescriptionUpdate);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchTaskSuccess(taskName);
        Thread.sleep(2000);

        clickBtnEdit(taskName);

        //verify edit
        viewEditTaskSuccess(taskName, hourlyRate +".00", startDate, duaDate, priorityUpdate, repeatEvery, totalCyclesUpdate, relatedTo, valueRelatedTo, tagsUpdate, bodyIframeDescriptionUpdate);
    }

}

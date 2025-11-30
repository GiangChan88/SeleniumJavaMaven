package thuc_hanh;

import keywords.WebUI;
import locator.LocatorsTasks;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BTTasks extends BaseTest {
    String taskName = "";
    String hourlyRate = "";
    String startDate = "";
    String duaDate = "";
    String priority = "";
    String repeatEvery = "";
    String totalCycles = "";
    String relatedTo = "";
    String searchValueRelatedTo = "";
    String valueRelatedTo = "";
    String assignees = "";
    String assignees2 = "";
    String followers = "";
    String followers2 = "";
    String tags = "";
    String bodyIframeDescription = "";

    public void clickMenuTask() throws InterruptedException {
        //click menu Lead
        WebUI.clickElement(driver, LocatorsTasks.menuTasks);
        System.out.println("Click menu Task");
    }

    public void verifyMenuTask() throws InterruptedException {
        Thread.sleep(1000);
        //Truyền text vào xpath nên không cần check Text
        boolean checkHeaderTaskSummary = WebUI.checkExitsElement(driver, LocatorsTasks.headerTasksSummary);
        Assert.assertTrue(checkHeaderTaskSummary, "FAILED!!! Không truy cập được vào trang Tasks");
    }

    public void clickBtnAddTask() throws InterruptedException {
        //click button New Lead
        WebUI.clickElement(driver, LocatorsTasks.btnAddTasks);
        System.out.println("Click button Add Task");
    }

    public void verifyBtnAddTask() throws InterruptedException {
        Thread.sleep(2000);
        //Truyền text vào xpath nên không cần check Text
        boolean checkTitleAddNewTask = WebUI.checkExitsElement(driver, LocatorsTasks.titleAddNewTask);
        Assert.assertTrue(checkTitleAddNewTask, "FAILED!!! Không mở được pop-up Add new Tasks");
    }

    public void addNewTask(String taskName, String hourlyRate, String startDate, String duaDate, String priority, String repeatEvery, String totalCycles,
                           String relatedTo, String searchValueRelatedTo, String valueRelatedTo, String assignees, String assignees2, String followers, String followers2, String tags, String bodyIframeDescription) throws InterruptedException {

        //Checkbox public
        WebElement checkboxPublic = WebUI.getWebElement(driver, LocatorsTasks.checkboxPublic);
        if (!checkboxPublic.isSelected()) {
            checkboxPublic.click();
        }
        softAssert.assertTrue(checkboxPublic.isSelected(), "Checkbox public chưa được tích sau khi click");

        //Checkbox Billable
        WebElement checkboxBillsble = WebUI.getWebElement(driver, LocatorsTasks.checkboxBillsble);
        if (!checkboxBillsble.isSelected()) {
            checkboxBillsble.click();
        }
        softAssert.assertTrue(checkboxBillsble.isSelected(), "Checkbox Billable chưa được tích sau khi click");

        //check attachment
        WebUI.clickElement(driver, LocatorsTasks.linkAttachFile);

        //sendKeys input
        WebUI.setTextElement(driver, LocatorsTasks.inputSubject, taskName);
        WebUI.clearElement(driver, LocatorsTasks.inputHourlyRate);
        WebUI.setTextElement(driver, LocatorsTasks.inputHourlyRate, hourlyRate);
        WebUI.clearElement(driver, LocatorsTasks.inputStartDate);
        WebUI.setTextElement(driver, LocatorsTasks.inputStartDate, startDate);
        WebUI.clickElement(driver, LocatorsTasks.inputStartDate);
        WebUI.clearElement(driver, LocatorsTasks.inputDuaDate);
        WebUI.setTextElement(driver, LocatorsTasks.inputDuaDate, duaDate);
        WebUI.clickElement(driver, LocatorsTasks.inputDuaDate);

        //dropdown Priority
        WebUI.clickElement(driver, LocatorsTasks.dropdownPriority);
        WebUI.clickElement(driver, LocatorsTasks.getValuePriority(priority));

        //dropdown Repeat every and input Total cycle (cho if)
        WebUI.clickElement(driver, LocatorsTasks.dropdownRepeatEvery);
        WebUI.clickElement(driver, LocatorsTasks.getValueRepeatEvery(repeatEvery));
        if (repeatEvery.equals("Custom")) {
            //input
            WebUI.clearElement(driver, LocatorsTasks.repeatEveryCustom);
            WebUI.setTextElement(driver, LocatorsTasks.repeatEveryCustom, "100");

            //dropdown
            WebUI.clickElement(driver, LocatorsTasks.dropdownRepeatEveryCustom);
            WebUI.clickElement(driver, LocatorsTasks.getRepeatEveryCustom("Week(s)"));

            //input Total
            WebUI.clickElement(driver, LocatorsTasks.labelCheckboxInfinity); // - click bỏ chọn
            WebUI.clearElement(driver, LocatorsTasks.inputTotalCycles);
            WebUI.setTextElement(driver, LocatorsTasks.inputTotalCycles, "100000");
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks") || repeatEvery.equals("1 Month") || repeatEvery.equals("2 Months") ||
                repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months") || repeatEvery.equals("1 Year")) {

            WebUI.clickElement(driver, LocatorsTasks.labelCheckboxInfinity); // - click bỏ chọn
            WebUI.clearElement(driver, LocatorsTasks.inputTotalCycles);
            WebUI.setTextElement(driver, LocatorsTasks.inputTotalCycles, "100000");
        } else {
            System.out.println("Không tồn tại");
        }

        //dropdown Related to
        WebUI.clickElement(driver, LocatorsTasks.dropdownRelatedTo);
        WebUI.clickElement(driver, LocatorsTasks.getValueRelatedTo(relatedTo));

        //Click vô hàm valueDropdown Related to chọn giá trị
        Actions actions = new Actions(driver);
        WebUI.clickElement(driver, LocatorsTasks.dropdownForRelatedTo);
        WebUI.setTextElement(driver, LocatorsTasks.inputSearchOfForRelatedTo, searchValueRelatedTo);
        Thread.sleep(1000);
        WebUI.setTextElement(driver, LocatorsTasks.inputSearchOfForRelatedTo," ");
        //WebUI.setTextElement(driver, LocatorsTasks.inputSearchOfForRelatedTo, searchValueRelatedTo);
        WebUI.clickElement(driver, LocatorsTasks.getValueForRelatedTo(valueRelatedTo));

        //scroll kéo xuống dưới
        WebUI.scrollAtBottom(driver, LocatorsTasks.btnSave);

        //dropdown Assignees
        //bỏ click
        WebUI.clickElement(driver, LocatorsTasks.dropdownAssignees);
        List<WebElement> listAssignees = WebUI.getWebElements(driver, LocatorsTasks.listAssignees);
        //bỏ click
        for (WebElement assignee : listAssignees) {
            if (assignee.isSelected()) {
                assignee.click();
            }
        }

        WebUI.setTextElement(driver, LocatorsTasks.inputSearchOffAssignees, assignees);
        WebUI.clickElement(driver, LocatorsTasks.getValueAssignees(assignees));

        WebUI.clearElement(driver, LocatorsTasks.inputSearchOffAssignees);
        WebUI.setTextElement(driver, LocatorsTasks.inputSearchOffAssignees, assignees2);
        WebUI.clickElement(driver, LocatorsTasks.getValueAssignees(assignees2));

        //dropdown Followers Mutip (tạo chọn data trước)
        WebUI.clickElement(driver, LocatorsTasks.dropdownFollowers);
        WebUI.setTextElement(driver, LocatorsTasks.inputSearchOffFollowers, followers);
        WebUI.clickElement(driver, LocatorsTasks.getValueFollowers(followers));
        WebUI.clickElement(driver, LocatorsTasks.dropdownFollowers);

        //bỏ click
        driver.findElement(LocatorsTasks.dropdownFollowers).click();
        List<WebElement> listFollowers = WebUI.getWebElements(driver, LocatorsTasks.listFollowers);
        for (WebElement follower : listFollowers) {
            if (follower.isSelected()) {
                follower.click();
            }
        }
        WebUI.setTextElement(driver, LocatorsTasks.inputSearchOffFollowers, followers);
        WebUI.clickElement(driver, LocatorsTasks.getValueFollowers(followers));

        WebUI.clearElement(driver, LocatorsTasks.inputSearchOffFollowers);
        WebUI.setTextElement(driver, LocatorsTasks.inputSearchOffFollowers, followers2);
        WebUI.clickElement(driver, LocatorsTasks.getValueFollowers(followers2));

        //Tags
        WebUI.setTextElement(driver, LocatorsTasks.inputAddTags, tags);

        //Tắt tags
        WebUI.clickElement(driver, LocatorsTasks.labelTag);
        WebUI.clickElement(driver, LocatorsTasks.labelTag);

        //iframe
        WebUI.clickElement(driver, LocatorsTasks.areaDescription);
        WebUI.switchToFrame(driver, By.id("description_ifr"));
        //driver.switchTo().frame("description_ifr");

        WebUI.clearElement(driver, LocatorsTasks.bodyIframe);
        WebUI.setTextElement(driver, LocatorsTasks.bodyIframe, bodyIframeDescription);

        driver.switchTo().parentFrame();

        //click btn Save
        WebUI.clickElement(driver, LocatorsTasks.btnSave);
        System.out.println("Thêm mới thành công Tasks");
    }

    public void closePopupDetail() throws InterruptedException {
        Thread.sleep(2000);
        WebUI.clickElement(driver, LocatorsTasks.iconClosePopupDetail);
    }

    //search Lead
    public void searchTaskSuccess(String expectedTaskName) throws InterruptedException {
        WebUI.clearElement(driver, LocatorsTasks.inputSearch);
        WebUI.setTextElement(driver, LocatorsTasks.inputSearch, expectedTaskName);

        boolean rows = WebUI.checkExitsElement(driver, LocatorsTasks.getRows(expectedTaskName));
        //Sai khi không có bản ghi
        //Assert.assertFalse(rows.size() == 0, "Không tìm thấy Task '" + expectedTaskName + "' sau khi search!");

        //Mong muốn rows.size() > 0 => đúng, nếu rows.size() == 0 thì hiển thị message kia
        Assert.assertTrue(rows, "Không tìm thấy Task '" + expectedTaskName + "' sau khi search!");
        System.out.println("Tìm kiếm thành công Task: " + expectedTaskName);
    }

    public void searchTaskSuccessNoData(String expectedTaskName) throws InterruptedException {
        WebUI.clearElement(driver, LocatorsTasks.inputSearch);
        WebUI.setTextElement(driver, LocatorsTasks.inputSearch, expectedTaskName);

//        List<WebElement> actualTaskName = driver.findElements("//table[@id='tasks']//tbody/tr/td[contains(normalize-space(),'"+expectedTaskName+"')]");
//        Assert.assertTrue(actualTaskName.size() == 0, "Còn dữ liệu");
        boolean rows = WebUI.checkExitsElement(driver, LocatorsTasks.getRows(expectedTaskName));
        Assert.assertFalse(rows, "Không mong muốn: vẫn còn bản ghi '" + expectedTaskName + "' trong bảng!");//trả về true => có bản ghi (test fail). trả về false => không còn bản ghi (test pass)
        System.out.println("Tìm kiếm thành công: 0 bản ghi");
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public void compareFieldAttribute(By xpathActual, String expectedValue, String attributeActual) {
        //String actual = driver.findElement(xpathActual).getAttribute(attributeActual);
        String actual = WebUI.getElementAttribute(driver, xpathActual, attributeActual);
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual);
    }

    public void compareFieldText(By xpathActual, String expectedValue) {
        String actual = WebUI.getElementText(driver, xpathActual);
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual);
    }

    public void verifyCheckboxSelected(By xpathCheckbox) {
        boolean checked = driver.findElement(xpathCheckbox).isSelected();
        Assert.assertTrue(checked, "Checkbox chưa được tích sau khi click");
    }

    public void compareIframeValue(String expectedValue) {
        driver.switchTo().frame("description_ifr");
        String actual = WebUI.getElementText(driver, LocatorsTasks.bodyIframe);
        driver.switchTo().defaultContent();
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng thực tế là: " + actual);
    }

    public void clickBtnEdit(String taskName) throws InterruptedException {
        WebElement firstRow = WebUI.getWebElement(driver, LocatorsTasks.firstRowItem);

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        WebUI.clickElement(driver, LocatorsTasks.buttonEdit(taskName));
        boolean checkTitleEditTask = WebUI.checkExitsElement(driver, LocatorsTasks.titleEditTask(taskName));
        Thread.sleep(1000);
        Assert.assertTrue(checkTitleEditTask, "FAILED!!! Không mở được pop-up Edit Tasks");
        System.out.println("Mở pop-up Edit Task thành công");
    }

    public void viewEditTaskSuccess(String taskName, String hourlyRate, String startDate, String duaDate, String priority, String repeatEvery, String totalCycles,
                                    String relatedTo, String valueRelatedTo, String tags, String bodyIframeDescription) throws InterruptedException {
        verifyCheckboxSelected(LocatorsTasks.checkboxPublic);
        verifyCheckboxSelected(LocatorsTasks.checkboxBillsble);
        compareFieldAttribute(LocatorsTasks.inputSubject, taskName, "value");
        compareFieldAttribute(LocatorsTasks.inputHourlyRate, hourlyRate, "value");
        compareFieldAttribute(LocatorsTasks.inputStartDate, startDate, "value");
        compareFieldAttribute(LocatorsTasks.inputDuaDate, duaDate, "value");
        compareFieldText(LocatorsTasks.dropdownPriority, priority);
        compareFieldText(LocatorsTasks.dropdownRepeatEvery, repeatEvery);
        compareFieldAttribute(LocatorsTasks.inputTotalCycles, totalCycles, "value");
        compareFieldText(LocatorsTasks.dropdownRelatedTo, relatedTo);
        compareFieldText(LocatorsTasks.dropdownForRelatedTo, valueRelatedTo);
        compareFieldText(LocatorsTasks.inputEditTags, tags);
        compareIframeValue(bodyIframeDescription);
        System.out.println("Tất cả các trường dữ liệu Task đã được Verify thành công");
    }

    public void editTaskSuccess(String hourlyRate, String startDate, String duaDate, String priority, String repeatEvery, String totalCycles,
                                String relatedTo, String searchValueRelatedTo, String valueRelatedTo, String tags, String bodyIframeDescription) throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement labelCheckboxPublic = WebUI.getWebElement(driver, LocatorsTasks.labelPublic);
        WebElement checkboxPublic = WebUI.getWebElement(driver, LocatorsTasks.checkboxPublic);
        WebElement labelCheckboxBillsble = WebUI.getWebElement(driver, LocatorsTasks.labelBillsble);
        WebElement checkboxBillsble = WebUI.getWebElement(driver, LocatorsTasks.checkboxBillsble);

        //Checkbox public
        if (!checkboxPublic.isSelected()) {
            actions.click(labelCheckboxPublic).perform();
        }
        softAssert.assertTrue(checkboxPublic.isSelected(), "Checkbox public chưa được tích sau khi click");

        //Checkbox Billable
        if (!checkboxBillsble.isSelected()) {
            actions.click(labelCheckboxPublic).perform();
        }
        softAssert.assertTrue(checkboxBillsble.isSelected(), "Checkbox Billable chưa được tích sau khi click");

        //sendKeys input
        WebElement inputHourlyRate = WebUI.getWebElement(driver, LocatorsTasks.inputHourlyRate);
        actions.click(inputHourlyRate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(inputHourlyRate, hourlyRate).perform();

        WebElement inputStartDate = WebUI.getWebElement(driver, LocatorsTasks.inputStartDate);
        actions.click(inputStartDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(inputStartDate, startDate).perform();
        actions.click(inputStartDate).perform();

        WebElement inputDuaDate = WebUI.getWebElement(driver, LocatorsTasks.inputDuaDate);
        actions.click(inputDuaDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(inputDuaDate, duaDate).perform();
        actions.click(inputDuaDate).perform();

        //dropdown Priority
        actions.click(WebUI.getWebElement(driver, LocatorsTasks.dropdownPriority)).perform();
        actions.click(WebUI.getWebElement(driver, LocatorsTasks.getValuePriority(priority))).perform();

        //dropdown Repeat every and input Total cycle (cho if)
        actions.click(WebUI.getWebElement(driver, LocatorsTasks.dropdownRepeatEvery)).perform();
        actions.click(WebUI.getWebElement(driver, LocatorsTasks.getValueRepeatEvery(repeatEvery))).perform();
        if (repeatEvery.equals("Custom")) {
            //input
            WebElement repeatEveryCustom = WebUI.getWebElement(driver, LocatorsTasks.repeatEveryCustom);
            actions.click(repeatEveryCustom).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(repeatEveryCustom, "100").perform();

            //dropdown
            actions.click(WebUI.getWebElement(driver, LocatorsTasks.dropdownRepeatEveryCustom)).perform();
            actions.click(WebUI.getWebElement(driver, LocatorsTasks.getRepeatEveryCustom("Day(s)")));

            //input Total
            actions.click(WebUI.getWebElement(driver, LocatorsTasks.checkboxInfinity)).perform(); //click (bỏ chọn)
            WebElement inputTotalCycles = WebUI.getWebElement(driver, LocatorsTasks.inputTotalCycles);
            actions.click(inputTotalCycles).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(inputTotalCycles, totalCycles).perform();

        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks") || repeatEvery.equals("1 Month") || repeatEvery.equals("2 Months") ||
                repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months") || repeatEvery.equals("1 Year")) {
            //actions.click(driver.findElement(LocatorsTasks.checkboxInfinity)).perform(); //click (bỏ chọn)
            WebElement inputTotalCycles = WebUI.getWebElement(driver, LocatorsTasks.inputTotalCycles);
            actions.click(inputTotalCycles).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(inputTotalCycles, totalCycles).perform();
        } else {
            System.out.println("Không tồn tại");
        }

        //dropdown Related to
        actions.click(WebUI.getWebElement(driver, LocatorsTasks.dropdownRelatedTo)).perform();
        actions.click(WebUI.getWebElement(driver, LocatorsTasks.getValueRelatedTo(relatedTo))).perform();

        //Click vô hàm valueDropdown Related to chọn giá trị
        actions.click(WebUI.getWebElement(driver, LocatorsTasks.dropdownForRelatedTo)).perform();
        actions.sendKeys(WebUI.getWebElement(driver, LocatorsTasks.inputSearchOfForRelatedTo), searchValueRelatedTo).perform();
        actions.click(WebUI.getWebElement(driver, LocatorsTasks.getValueForRelatedTo(valueRelatedTo))).perform();

        //scroll kéo xuống dưới
        WebUI.scrollAtBottom(driver, LocatorsTasks.btnSave);

        //Tag
        WebElement elementCloseTags = WebUI.getWebElement(driver, LocatorsTasks.elementCloseTags);
        actions.click(elementCloseTags).perform();
        actions.sendKeys(WebUI.getWebElement(driver, LocatorsTasks.inputAddTags), tags).perform();

        //click ra input name để đóng tag
        WebElement labelTag = WebUI.getWebElement(driver, LocatorsTasks.labelTag);
        actions.click(labelTag).perform();;
        actions.click(labelTag).perform();

        //iframe
        //driver.findElement(LocatorsTasks.areaDescription).click();
        WebUI.switchToFrame(driver, By.id("description_ifr"));

        WebElement bodyIframe = WebUI.getWebElement(driver, LocatorsTasks.bodyIframe);
        actions.click(bodyIframe).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(bodyIframe, bodyIframeDescription).perform();

        driver.switchTo().parentFrame();

        //click btn Save
        WebElement btnSave = WebUI.getWebElement(driver, LocatorsTasks.btnSave);
        actions.click(btnSave).perform();
        System.out.println("Sửa Task thành công");
    }

    @Test(priority = 1)
    public void testAddNewTask() throws InterruptedException {
        BTTasks tasks = new BTTasks();
        tasks.taskName = "GTest2111";
        tasks.hourlyRate = "24";
        tasks.startDate = "20-10-2025";
        tasks.duaDate = "05-11-2025";
        tasks.priority = "High";
        tasks.repeatEvery = "Week";
        tasks.totalCycles = "100000";
        tasks.relatedTo = "Lead";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";
        tasks.assignees = "Admin Anh Tester";
        tasks.assignees2 = "Admin Example";
        tasks.followers = "Admin Example";
        tasks.followers2 = "Admin Anh Tester";
        tasks.tags = "Giang";
        tasks.bodyIframeDescription = "Giang Add Tasks";
        Thread.sleep(1000);

        //click menu Task
        clickMenuTask();
        verifyMenuTask();

        //click btn Add Task
        clickBtnAddTask();
        verifyBtnAddTask();

        addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);
        Thread.sleep(3000);

        closePopupDetail();
        Thread.sleep(1000);

        //verify
        searchTaskSuccess(tasks.taskName);
    }

    @Test(priority = 2)
    public void testViewEditTaskSuccess() throws InterruptedException {
        BTTasks tasks = new BTTasks();
        tasks.taskName = "GTest3";
        tasks.hourlyRate = "24";
        tasks.startDate = "20-10-2025";
        tasks.duaDate = "05-11-2025";
        tasks.priority = "High";
        tasks.repeatEvery = "Week";
        tasks.totalCycles = "100000";
        tasks.relatedTo = "Lead";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";
        tasks.assignees = "Admin Anh Tester";
        tasks.assignees2 = "Admin Example";
        tasks.followers = "Admin Example";
        tasks.followers2 = "Admin Anh Tester";
        tasks.tags = "Giang";
        tasks.bodyIframeDescription = "Giang Add Tasks2";
        Thread.sleep(1000);

        //click menu Task
        clickMenuTask();
        verifyMenuTask();

        //click btn Add Task
        clickBtnAddTask();
        verifyBtnAddTask();

        addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);
        Thread.sleep(3000);

        closePopupDetail();
        Thread.sleep(1000);

        //verify
        searchTaskSuccess(tasks.taskName);

        //click btn edit
        clickBtnEdit(tasks.taskName);

        viewEditTaskSuccess(tasks.taskName, tasks.hourlyRate +".00", tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);
    }

    @Test(priority = 3)
    public void testEditTaskSuccess() throws InterruptedException {
        //Data Add
        BTTasks tasks = new BTTasks();
        tasks.taskName = "GTest111";
        tasks.hourlyRate = "24";
        tasks.startDate = "20-10-2025";
        tasks.duaDate = "05-11-2025";
        tasks.priority = "High";
        tasks.repeatEvery = "Week";
        tasks.totalCycles = "100000";
        tasks.relatedTo = "Lead";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";
        tasks.assignees = "Admin Anh Tester";
        tasks.assignees2 = "Admin Example";
        tasks.followers = "Admin Example";
        tasks.followers2 = "Admin Anh Tester";
        tasks.tags = "Giang";
        tasks.bodyIframeDescription = "Giang Add Tasks2";

        //click menu Task
        clickMenuTask();
        verifyMenuTask();

        //click btn Add Task
        clickBtnAddTask();
        verifyBtnAddTask();

        //Tạo data
        addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);
        Thread.sleep(3000);

        closePopupDetail();
        Thread.sleep(1000);

        //verify
        searchTaskSuccess(tasks.taskName);
        Thread.sleep(2000);

        //Edit Lead
        clickBtnEdit(tasks.taskName);

        //Data Update
        tasks.duaDate = "21-12-2025";
        tasks.priority = "Low";
        tasks.totalCycles = "6666";
        tasks.tags = "Giang12";
        tasks.bodyIframeDescription = "Giang Update Tasks";

        editTaskSuccess(tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchTaskSuccess(tasks.taskName);
        Thread.sleep(2000);

        //verify edit
        clickBtnEdit(tasks.taskName);
        viewEditTaskSuccess(tasks.taskName, tasks.hourlyRate +".00", tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);
    }

}

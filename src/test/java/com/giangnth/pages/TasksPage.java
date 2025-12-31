package com.giangnth.pages;

import com.giangnth.common.BasePage;
import com.giangnth.drivers.DriverManager;
import com.giangnth.helpers.SystemHelper;
import com.giangnth.keywords.WebUI;
import com.giangnth.models.TaskDTO;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TasksPage extends BasePage{

    private SoftAssert softAssert;

    public TasksPage(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }
    //locators menu tasks
    private By btnAddTasks = By.xpath("//a[normalize-space() = 'New Task']");
    private By headerTasksSummary = By.xpath("//h4//span[normalize-space()='Tasks Summary']");
    private By inputSearch = By.xpath("//div[@id='tasks_filter']//input[@type='search']");
    private By iconClosePopupDetail = By.xpath("//div[@id='task-modal']//button[@class= 'close']");
    private By firstRowItem = By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]/a");


    private By buttonEdit(String leadName) {
        By xpath = By.xpath("//table[@id='tasks']//td[3]/a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='Edit']");
        return xpath;
    }

    private By buttonDelete(String leadName) {
        By xpath = By.xpath("//table[@id='tasks']//td[3]/a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='Delete']");
        return xpath;
    }

    //locators Add New Tasks
    private By titleAddNewTask = By.xpath("//h4[normalize-space()='Add new task']");
    private By iconCloseAddNewTask = By.xpath("//h4[@id='myModalLabel']/preceding-sibling::button");

    private By labelPublic = By.xpath("//input[@id='task_is_public']/parent::div[contains(@class, 'task-add-edit-public')]");
    private By checkboxPublic = By.xpath("//input[@id='task_is_public']");
    private By checkboxBillsble = By.xpath("//input[@id='task_is_billable']");
    private By labelBillsble = By.xpath("//input[@id='task_is_billable']/parent::div[contains(@class, 'task-add-edit-billable')]");
    private By linkAttachFile = By.xpath("//a[normalize-space()='Attach Files']");

    private By inputFileAttachment = By.xpath("//div[@id='new-task-attachments']//input[@type='file']");
    private By btnAddMoreAttachment = By.xpath("//button[contains(@class,'add_more_attachments')]");//hàm
    private By btnRemoveAttachmemt = By.xpath("//button[contains(@class,'remove_attachment')]");//hàm

    private By inputSubject = By.xpath("//input[@id='name']");

    private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");

    private By inputStartDate = By.xpath("//input[@id='startdate']");
    private By iconStartDate = By.xpath("//input[@id='startdate']/following-sibling::div/i");

    private By inputDuaDate = By.xpath("//input[@id='duedate']");
    private By iconDuaDate = By.xpath("//input[@id='duedate']/following-sibling::div/i");

    private By dropdownPriority = By.xpath("//button[@data-id='priority']");

    private By getValuePriority(String value) {
        return By.xpath("//button[@data-id='priority']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }

    private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");

    private By getValueRepeatEvery(String value) {
        return By.xpath("//button[@data-id='repeat_every']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }

    private By repeatEveryCustom = By.xpath("//div[@class='recurring_custom']//input[@id='repeat_every_custom']");
    private By dropdownRepeatEveryCustom = By.xpath("//div[@class='recurring_custom']//button[@data-id='repeat_type_custom']");

    private By getRepeatEveryCustom(String value) {
        return By.xpath("//button[@data-id='repeat_type_custom']/following-sibling::div//span[contains(normalize-space(),'" + value + "')]");
    }

    private By dropdownTypeRelatedTo = By.xpath("//button[@data-id='rel_id']");
    private By inputSearchTypeRelatedTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::input[@type='search']");

    private By getValueTypeRelatedTo(String value) {
        return By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::span[contains(normalize-space(),'" + value + "')]");
    }

    //TotalCycles of RepeatEvery
    private By inputTotalCycles = By.xpath("//input[@id='cycles']");
    private By checkboxInfinity = By.xpath("//input[@id='unlimited_cycles']");
    private By labelCheckboxInfinity = By.xpath("//label[@for='unlimited_cycles' and normalize-space()='Infinity']");

    private By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");

    private By getValueRelatedTo(String value) {
        return By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }

    private By dropdownForRelatedTo = By.xpath("//button[@data-id='rel_id']");
    private By inputSearchOfForRelatedTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//input[@type='search']");

    private By getValueForRelatedTo(String value) {
        return By.xpath("//button[@data-id='rel_id']/following-sibling::div//span[@class = 'text' and normalize-space()='" + value + "']");
    }

    private By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    private By inputSearchOffAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");

    private By getValueAssignees(String value) {
        return By.xpath("//button[@data-id='assignees']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }
    private By listAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//li");

    private By listFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//li");
    private By dropdownFollowers = By.xpath("//button[@data-id='followers[]']");
    private By inputSearchOffFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//input[@type='search']");

    private By getValueFollowers(String value) {
        return By.xpath("//button[@data-id='followers[]']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }

    private By iconCloseTags = By.xpath("//div[@id='inputTagsWrapper']/ul//a[@class='tagit-close']/span[1]");
    private By inputAddTags = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    private By inputEditTags = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");

    // public String dropdownTags = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']");
    private By getValueTags(String value) {
        return By.xpath("//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']");
    }

    private By labelTag = By.xpath("//div[@id='inputTagsWrapper']/label[@for='tags']");

    private By areaDescription = By.xpath("//textarea[@id='description']");
    private By iframeDescription = By.xpath("//iframe[@id='description_ifr']");
    private By bodyIframe = By.xpath("//body[@id='tinymce']");

    private By btnClose = By.xpath("//form[@id='task-form']//button[normalize-space()='Close']");
    //private By btnClose = By.xpath("//h4[@id='myModalLabel']/parent::div/following-sibling::div[@class='modal-footer']/button[normalize-space()='Close']");
    private By btnSave = By.xpath("//button[normalize-space()='Save']");
    private By idFrame = By.id("description_ifr");

    private String deleteTaskSuccessMessage = "Task deleted";

    private By getDeleteTaskSuccessMessage() {
        String xpathDeleteTaskMessage = "//div[@id='alert_float_1']/descendant::span[@class='alert-title' and normalize-space()='" + deleteTaskSuccessMessage + "']";
        return By.xpath(xpathDeleteTaskMessage);
    }

    private By getRows(String value){
        return By.xpath("//table[@id='tasks']//tbody/tr/td/a[normalize-space()='"+value+"']");
    }

    private By titleEditTask(String taskName){
        return By.xpath( "//h4[@id='myModalLabel' and normalize-space() = 'Edit task "+taskName+"']");
    }

    private By headerEdit = By.xpath("//div[@id='task-modal']//div[contains(@class,'modal-header')]//h4");

    public void verifyMenuTask() {
        WebUI.threadSleep(1);
        //Truyền text vào xpath nên không cần check Text
        boolean checkHeaderTaskSummary = WebUI.checkExitsElement(headerTasksSummary);
        Assert.assertTrue(checkHeaderTaskSummary, "FAILED!!! Không truy cập được vào trang Tasks");
    }

    public void clickBtnAddTask() {
        //click button New Lead
        WebUI.clickElement(btnAddTasks);
        System.out.println("Click button Add Task");
    }

    public void verifyBtnAddTask() {
        WebUI.threadSleep(2);
        //Truyền text vào xpath nên không cần check Text
        boolean checkTitleAddNewTask = WebUI.checkExitsElement(titleAddNewTask);
        Assert.assertTrue(checkTitleAddNewTask, "FAILED!!! Không mở được pop-up Add new Tasks");
    }

    public void addNewTask(TaskDTO task) {

        //Checkbox public
        WebElement chcPublic = WebUI.getWebElement(checkboxPublic);
        if (!chcPublic.isSelected()) {
            chcPublic.click();
        }
        softAssert.assertTrue(chcPublic.isSelected(), "Checkbox public chưa được tích sau khi click");

        //Checkbox Billable
        WebElement chcBillsble = WebUI.getWebElement(checkboxBillsble);
        if (!chcBillsble.isSelected()) {
            chcBillsble.click();
        }
        softAssert.assertTrue(chcBillsble.isSelected(), "Checkbox Billable chưa được tích sau khi click");

        //check attachment
        WebUI.clickElement(linkAttachFile);

        //sendKeys input
        WebUI.setTextElement(inputSubject, task.getTaskName());
        WebUI.clearElement(inputHourlyRate);
        WebUI.setTextElement(inputHourlyRate, task.getHourlyRate());
        WebUI.clearElement(inputStartDate);
        WebUI.setTextElement(inputStartDate, task.getStartDate());
        WebUI.clickElement(inputStartDate);
        WebUI.clearElement(inputDuaDate);
        WebUI.setTextElement(inputDuaDate, task.getDuaDate());
        WebUI.clickElement(inputDuaDate);

        //dropdown Priority
        WebUI.clickElement(dropdownPriority);
        WebUI.clickElement(getValuePriority(task.getPriority()));

        //dropdown Repeat every and input Total cycle (cho if)
        WebUI.clickElement(dropdownRepeatEvery);
        WebUI.clickElement(getValueRepeatEvery(task.getRepeatEvery()));
        if (task.getRepeatEvery().equals("Custom")) {
            //input
            WebUI.clearElement(repeatEveryCustom);
            WebUI.setTextElement(repeatEveryCustom, "100");

            //dropdown
            WebUI.clickElement(dropdownRepeatEveryCustom);
            WebUI.clickElement(getRepeatEveryCustom("Week(s)"));

            //input Total
            WebUI.clickElement(labelCheckboxInfinity); // - click bỏ chọn
            WebUI.clearElement(inputTotalCycles);
            WebUI.setTextElement(inputTotalCycles, "100000");
        } else if (task.getRepeatEvery().equals("Week") || task.getRepeatEvery().equals("2 Weeks") || task.getRepeatEvery().equals("1 Month") || task.getRepeatEvery().equals("2 Months") ||
                task.getRepeatEvery().equals("3 Months") || task.getRepeatEvery().equals("6 Months") || task.getRepeatEvery().equals("1 Year")) {

            WebUI.clickElement(labelCheckboxInfinity); // - click bỏ chọn
            WebUI.clearElement(inputTotalCycles);
            WebUI.setTextElement(inputTotalCycles, "100000");
        } else {
            System.out.println("Không tồn tại");
        }

        //dropdown Related to
        WebUI.clickElement(dropdownRelatedTo);
        WebUI.clickElement(getValueRelatedTo(task.getRelatedTo()));

        //Click vô hàm valueDropdown Related to chọn giá trị
        WebUI.clickElement(dropdownForRelatedTo);
        WebUI.setTextElement(inputSearchOfForRelatedTo, task.getSearchValueRelatedTo());
        WebUI.threadSleep(1);
        WebUI.setTextElement(inputSearchOfForRelatedTo," ");
        //WebUI.setTextElement(LocatorsTasks.inputSearchOfForRelatedTo, searchValueRelatedTo);
        WebUI.clickElement(getValueForRelatedTo(task.getValueRelatedTo()));

        //scroll kéo xuống dưới
        WebUI.scrollAtBottom(btnSave);

        //dropdown Assignees
        //bỏ click
        WebUI.clickElement(dropdownAssignees);
        List<WebElement> listDataAssignees = WebUI.getWebElements(listAssignees);
        //bỏ click
        for (WebElement assignee : listDataAssignees) {
            if (assignee.isSelected()) {
                assignee.click();
            }
        }

        WebUI.setTextElement(inputSearchOffAssignees, task.getAssignees());
        WebUI.clickElement(getValueAssignees(task.getAssignees()));

        WebUI.clearElement(inputSearchOffAssignees);
        WebUI.setTextElement(inputSearchOffAssignees, task.getAssignees2());
        WebUI.clickElement(getValueAssignees(task.getAssignees2()));

        //dropdown Followers Mutip (tạo chọn data trước)
        WebUI.clickElement(dropdownFollowers);
        WebUI.setTextElement(inputSearchOffFollowers, task.getFollowers());
        WebUI.clickElement(getValueFollowers(task.getFollowers()));
        WebUI.clickElement(dropdownFollowers);

        //bỏ click
        WebUI.clickElement(dropdownFollowers);
        List<WebElement> listDataFollowers = WebUI.getWebElements(listFollowers);
        for (WebElement follower : listDataFollowers) {
            if (follower.isSelected()) {
                follower.click();
            }
        }
        WebUI.setTextElement(inputSearchOffFollowers, task.getFollowers());
        WebUI.clickElement(getValueFollowers(task.getFollowers()));

        WebUI.clearElement(inputSearchOffFollowers);
        WebUI.setTextElement(inputSearchOffFollowers, task.getFollowers2());
        WebUI.clickElement(getValueFollowers(task.getFollowers2()));

        //Tags
        WebUI.setTextElement(inputAddTags, task.getTags());

        //Tắt tags
        WebUI.clickElement(labelTag);
        WebUI.clickElement(labelTag);

        //iframe
        WebUI.clickElement(areaDescription);
        WebUI.switchToFrame(By.id("description_ifr"));
        //driver.switchTo().frame("description_ifr");

        WebUI.clearElement(bodyIframe);
        WebUI.setTextElement(bodyIframe, task.getBodyIframeDescription());

        WebUI.switchToParentFrame();

        //click btn Save
        WebUI.clickElement(btnSave);
        WebUI.threadSleep(2);
    }

    public void closePopupDetail() {
        WebUI.threadSleep(2);
        WebUI.clickElement(iconClosePopupDetail);
        WebUI.threadSleep(1);
    }

    //search Lead
    public void searchTaskSuccess(String taskName) {
        WebUI.clearElement(inputSearch);
        WebUI.setTextElement(inputSearch, taskName);
        WebUI.threadSleep(1);
    }

    public void verifySearchTaskSuccess(String taskName) {
        Assert.assertTrue(WebUI.checkExitsElement(getRows(taskName)), "Không tìm thấy Task '" + taskName + "' sau khi search!");
        System.out.println("Tìm kiếm thành công Task: " + taskName);
        WebUI.threadSleep(2);
    }

    public void searchTaskSuccessNoData(String taskName) {
        WebUI.clearElement(inputSearch);
        WebUI.setTextElement(inputSearch, taskName);
        WebUI.threadSleep(1);
    }

    public void verifySearchTaskSuccessNoData(String taskName) {
        Assert.assertFalse(WebUI.checkExitsElement(getRows(taskName)), "Không mong muốn: vẫn còn bản ghi '" + taskName + "' trong bảng!");//trả về true => có bản ghi (test fail). trả về false => không còn bản ghi (test pass)
        System.out.println("Tìm kiếm thành công: 0 bản ghi");
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public void compareFieldAttribute(By xpathActual, String expectedValue, String attributeActual) {
        //String actual = driver.findElement(xpathActual).getAttribute(attributeActual);
        String actual = WebUI.getElementAttribute(xpathActual, attributeActual);
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual);
    }

    public void compareFieldText(By xpathActual, String expectedValue) {
        String actual = WebUI.getElementText(xpathActual);
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual);
    }

    public void verifyCheckboxSelected(By xpathCheckbox) {
        boolean checked = WebUI.checkSeletedElement(xpathCheckbox);
        Assert.assertTrue(checked, "Checkbox chưa được tích sau khi click");
    }

    public void compareIframeValue(String expectedValue) {
        WebUI.switchToFrame(idFrame);
        String actual = WebUI.getElementText(bodyIframe);
        WebUI.switchToDefaultContentFrame();
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng thực tế là: " + actual);
    }

    public void clickBtnEdit(String taskName) {
        //Hover chuột vào dòng đầu tiên
        WebUI.moveToElement(firstRowItem);
        WebUI.clickElement(buttonEdit(taskName));
        WebUI.threadSleep(1);
    }

    public void verifyClickBtnEdit(String taskName){
        boolean checkTitleEditTask = WebUI.checkExitsElement(titleEditTask(taskName));
        WebUI.threadSleep(1);
        Assert.assertTrue(checkTitleEditTask, "FAILED!!! Không mở được pop-up Edit Tasks");
        System.out.println("Mở pop-up Edit Task thành công");
    }

    public void viewEditTaskSuccess(TaskDTO task) {
        verifyCheckboxSelected(checkboxPublic);
        verifyCheckboxSelected(checkboxBillsble);
        compareFieldAttribute(inputSubject, task.getTaskName(), "value");
        compareFieldAttribute(inputHourlyRate, task.getHourlyRate(), "value");
        compareFieldAttribute(inputStartDate, task.getStartDate(), "value");
        compareFieldAttribute(inputDuaDate, task.getDuaDate(), "value");
        compareFieldText(dropdownPriority, task.getPriority());
        compareFieldText(dropdownRepeatEvery, task.getRepeatEvery());
        compareFieldAttribute(inputTotalCycles, task.getTotalCycles(), "value");
        compareFieldText(dropdownRelatedTo, task.getRelatedTo());
        compareFieldText(dropdownForRelatedTo, task.getValueRelatedTo());
        compareFieldText(inputEditTags, task.getTags());
        compareIframeValue(task.getBodyIframeDescription());
        System.out.println("Tất cả các trường dữ liệu Task đã được Verify thành công");
    }

    public void editTaskSuccess(TaskDTO task) {
        Actions actions = new Actions(DriverManager.getDriver());

        WebElement labelCheckboxPublic = WebUI.getWebElement(labelPublic);
        WebElement chcPublic = WebUI.getWebElement(checkboxPublic);
        WebElement labelCheckboxBillsble = WebUI.getWebElement(labelBillsble);
        WebElement chcBillsble = WebUI.getWebElement(checkboxBillsble);

        //Checkbox public
        if (!chcPublic.isSelected()) {
            actions.click(labelCheckboxPublic).perform();
        }
        softAssert.assertTrue(chcPublic.isSelected(), "Checkbox public chưa được tích sau khi click");

        //Checkbox Billable
        if (!chcBillsble.isSelected()) {
            actions.click(labelCheckboxPublic).perform();
        }
        softAssert.assertTrue(chcBillsble.isSelected(), "Checkbox Billable chưa được tích sau khi click");

        //sendKeys input
        WebElement inputtHourlyRate = WebUI.getWebElement(inputHourlyRate);
        actions.click(inputtHourlyRate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(inputtHourlyRate, task.getHourlyRate()).perform();

        WebElement inputtStartDate = WebUI.getWebElement(inputStartDate);
        actions.click(inputtStartDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(inputtStartDate, task.getStartDate()).perform();
        actions.click(inputtStartDate).perform();

        WebElement inputtDuaDate = WebUI.getWebElement(inputDuaDate);
        actions.click(inputtDuaDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(inputtDuaDate, task.getDuaDate()).perform();
        actions.click(inputtDuaDate).perform();

        //dropdown Priority
        actions.click(WebUI.getWebElement(dropdownPriority)).perform();
        actions.click(WebUI.getWebElement(getValuePriority(task.getPriority()))).perform();

        //dropdown Repeat every and input Total cycle (cho if)
        actions.click(WebUI.getWebElement(dropdownRepeatEvery)).perform();
        actions.click(WebUI.getWebElement(getValueRepeatEvery(task.getRepeatEvery()))).perform();
        if (task.getRepeatEvery().equals("Custom")) {
            //input
            WebElement valueRepeatEveryCustom = WebUI.getWebElement(repeatEveryCustom);
            actions.click(valueRepeatEveryCustom).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(valueRepeatEveryCustom, "100").perform();

            //dropdown
            actions.click(WebUI.getWebElement(dropdownRepeatEveryCustom)).perform();
            actions.click(WebUI.getWebElement(getRepeatEveryCustom("Day(s)")));

            //input Total
            actions.click(WebUI.getWebElement(checkboxInfinity)).perform(); //click (bỏ chọn)
            WebElement inputtTotalCycles = WebUI.getWebElement(inputTotalCycles);
            actions.click(inputtTotalCycles).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(inputtTotalCycles, task.getTotalCycles()).perform();

        } else if (task.getRepeatEvery().equals("Week") || task.getRepeatEvery().equals("2 Weeks") || task.getRepeatEvery().equals("1 Month") || task.getRepeatEvery().equals("2 Months") ||
                task.getRepeatEvery().equals("3 Months") || task.getRepeatEvery().equals("6 Months") || task.getRepeatEvery().equals("1 Year")) {
            //actions.click(driver.findElement(LocatorsTasks.checkboxInfinity)).perform(); //click (bỏ chọn)
            WebElement inputtTotalCycles = WebUI.getWebElement(inputTotalCycles);
            actions.click(inputtTotalCycles).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(inputtTotalCycles, task.getTotalCycles()).perform();
        } else {
            System.out.println("Không tồn tại");
        }

        //dropdown Related to
        actions.click(WebUI.getWebElement(dropdownRelatedTo)).perform();
        actions.click(WebUI.getWebElement(getValueRelatedTo(task.getRelatedTo()))).perform();

        //Click vô hàm valueDropdown Related to chọn giá trị
        actions.click(WebUI.getWebElement(dropdownForRelatedTo)).perform();
        actions.sendKeys(WebUI.getWebElement(inputSearchOfForRelatedTo), task.getSearchValueRelatedTo()).perform();
        actions.click(WebUI.getWebElement(getValueForRelatedTo(task.getValueRelatedTo()))).perform();

        //scroll kéo xuống dưới
        WebUI.scrollAtBottom(btnSave);

        //Tag
        WebElement elementCloseTags = WebUI.getWebElement(iconCloseTags);
        actions.click(elementCloseTags).perform();
        actions.sendKeys(WebUI.getWebElement(inputAddTags), task.getTags()).perform();

        //click ra input name để đóng tag
        WebElement labelTags = WebUI.getWebElement(labelTag);
        actions.click(labelTags).perform();;
        actions.click(labelTags).perform();

        //iframe
        //driver.findElement(LocatorsTasks.areaDescription).click();
        WebUI.switchToFrame(By.id("description_ifr"));

        WebElement bodyIframes = WebUI.getWebElement(bodyIframe);
        actions.click(bodyIframes).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(bodyIframes, task.getBodyIframeDescription()).perform();

        WebUI.switchToParentFrame();

        //click btn Save
        WebElement buttonSave = WebUI.getWebElement(btnSave);
        actions.click(buttonSave).perform();
        WebUI.threadSleep(1);
    }

    public void clickBtnDeleteTask(String taskName) {
        //Hover chuột vào dòng đầu tiên
        WebUI.moveToElement(firstRowItem);
        WebUI.clickElement(buttonDelete(taskName));
    }

    public void confirmDeleteTask(int flag) {
        System.out.println("Confirm Delete Task");
        WebUI.threadSleep(2);
        Alert alert = DriverManager.getDriver().switchTo().alert();
        //check text trên alert
        if (flag == 1) {
            //xóa
            WebUI.acceptAlert();
        } else {
            //hủy xóa
            WebUI.dismissAlert();
        }
    }

    public void verifyDeleteSuccessMessage(int flag){
        if (flag == 1) {
            Assert.assertTrue(WebUI.checkExitsElement(getDeleteTaskSuccessMessage()), "Không hiển thị message Xóa thành công sau khi Xóa");
        }else {
            Assert.assertFalse(WebUI.checkExitsElement(getDeleteTaskSuccessMessage()), "Hiển thị message Xóa thành công sau khi Hủy xóa");
        }
    }

    public void verifyAfterDeleteTask(String taskName, int flag) {
        WebUI.clearElement(inputSearch);
        WebUI.setTextElement(inputSearch, taskName);
        WebUI.threadSleep(1);
        if (flag == 1) {
            //xóa nhưng vẫn còn bản ghi
            Assert.assertFalse(WebUI.checkExitsElement(getRows(taskName)), "Xóa không thành công: vẫn còn bản ghi '" + taskName + "' trong bảng!");  // Test pass
            System.out.println("Tìm kiếm thành công: 0 bản ghi");
        }else {
            //Hủy xóa nhưng lại bị mất bản ghi
            Assert.assertTrue(WebUI.checkExitsElement(getRows(taskName)), "Hủy xóa Lead không thành công. Không tìm thấy Task '" + taskName + "' sau khi search!");
            System.out.println("Tìm kiếm thành công Lead: " + taskName);
        }
    }

}

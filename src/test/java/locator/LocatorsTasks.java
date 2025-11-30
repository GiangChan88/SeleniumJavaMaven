package locator;

import keywords.WebUI;
import org.openqa.selenium.By;

public class LocatorsTasks {

    //locators menu tasks
    public static By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    public static By btnAddTasks = By.xpath("//a[normalize-space() = 'New Task']");
    public static By headerTasksSummary = By.xpath("//h4//span[normalize-space()='Tasks Summary']");
    public static By inputSearch = By.xpath("//div[@id='tasks_filter']//input[@type='search']");
    public static By iconClosePopupDetail = By.xpath("//div[@id='task-modal']//button[@class= 'close']");
    public static By firstRowItem = By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]/a");

    public static By buttonEdit(String leadName) {
        By xpath = By.xpath("//table[@id='tasks']//td[3]/a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='Edit']");
        return xpath;
    }

    public static By buttonDelete(String leadName) {
        By xpath = By.xpath("//table[@id='tasks']//td[3]/a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='Delete']");
        return xpath;
    }

    //locators Add New Tasks
    public static By titleAddNewTask = By.xpath("//h4[normalize-space()='Add new task']");
    public static By iconCloseAddNewTask = By.xpath("//h4[@id='myModalLabel']/preceding-sibling::button");

    public static By labelPublic = By.xpath("//input[@id='task_is_public']/parent::div[contains(@class, 'task-add-edit-public')]");
    public static By checkboxPublic = By.xpath("//input[@id='task_is_public']");
    public static By checkboxBillsble = By.xpath("//input[@id='task_is_billable']");
    public static By labelBillsble = By.xpath("//input[@id='task_is_billable']/parent::div[contains(@class, 'task-add-edit-billable')]");
    public static By linkAttachFile = By.xpath("//a[normalize-space()='Attach Files']");

    public static By inputFileAttachment = By.xpath("//div[@id='new-task-attachments']//input[@type='file']");
    public static By btnAddMoreAttachment = By.xpath("//button[contains(@class,'add_more_attachments')]");//hàm
    public static By btnRemoveAttachmemt = By.xpath("//button[contains(@class,'remove_attachment')]");//hàm

    public static By inputSubject = By.xpath("//input[@id='name']");

    public static By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");

    public static By inputStartDate = By.xpath("//input[@id='startdate']");
    public static By iconStartDate = By.xpath("//input[@id='startdate']/following-sibling::div/i");

    public static By inputDuaDate = By.xpath("//input[@id='duedate']");
    public static By iconDuaDate = By.xpath("//input[@id='duedate']/following-sibling::div/i");

    public static By dropdownPriority = By.xpath("//button[@data-id='priority']");

    public static By getValuePriority(String value) {
        return By.xpath("//button[@data-id='priority']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }

    public static By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");

    public static By getValueRepeatEvery(String value) {
        return By.xpath("//button[@data-id='repeat_every']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }

    public static By repeatEveryCustom = By.xpath("//div[@class='recurring_custom']//input[@id='repeat_every_custom']");
    public static By dropdownRepeatEveryCustom = By.xpath("//div[@class='recurring_custom']//button[@data-id='repeat_type_custom']");

    public static By getRepeatEveryCustom(String value) {
        return By.xpath("//button[@data-id='repeat_type_custom']/following-sibling::div//span[contains(normalize-space(),'" + value + "')]");
    }

    public static By dropdownTypeRelatedTo = By.xpath("//button[@data-id='rel_id']");
    public static By inputSearchTypeRelatedTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::input[@type='search']");

    public static By getValueTypeRelatedTo(String value) {
        return By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::span[contains(normalize-space(),'" + value + "')]");
    }

    //TotalCycles of RepeatEvery
    public static By inputTotalCycles = By.xpath("//input[@id='cycles']");
    public static By checkboxInfinity = By.xpath("//input[@id='unlimited_cycles']");
    public static By labelCheckboxInfinity = By.xpath("//label[@for='unlimited_cycles' and normalize-space()='Infinity']");

    public static By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");

    public static By getValueRelatedTo(String value) {
        return By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }

    public static By dropdownForRelatedTo = By.xpath("//button[@data-id='rel_id']");
    public static By inputSearchOfForRelatedTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//input[@type='search']");

    public static By getValueForRelatedTo(String value) {
        return By.xpath("//button[@data-id='rel_id']/following-sibling::div//span[@class = 'text' and normalize-space()='" + value + "']");
    }

    public static By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    public static By inputSearchOffAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");

    public static By getValueAssignees(String value) {
        return By.xpath("//button[@data-id='assignees']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }
    public static By listAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//li");

    public static By listFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//li");
    public static By dropdownFollowers = By.xpath("//button[@data-id='followers[]']");
    public static By inputSearchOffFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//input[@type='search']");

    public static By getValueFollowers(String value) {
        return By.xpath("//button[@data-id='followers[]']/following-sibling::div//span[@class='text' and normalize-space()='" + value + "']");
    }

    public static By elementCloseTags = By.xpath("//div[@id='inputTagsWrapper']/ul//a[@class='tagit-close']/span[1]");
    public static By inputAddTags = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    public static By inputEditTags = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");

    // public String dropdownTags = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']");
    public static By getValueTags(String value) {
        return By.xpath("//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']");
    }

    public static By labelTag = By.xpath("//div[@id='inputTagsWrapper']/label[@for='tags']");

    public static By areaDescription = By.xpath("//textarea[@id='description']");
    public static By iframeDescription = By.xpath("//iframe[@id='description_ifr']");
    public static By bodyIframe = By.xpath("//body[@id='tinymce']");

    public static By btnClose = By.xpath("//form[@id='task-form']//button[normalize-space()='Close']");
    //public static By btnClose = By.xpath("//h4[@id='myModalLabel']/parent::div/following-sibling::div[@class='modal-footer']/button[normalize-space()='Close']");
    public static By btnSave = By.xpath("//button[normalize-space()='Save']");

    public static By getRows(String value){
        return By.xpath("//table[@id='tasks']//tbody/tr/td/a[normalize-space()='"+value+"']");
    }

    public static By titleEditTask(String taskName){
        return By.xpath( "//h4[@id='myModalLabel' and normalize-space() = 'Edit task "+taskName+"']");
    }

    public static By headerEdit = By.xpath("//div[@id='task-modal']//div[contains(@class,'modal-header')]//h4");

}

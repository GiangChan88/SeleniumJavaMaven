package bt_locator;

public class LocatorsTasks {

    //locators menu tasks
    public static String menuTasks = "//span[normalize-space()='Tasks']";
    public static String btnAddTasks = "//a[normalize-space() = 'New Task']";

    //locators Add New Tasks
    public static String titleAddNewTask = "//h4[@id='myModalLabel']";
    public static String iconCloseAddNewTask = "//h4[@id='myModalLabel']/preceding-sibling::button";

    public static String labelPublic = "//input[@id='task_is_public']/parent::div[contains(@class, 'task-add-edit-public')]";
    public static String checkboxPublic = "//input[@id='task_is_public']";
    public static String checkboxBillsble = "//input[@id='task_is_billable']";
    public static String labelBillsble = "//input[@id='task_is_billable']/parent::div[contains(@class, 'task-add-edit-billable')]";
    public static String linkAttachFile = "//a[normalize-space()='Attach Files']";

    public static String inputFileAttachment = "//div[@id='new-task-attachments']//input[@type='file']";
    public static String btnAddMoreAttachment = "//button[contains(@class,'add_more_attachments')]";//hàm
    public static String btnRemoveAttachmemt = "//button[contains(@class,'remove_attachment')]";//hàm

    public static String inputSubject = "//input[@id='name']";

    public static String inputHourlyRate = "//input[@id='hourly_rate']";

    public static String inputStartDate = "//input[@id='startdate']";
    public static String iconStartDate = "//input[@id='startdate']/following-sibling::div/i";

    public static String inputDuaDate = "//input[@id='duedate']";
    public static String iconDuaDate = "//input[@id='duedate']/following-sibling::div/i";

    public static String dropdownPriority = "//button[@data-id='priority']";
    public static String getValuePriority(String value){
        String xpathListPriority = "//button[@data-id='priority']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListPriority;
    }

    public static String dropdownRepeatEvery = "//button[@data-id='repeat_every']";
    public static String getValueRepeatEvery(String value){
        String xpathListRepeatEvery = "//button[@data-id='repeat_every']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListRepeatEvery;
    }

    //TotalCycles of RepeatEvery
    public static String inputTotalCycles = "//input[@id='cycles']";
    public static String checkboxInfinity = "//input[@id='unlimited_cycles']";
    public static String labelCheckboxInfinity = "//label[@for='unlimited_cycles' and normalize-space()='Infinity']";

    public static String dropdownRelatedTo = "//button[@data-id='rel_type']";
    public static String getValueRelatedTo(String value){
        String xpathListRelatedTo = "//button[@data-id='rel_type']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListRelatedTo;
    }

    public static String dropdownForRelatedTo = "//button[@data-id='rel_id']";
    public static String inputSearchOfForRelatedTo = "//button[@data-id='rel_id']/following-sibling::div//input[@type='search']";
    public static String getValueForRelatedTo(String value){
        String xpathListForRelatedTo = "//button[@data-id='rel_id']/following-sibling::div//span[@class = 'text' and normalize-space()='"+value+"']";
        return xpathListForRelatedTo;
    }

    public static String dropdownAssignees = "//button[@data-id='assignees']";
    public static String inputSearchOffAssignees = "//button[@data-id='assignees']/following-sibling::div//input[@type='search']";
    public static String getValueAssignees(String value){
        String xpathListAssignees = "//button[@data-id='assignees']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListAssignees;
    }

    public static String dropdownFollowers = "//button[@data-id='followers[]']";
    public static String inputSearchOffFollowers = "//button[@data-id='followers[]']/following-sibling::div//input[@type='search']";
    public static String getValueFollowers(String value){
        String xpathListFollowers = "//button[@data-id='followers[]']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListFollowers;
    }


    public static String inputAddTags = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
   // public String dropdownTags = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']";
    public static String getValueTags(String value){
        String xpathListTag = "//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']";
        return xpathListTag;
    }

    public static String labelTags = "//label[@for='tags']";

    public static String textareaTaskDescription = "//iframe[@id='description_ifr']";

    public static String btnClose = "//form[@id='task-form']//button[normalize-space()='Close']";
    //public static String btnClose = "//h4[@id='myModalLabel']/parent::div/following-sibling::div[@class='modal-footer']/button[normalize-space()='Close']";
    public static String btnSave = "//button[normalize-space()='Save']";

    public static String headerEdit = "//div[@id='task-modal']//div[contains(@class,'modal-header')]//h4";

}

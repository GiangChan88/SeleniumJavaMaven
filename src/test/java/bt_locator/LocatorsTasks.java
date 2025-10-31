package bt_locator;

public class LocatorsTasks {

    public String url = "https://crm.anhtester.com/admin/authentication";

    //Locators Login
    public static String headerLogin = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[@type='submit']";
    public static String checkboxRememberMe = "//input[@id = 'remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String alertErrorMessage = "//div[contains(@class, 'alert-danger')]";
    public static String alertErrorEmailRequired = "//div[normalize-space() = 'The Email Address field is required.']";
    public static String alertErrorPasswordRequired = "//div[normalize-space() = 'The Password field is required.']";

    //menu Dashboard
    public static String menuDashboard = "//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Dashboard']";

    //locators menu tasks
    public static String menuTasks = "//span[normalize-space()='Tasks']";
    public static String btnAddTasks = "//a[normalize-space() = 'New Task']";

    //locators Add New Tasks
    public static String titleAddNewTask = "//h4[@id='myModalLabel']";
    public static String iconCloseAddNewTask = "//h4[@id='myModalLabel']/preceding-sibling::button";

    public static String checkboxPublic = "//input[@id='task_is_public']";
    public static String checkboxBillsble = "//input[@id='task_is_billable']";
    public static String linkAttachFile = "//a[normalize-space()='Attach Files']";

    public static String inputFileAttachment = "//input[@type='file']";
    public static String btnAddMoreAttachment = "//button[contains(@class,'add_more_attachments')]";
    public static String btnRemoveAttachmemt = "//button[contains(@class,'remove_attachment')]";

    public static String inputSubject = "//input[@id='name']";

    public static String inputHourlyRate = "//input[@id='hourly_rate']";

    public static String inputStartDate = "//input[@id='startdate']";
    public static String iconStartDate = "//input[@id='startdate']/following-sibling::div/i";

    public static String inputDuaDate = "//input[@id='duedate']";
    public static String iconDuaDate = "//input[@id='duedate']/following-sibling::div/i";

    public static String dropdownPriority = "//button[@data-id='priority']";
    public static String dropdownListPriority(String value){
        String xpathListPriority = "//button[@data-id='priority']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListPriority;
    }

    public static String dropdownRepeatEvery = "//button[@data-id='repeat_every']";
    public static String dropdownListRepeatEvery(String value){
        String xpathListRepeatEvery = "//button[@data-id='repeat_every']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListRepeatEvery;
    }

    public static String dropdownRelatedTo = "//button[@data-id='rel_type']";
    public static String dropdownListRelatedTo(String value){
        String xpathListRelatedTo = "//button[@data-id='rel_type']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListRelatedTo;
    }

    public static String dropdownForRelatedTo = "//button[@data-id='rel_id']";
    public static String inputSearchOfForRelatedTo = "//button[@data-id='rel_id']/following-sibling::div//input[@type='search']";
    public static String dropdownListForRelatedTo(String value){
        String xpathListForRelatedTo = "//button[@data-id='rel_id']/following-sibling::div//span[@class = 'text' and normalize-space()='"+value+"']";
        return xpathListForRelatedTo;
    }

    public static String dropdownAssignees = "//button[@data-id='assignees']";
    public static String inputSearchOffAssignees = "//button[@data-id='assignees']/following-sibling::div//input[@type='search']";
    public static String dropdownListAssignees(String value){
        String xpathListAssignees = "//button[@data-id='assignees']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return value;
    }

    public static String dropdownFollowers = "//button[@data-id='followers[]']";
    public static String inputSearchOffFollowers = "//button[@data-id='followers[]']/following-sibling::div//input[@type='search']";
    public static String dropdownListFollowers(String value){
        String xpathListFollowers = "/button[@data-id='followers[]']/following-sibling::div//span[@class='text' and normalize-space()='"+value+"']";
        return xpathListFollowers;
    }


    public String inputAddTags = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public String dropdownTags = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']";
    public static String dropdownListTags(String value){
        String xpathListTag = "//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']";
        return xpathListTag;
    }

    public static String textareaTaskDescription = "//iframe[@id='description_ifr']";

    public static String btnClose = "//form[@id='task-form']//button[normalize-space()='Close']";
    public static String btnSave = "//button[normalize-space()='Save']";


}

package bt_locator;

public class LocatorsTasks {

    public String url = "https://crm.anhtester.com/admin/authentication";

    //Locators Login
    public String headerLogin = "//h1[normalize-space()='Login']";
    public String inputEmail = "//input[@id='email']";
    public String inputPassword = "//input[@id='password']";
    public String buttonLogin = "//button[@type='submit']";
    public String checkboxRememberMe = "//input[@id = 'remember']";
    public String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public String alertErrorMessage = "//div[contains(@class, 'alert-danger')]";
    public String alertErrorEmailRequired = "//div[normalize-space() = 'The Email Address field is required.']";
    public String alertErrorPasswordRequired = "//div[normalize-space() = 'The Password field is required.']";

    //menu Dashboard
    public static String menuDashboard = "//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Dashboard']";

    //locators menu tasks
    public String menuTasks = "//span[normalize-space()='Tasks']";
    public String btnAddTasks = "//a[normalize-space() = 'New Task']";

    //locators Add New Tasks
    public String titleAddNewTask = "//h4[@id='myModalLabel']";
    public String iconCloseAddNewTask = "//h4[@id='myModalLabel']/preceding-sibling::button";

    public String checkboxPublic = "//input[@id='task_is_public']";
    public String checkboxBillsble = "//input[@id='task_is_billable']";
    public String linkAttachFile = "//a[normalize-space()='Attach Files']";

    public String inputFileAttachment = "//input[@type='file']";
    public String btnAddMoreAttachment = "//button[contains(@class,'add_more_attachments')]";
    public String btnRemoveAttachmemt = "//button[contains(@class,'remove_attachment')]";

    public String inputSubject = "//input[@id='name']";

    public String inputHourlyRate = "//input[@id='hourly_rate']";

    public String inputStartDate = "//input[@id='startdate']";
    public String iconStartDate = "//input[@id='startdate']/following-sibling::div/i";

    public String inputDuaDate = "//input[@id='duedate']";
    public String iconDuaDate = "//input[@id='duedate']/following-sibling::div/i";

    public String dropdownPriority = "//button[@data-id='priority']";
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

    public String textareaTaskDescription = "//iframe[@id='description_ifr']";

    public String btnClose = "//form[@id='task-form']//button[normalize-space()='Close']";
    public String btnSave = "//button[normalize-space()='Save']";








}

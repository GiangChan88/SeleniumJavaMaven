package bt_locator;

public class LocatorsLeads {
    public String url = "https://crm.anhtester.com/admin/authentication";

    //Locators Login
    public static String headerLogin = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[@type='submit']";
    public static String checkboxRememberMe = "//input[@id = 'remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String errorMessageInvalidEmailorPassword = "//div[@id='alerts']/div";
    public static String errorEmailRequired = "//div[normalize-space() = 'The Email Address field is required.']";
    public static String errorPasswordRequired = "//div[normalize-space() = 'The Password field is required.']";

    //menu Dashboard
    public static String menuDashboard = "//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Dashboard']";

    //locators menu Leads
    public static String menuLeads = "//span[@class = 'menu-text' and normalize-space() = 'Leads']";

    //locator for Leads Page
    public static String buttonNewLead = "//a[normalize-space()='New Lead']";
    public static String buttonLeadsSummary = "//a[@data-title='Leads Summary']";
    public static String buttonKanban = "//a[@data-title='Switch to Kanban']";
    public static String buttonFilterBy = "//div[@id='vueApp']//button[@type='button']";
    public static String dropdownLeadLength = "//select[@name ='leads_length']";
    public static String buttonExport = "//button[normalize-space() = 'Export']";
    public static String buttonBulkActions = "//button[normalize-space() = 'Bulk Actions']";
    public static String buttonReload = "//button[contains(@class, 'btn-dt-reload')]";
    public static String inputSearch = "//div[@id='leads_filter']//input[@type='search']";

    //header
    public static String checkboxAll = "//input[@id='mass_select_all']";
    public static String headerNumber = "//table[@id='leads']/thead//th[@id='th-number']";
    public static String headerName = "//table[@id='leads']/thead//th[@id='th-name']";
    public static String headerCompany = "//table[@id='leads']/thead//th[@id='th-company']";
    public static String headerEmail = "//table[@id='leads']/thead//th[@id='th-email']";
    public static String headerPhone = "//table[@id='leads']/thead//th[@id='th-phone']";
    public static String headerValue = "//table[@id='leads']/thead//th[@id='th-lead-value']";
    public static String headerTags = "//table[@id='leads']/thead//th[@id='th-tags']";
    public static String headerAssigned = "//table[@id='leads']/thead//th[@id='th-assigned']";
    public static String headerStatus = "//table[@id='leads']/thead//th[@id='th-status']";
    public static String headerSource = "//table[@id='leads']/thead//th[@id='th-source']";
    public static String headerLastContact = "//table[@id='leads']/thead//th[@id='th-last-contact']";
    public static String headerCreated = "//table[@id='leads']/thead//th[@id='th-date-created']";

    public static String buttonView(String leadName){
        String xpath = "//td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='View']";
        return xpath;
    }

    public static String buttonEdit(String leadName){
        String xpath = "//td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='Edit']";
        return xpath;
    }

    public static String buttonDelete(String leadName){
        String xpath = "//td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='Delete']";
        return xpath;
    }

    public static String buttonPrevious = "//div[@id= 'leads_paginate']//a[text()='Previous']";
    public static String buttonNumber = "//div[@id='leads_paginate']//li[@class='paginate_button active']";//saiii
    public static String buttonNext = "//div[@id= 'leads_paginate']//a[text()='Next']";
    public static String dropdownJumpLead = "//select[@id= 'dt-page-jump-leads']";

    //leads summary
    //driver.findElement(By.xpath("//a[@data-title='Leads Summary']")).click();
    public static String titleLeadsSummary = "//h4[normalize-space()='Leads Summary']";

    public static String stringValueActive = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']";
    public static String numberValueActive = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']/preceding-sibling::span";

    public static String stringValuejjjj = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'jjjj']";
    public static String numberValuejjjj = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'jjjj']/preceding-sibling::span";

    public static String stringValueCustomer = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']";
    public static String numberValueCustomer = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']/preceding-sibling::span";

    public static String stringValueLostLead = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Lost Leads']";
    public static String numberValueLostLead = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Lost Leads']//preceding-sibling::span";


    //ADD NEW LEAD
    public static String btnAddLead = "//a[normalize-space()='New Lead']";
    public static String titleAddNewLead = "//h4[normalize-space() ='Add new lead']";
    public static String iconCloseAddNewLead = "//div[@id='leads_bulk_actions']/descendant::button[@class='close']";

    public static String dropdownStatus = "//button[@data-id='status']";
    public static String inputSearchOfStatus = "//button[@data-id='status']/following-sibling::div//input[@type='search']";
    public static String dropdownListStatus(String value){
        String xpath = "//button[@data-id='status']/following-sibling::div//span[normalize-space()='"+value+"']";
        return xpath;
    }
    public static String buttonAddStatus = "//div[@app-field-wrapper='status']//div[@class= 'input-group-btn']";
    public static String inputAddStatus = "//input[@id='new_status_name']";

    public static String dropdownSource = "//button[@data-id='source']";
    public static String inputSearchOfSource = "//div[@app-field-wrapper='source']//input[@type='search']";
    public static String dropdownListSource(String value){
        String xpathListSource = "//button[@data-id='source']/following-sibling::div//span[normalize-space()='"+value+"']";
        return xpathListSource;
    }
    public static String buttonAddSource = "//div[@app-field-wrapper='source']//div[@class= 'input-group-btn']";
    public static String inputAddSource = "//input[@id='new_source_name']";

    public static String dropdownAssigned = "//button[@data-id='assigned']";
    public static String inputSearchOfAssigned = "//div[@app-field-wrapper='assigned']//input[@type='search']";
    public static String dropdownListAssigned(String value){
        String xpathListAssignes = "//button[@data-id='assigned']/following-sibling::div//span[normalize-space()='" + value + "']";
        return xpathListAssignes;
    }

    public static String inputAddTags = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public static String dropdownTags = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']";
    public static String dropdownListTags(String value){
        String xpathListTag = "//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']";
        return xpathListTag;
    }

    public static String inputName = "//div[@id ='tab_lead_profile']//input[@id='name']";
    public static String inputAddress = "//textarea[@id='address']";
    public static String inputPosition = "//input[@id='title']";
    public static String inputCity = "//input[@id='city']";
    public static String inputEmailAddress = "//input[@id='email']";
    public static String inputState = "//input[@id='state']";;
    public static String inputWebsite = "//input[@id='website']";

    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchOfCountry = "//div[@app-field-wrapper='country']//input[@type='search']";
    public static String dropdownListCountry(String value) {
        String xpathListCountry = "//button[@data-id='country']/following::span[@class='text' and normalize-space()='"+value+"']";
        return xpathListCountry;
    }
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputZipCode = "//input[@id='zip']";
    public static String inputLeadValue = "//input[@name='lead_value']";
    public static String iconLeadValue = "//input[@name='lead_value']/following-sibling::div";

    public static String dropdownDefaultLanguage = "//button[@data-id='default_language']";
    public static String inputSearchOfDefaultLanguage = "//div[contains(@class,'bs3 dropup open')]//input[@type='search']";
    public static String dropdownListDefaultLanguage(String value){
        String xpathListDefaultLanguage = "//button[@data-id='default_language']/following::span[@class='text' and normalize-space()='"+value+"']";
        return xpathListDefaultLanguage;
    }

    public static String inputCompany = "//textarea[@id='company']";
    public static String inputDescription = "//input[@id='description']";
    public static String checkboxPublic = "//input[@id='lead_public']";
    public static String inputDateContacted = "//input[@id='custom_contact_date']";
    public static String calendarDateContacted = "//div[@app-field-wrapper='custom_contact_date']//i[contains(@class,'fa-calendar')]";
    public static String inputContactedToday = "//input[@id='contacted_today']";

    public static String buttonClose= "//div[@id ='tab_lead_profile']//button[normalize-space()='Close']";
    public static String buttonSave = "//button[@id = 'lead-form-submit']";


}
